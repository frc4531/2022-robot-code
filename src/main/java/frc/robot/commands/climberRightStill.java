package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.climberRightSubsystem;


public class climberRightStill extends CommandBase {

    private final climberRightSubsystem m_climberRightSubsystem;
 
    public climberRightStill(climberRightSubsystem subsystem) {

        m_climberRightSubsystem = subsystem;
        addRequirements(m_climberRightSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        climberRightSubsystem.climberRightMotor.set(0);
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
