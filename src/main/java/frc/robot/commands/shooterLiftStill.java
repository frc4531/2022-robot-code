package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterLiftSubsystem;



public class shooterLiftStill extends CommandBase {

    private final shooterLiftSubsystem m_shooterLiftSubsystem;

    public shooterLiftStill(shooterLiftSubsystem subsystem) {

        m_shooterLiftSubsystem = subsystem;
        addRequirements(m_shooterLiftSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooterLiftSubsystem.shooterLift.set(0);
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
