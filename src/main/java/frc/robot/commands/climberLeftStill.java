package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.climberLeftSubsystem;


public class climberLeftStill extends CommandBase {

    private final climberLeftSubsystem m_climberLeftSubsystem;
 
    public climberLeftStill(climberLeftSubsystem subsystem) {

        m_climberLeftSubsystem = subsystem;
        addRequirements(m_climberLeftSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        climberLeftSubsystem.climberLeftMotor.set(0);
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
