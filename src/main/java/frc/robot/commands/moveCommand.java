package frc.robot.commands;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.driveSubsystem;

public class moveCommand extends CommandBase {

    private final driveSubsystem m_driveSubsystem;

    double xSpeed;
    double ySpeed;
    double zSpeed;

    public moveCommand(driveSubsystem subsystem, double x, double y, double z) {
        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);

        this.xSpeed = x;
        this.ySpeed = -y;
        this.zSpeed = z;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        driveSubsystem.driveTrain.driveCartesian(ySpeed, xSpeed, zSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        driveSubsystem.driveTrain.driveCartesian(0, 0, 0);
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
