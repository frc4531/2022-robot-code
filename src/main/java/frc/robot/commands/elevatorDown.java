package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.elevatorSubsystem;

public class elevatorDown extends CommandBase {

    private final elevatorSubsystem m_elevatorSubsystem;
 
    public elevatorDown(elevatorSubsystem subsystem) {

        m_elevatorSubsystem = subsystem;
        addRequirements(m_elevatorSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        elevatorSubsystem.elevatorLMotor.set(-0.9);
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
