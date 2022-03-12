package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterAngleSubsystem;


public class shooterAngleToPosition extends CommandBase {
    private final shooterAngleSubsystem m_shooterAngleSubsystem;
 

    double position;
    double moveSpeed = 0.5;


    public shooterAngleToPosition(shooterAngleSubsystem subsystem, double position) {
        m_shooterAngleSubsystem = subsystem;
        addRequirements(m_shooterAngleSubsystem);

        this.position = position;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_shooterAngleSubsystem.getPosition() < position) {
            shooterAngleSubsystem.shooterAngler.set(moveSpeed);
        } else if (m_shooterAngleSubsystem.getPosition() > position && m_shooterAngleSubsystem.limitSwitch.get()) {
            shooterAngleSubsystem.shooterAngler.set(-moveSpeed);
        } else {
        shooterAngleSubsystem.shooterAngler.set(0);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        shooterAngleSubsystem.shooterAngler.set(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_shooterAngleSubsystem.getPosition() == position;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
