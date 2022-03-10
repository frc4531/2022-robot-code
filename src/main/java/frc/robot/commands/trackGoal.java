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
 
    boolean doneTracking = false;
    boolean hitLimitSwitch = false;

    double turnSensitivity = 0.05;
    double maxSpeed = 0.3;


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
        double turn = m_visionSubsystem.visX*turnSensitivity*-1;
        if (turn > maxSpeed) {
            turn = maxSpeed;
        } else if (turn < -maxSpeed) {
            turn = -maxSpeed;
        }

        SmartDashboard.putNumber("Tracking Turn Value", turn);

        driveSubsystem.driveTrain.driveCartesian(0, 0, turn);

        double angle = m_visionSubsystem.visY/*Limit Switch Value*/;
        if (m_visionSubsystem.visY > 0) {
            shooterAngleSubsystem.shooterAngler.isFwdLimitSwitchClosed();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return doneTracking;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
