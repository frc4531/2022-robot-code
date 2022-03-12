package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class trackGoal extends CommandBase {
    private final visionSubsystem m_visionSubsystem;
    private final driveSubsystem m_driveSubsystem;
    private final shooterAngleSubsystem m_shooterAngleSubsystem;
    private final shooterWheelSubsystem m_shooterWheelSubsystem;
 
    boolean doneTrackingX = false; //Has the X axis finished tracking
    boolean doneTrackingY = false; //Has the Y axis finished tracking

    double turnSensitivity = 0.04; //Sensitivity constant for robot drive train
    double maxSpeed = 0.3; //Speed to turn robot at

    double anglerTargetPosition; //Target position/angle
    double anglerSpeed = 0.5; //Speed to move the angler motor at

    //Min and max camera Y values
    double farCameraY = -20.42;
    double closeCameraY = 4.89;

    //Min and max angler position
    double minAnglerPosition = 0;
    double maxAnglerPosition = 5727; //Subtract 73 from actual value here

    double trackedThreshold = 10;


    public trackGoal(visionSubsystem vision_subsystem, driveSubsystem drive_subsystem, shooterAngleSubsystem shooterAngleSubsystem, shooterWheelSubsystem shooterWheelSubsystem) {
        
        m_visionSubsystem = vision_subsystem;
        m_driveSubsystem = drive_subsystem;
        m_shooterAngleSubsystem = shooterAngleSubsystem;
        m_shooterWheelSubsystem = shooterWheelSubsystem;

        addRequirements(m_visionSubsystem);
        addRequirements(m_driveSubsystem);
        addRequirements(m_shooterAngleSubsystem);
        addRequirements(m_shooterWheelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // ------- SPIN UP SHOOTER WHEEL -------
        shooterWheelSubsystem.shooterWheel.set(-0.8);

        // Only track the target if there is a target to track
        if(m_visionSubsystem.visV == 1) {
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
            anglerTargetPosition = (m_visionSubsystem.visY - closeCameraY) * (maxAnglerPosition / farCameraY);
            // -------ADJUST ANGLER BASED ON VISION Y VALUE: MOVE MOTOR -------

            //if motor needs to move up, and we haven't hit our max angle possible
            if (m_shooterAngleSubsystem.getPosition() < anglerTargetPosition && m_shooterAngleSubsystem.getPosition() <= maxAnglerPosition) {
                shooterAngleSubsystem.shooterAngler.set(anglerSpeed);

            //if motor needs to move down, and the bottom limit switch isn't pressed
            } else if (m_shooterAngleSubsystem.getPosition() > anglerTargetPosition && m_shooterAngleSubsystem.limitSwitch.get()) {
                shooterAngleSubsystem.shooterAngler.set(-anglerSpeed);

            //otherwise default to not moving
            } else {
                shooterAngleSubsystem.shooterAngler.set(0);
            }
            
            // ------- DETERMINE/SIGNAL WHEN TRACKING IS COMPLETE -------

            //if current X position is within acceptable range, mark X tracking as complete
            if (m_visionSubsystem.visX < trackedThreshold && m_visionSubsystem.visX > -trackedThreshold) {
                doneTrackingX = true;
            } else {
                doneTrackingX = false;
            }

            //if current Y position is within acceptable range, mark Y tracking as complete
            if (m_shooterAngleSubsystem.getPosition() < anglerTargetPosition + trackedThreshold && m_shooterAngleSubsystem.getPosition() > anglerTargetPosition - trackedThreshold) {
                doneTrackingY = true;
            } else {
                doneTrackingY = false;
            }

            //Send signal if X and Y are both lined up
            if (doneTrackingX && doneTrackingY) {
                m_visionSubsystem.isLinedUp = true;
                m_visionSubsystem.ledBlinkin.set(0.77);
            } else {
                m_visionSubsystem.isLinedUp = false;
                m_visionSubsystem.ledBlinkin.set(0.61);
            }
        }
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        //End if X and Y tracking are both complete
        return (doneTrackingX && doneTrackingY);
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
