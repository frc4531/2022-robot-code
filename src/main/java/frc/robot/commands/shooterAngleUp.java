package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterAngleSubsystem;


public class shooterAngleUp extends CommandBase {

    private final shooterAngleSubsystem m_shooterAngleSubsystem;
 
    public shooterAngleUp(shooterAngleSubsystem subsystem) {

        m_shooterAngleSubsystem = subsystem;
        addRequirements(m_shooterAngleSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooterAngleSubsystem.shooterAngler.set(0.6);
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
