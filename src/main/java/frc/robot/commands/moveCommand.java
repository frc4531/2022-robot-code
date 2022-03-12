package frc.robot.commands;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.driveSubsystem;

public class moveCommand extends CommandBase {

    private final driveSubsystem m_driveSubsystem;

    double finalDistance;
    double speed;

    public moveCommand(driveSubsystem subsystem, double finalDistance) {
        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);

        this.finalDistance = finalDistance;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        driveSubsystem.resetEncoder();
        speed = Preferences.getDouble("moveCommand Speed", 0.1);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        driveSubsystem.driveTrain.driveCartesian(speed, 0, 0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return driveSubsystem.getPosition() >= finalDistance;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
