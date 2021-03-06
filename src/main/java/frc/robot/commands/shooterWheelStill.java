package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterWheelSubsystem;

public class shooterWheelStill extends CommandBase {

    private final shooterWheelSubsystem m_shooterWheelSubsystem;
 
    public shooterWheelStill(shooterWheelSubsystem subsystem) {

        m_shooterWheelSubsystem = subsystem;
        addRequirements(m_shooterWheelSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooterWheelSubsystem.shooterWheel.set(0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
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
