package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class trackGoal extends CommandBase {
    private final visionSubsystem m_visionSubsystem;
    private final driveSubsystem m_driveSubsystem;
    private final shooterWheelSubsystem m_shooterWheelSubsystem;
 
    boolean doneTrackingX = false; //Has the X axis finished tracking
    boolean doneTrackingY = false; //Has the Y axis finished tracking

    double turnSensitivity = 0.04; //Sensitivity constant for robot drive train
    double maxSpeed = 0.3; //Speed to turn robot at

    //Min and max camera Y values
    double farCameraY = -23;
    double closeCameraY = -10;

    //Min and max angler position
    double minShooterVelocity = -11600;
    double maxShooterVelocity = -13450;
    
    double camRange = closeCameraY - farCameraY;
    double velocityRange = minShooterVelocity - maxShooterVelocity;
    double camToVelocityRatio = velocityRange / camRange;

    //Variables needed to set velocity for shooter
    double shooterTargetVelocity; //Target position/angle
    double shooterCurrentSpeed;
    double adjustInterval = 0.002;

    double trackedXThreshold = 100;
    double trackedYThreshold = 350;


    public trackGoal(visionSubsystem vision_subsystem, driveSubsystem drive_subsystem, shooterWheelSubsystem shooterWheelSubsystem) {
        
        m_visionSubsystem = vision_subsystem;
        m_driveSubsystem = drive_subsystem;
        m_shooterWheelSubsystem = shooterWheelSubsystem;

        addRequirements(m_visionSubsystem);
        addRequirements(m_driveSubsystem);
        addRequirements(m_shooterWheelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        shooterCurrentSpeed = -0.55;
        shooterTargetVelocity = -14000;
        m_shooterWheelSubsystem.resetEncoder();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        SmartDashboard.putNumber("Shooter Wheel Velocity", m_shooterWheelSubsystem.getVelocity());
        // ------- SPIN UP SHOOTER WHEEL TO TARGET VELOCITY (OLD) -------
        //if (m_shooterWheelSubsystem.getVelocity() < targetVelocity) {
        //    currentSpeed += adjustInterval;
        //} else if (m_shooterWheelSubsystem.getVelocity() > targetVelocity) {
        //    currentSpeed -= adjustInterval;
        //}

        //shooterWheelSubsystem.shooterWheel.set(currentSpeed);
        //shooterWheelSubsystem.shooterWheel.set(-0.8);

        // Only track the target if there is a target to track
        if(m_visionSubsystem.visV == 1 && m_visionSubsystem.visY <= closeCameraY && m_visionSubsystem.visY >= farCameraY) {
            // -------TURN DRIVE TRAIN BASED ON VISION X VALUE -------
            double turn = m_visionSubsystem.visX*turnSensitivity*-1; //determine turn value based on camera X axis & sensitivity constant 
            
            //Input validation for drive train - don't turn faster than the max speed
            if (turn > maxSpeed) {
                turn = maxSpeed;
            } else if (turn < -maxSpeed) {
                turn = -maxSpeed;
            }

            driveSubsystem.driveTrain.driveCartesian(0, 0, turn); //turn robot based on final turn value

            // -------ADJUST ANGLER BASED ON VISION Y VALUE: Map camera Y axis dataset to angler position dataset (linear) -------
            

            shooterTargetVelocity = ((m_visionSubsystem.visY - farCameraY) * camToVelocityRatio) + maxShooterVelocity;
            // -------ADJUST ANGLER BASED ON VISION Y VALUE: MOVE MOTOR -------
            SmartDashboard.putNumber("Target Velocity", shooterTargetVelocity);
            SmartDashboard.putNumber("Cam Velocity Ratio", camToVelocityRatio);
            //if shooter needs to speed up, and we haven't hit our max velocity
            if (m_shooterWheelSubsystem.getVelocity() < shooterTargetVelocity /*&& m_shooterWheelSubsystem.getVelocity() >= maxShooterVelocity*/) {
                shooterCurrentSpeed = shooterCurrentSpeed + adjustInterval;

            //if motor needs to move down, and the bottom limit switch isn't pressed
            } else if (m_shooterWheelSubsystem.getVelocity() > shooterTargetVelocity /*&& m_shooterWheelSubsystem.getVelocity() <= minShooterVelocity*/) {
                shooterCurrentSpeed = shooterCurrentSpeed - adjustInterval;

            //otherwise default to not moving
            }

            shooterWheelSubsystem.shooterWheel.set(shooterCurrentSpeed);
            
            // ------- DETERMINE/SIGNAL WHEN TRACKING IS COMPLETE -------

            //if current X position is within acceptable range, mark X tracking as complete
            if (m_visionSubsystem.visX < trackedXThreshold && m_visionSubsystem.visX > -trackedXThreshold) {
                doneTrackingX = true;
            } else {
                doneTrackingX = false;
            }

            //if currentshooter velocity is within acceptable range, mark Y tracking as complete
            if (m_shooterWheelSubsystem.getVelocity() < shooterTargetVelocity + trackedYThreshold && m_shooterWheelSubsystem.getVelocity() > shooterTargetVelocity - trackedYThreshold) {
                doneTrackingY = true;
            } else {
                doneTrackingY = false;
            }

            //Send signal if X and Y are both lined up
            if (doneTrackingX && doneTrackingY) {
                if (m_visionSubsystem.isLinedUp == false) {
                    m_visionSubsystem.ledBlinkin.set(0.77);
                }
                m_visionSubsystem.isLinedUp = true;
            } else {
                if(m_visionSubsystem.isLinedUp == true) {
                    m_visionSubsystem.ledBlinkin.set(0.61);
                }
                m_visionSubsystem.isLinedUp = false;
            }
        } else {
            driveSubsystem.driveTrain.driveCartesian(0, 0, 0);
        }
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_visionSubsystem.isLinedUp = false;
        m_visionSubsystem.ledBlinkin.set(0.61);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
