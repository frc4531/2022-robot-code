package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.shooterAngleSubsystem;
import frc.robot.subsystems.visionSubsystem;


public class trackGoal extends CommandBase {
    private final visionSubsystem m_visionSubsystem;
    private final driveSubsystem m_driveSubsystem;
    private final shooterAngleSubsystem m_shooterAngleSubsystem;
 
    boolean doneTrackingX = false;
    boolean doneTrackingY = false;

    double turnSensitivity = 0.05;
    double maxSpeed = 0.3;

    double anglerTargetPosition;
    double anglerSpeed = 0.5;

    double minCameraY = 0;
    double maxCameraY = 100;
    double minAnglerPosition = 0;
    double maxAnglerPosition = 500;


    public trackGoal(visionSubsystem vision_subsystem, driveSubsystem drive_subsystem, shooterAngleSubsystem shooterAngleSubsystem) {
        
        m_visionSubsystem = vision_subsystem;
        m_driveSubsystem = drive_subsystem;
        m_shooterAngleSubsystem = shooterAngleSubsystem;

        addRequirements(m_visionSubsystem);
        addRequirements(m_driveSubsystem);
        addRequirements(m_shooterAngleSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // -------TURN DRIVE TRAIN BASED ON VISION X VALUE -------
        double turn = m_visionSubsystem.visX*turnSensitivity*-1;
        if (turn > maxSpeed) {
            turn = maxSpeed;
        } else if (turn < -maxSpeed) {
            turn = -maxSpeed;
        }

        driveSubsystem.driveTrain.driveCartesian(0, 0, turn);
        // -------ADJUST ANGLER BASED ON VISION Y VALUE: CALCULATE POSITION -------
        anglerTargetPosition = (m_visionSubsystem.visY - minCameraY) * (maxAnglerPosition / maxCameraY);
        // -------ADJUST ANGLER BASED ON VISION Y VALUE: MOVE MOTOR -------
        if (m_shooterAngleSubsystem.getPosition() < anglerTargetPosition) {
            shooterAngleSubsystem.shooterAngler.set(anglerSpeed);
        } else if (m_shooterAngleSubsystem.getPosition() > anglerTargetPosition && m_shooterAngleSubsystem.limitSwitch.get()) {
            shooterAngleSubsystem.shooterAngler.set(-anglerSpeed);
        } else {
        shooterAngleSubsystem.shooterAngler.set(0);
        }
        //double anglerPosition = 0;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return doneTrackingX && doneTrackingY;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
