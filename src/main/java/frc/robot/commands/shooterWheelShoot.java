package frc.robot.commands;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterWheelSubsystem;

public class shooterWheelShoot extends CommandBase {

    double currentSpeed;
    double adjustInterval = 0.003;
    double targetVelocity;// = -14000;

    private final shooterWheelSubsystem m_shooterWheelSubsystem;
 
    public shooterWheelShoot(shooterWheelSubsystem subsystem) {

        m_shooterWheelSubsystem = subsystem;
        addRequirements(m_shooterWheelSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        currentSpeed = -0.8;
        targetVelocity = Preferences.getDouble("ShootVelocity", -10000);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_shooterWheelSubsystem.getVelocity() < targetVelocity) {
            currentSpeed += adjustInterval;
        } else if (m_shooterWheelSubsystem.getVelocity() > targetVelocity) {
            currentSpeed -= adjustInterval;
        }

        shooterWheelSubsystem.shooterWheel.set(currentSpeed);
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
