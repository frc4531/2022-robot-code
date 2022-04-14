package frc.robot.commands;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.shooterWheelSubsystem;

public class shooterWheelBasicShot extends CommandBase {

    private final shooterWheelSubsystem m_shooterWheelSubsystem;
 
    public shooterWheelBasicShot(shooterWheelSubsystem subsystem) {

        m_shooterWheelSubsystem = subsystem;
        addRequirements(m_shooterWheelSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooterWheelSubsystem.shooterWheel.set(0.9);
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
