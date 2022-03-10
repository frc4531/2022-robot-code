package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.intakeSubsystem;

public class intakeOut extends CommandBase {

    private final intakeSubsystem m_intakeSubsystem;
 
    public intakeOut(intakeSubsystem subsystem) {

        m_intakeSubsystem = subsystem;
        addRequirements(m_intakeSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intakeSubsystem.intakeMotor.set(0.6);
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
