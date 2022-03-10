package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.intakeLiftSubsystem;


public class intakeLiftUp extends CommandBase {

    private final intakeLiftSubsystem m_intakeLiftSubsystem;
 
    public intakeLiftUp(intakeLiftSubsystem subsystem) {

        m_intakeLiftSubsystem = subsystem;
        addRequirements(m_intakeLiftSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intakeLiftSubsystem.intakeLiftMotor.set(0.6);
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
