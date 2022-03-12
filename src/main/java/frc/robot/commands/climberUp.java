package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.climberSubsystem;

public class climberUp extends CommandBase {

    private final climberSubsystem m_climberSubsystem;
 
    public climberUp(climberSubsystem subsystem) {

        m_climberSubsystem = subsystem;
        addRequirements(m_climberSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        climberSubsystem.climberLeftMotor.set(0.8);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
