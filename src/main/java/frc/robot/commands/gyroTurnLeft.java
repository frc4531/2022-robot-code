package frc.robot.commands;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.driveSubsystem;

public class gyroTurnLeft extends CommandBase {

    private final driveSubsystem m_driveSubsystem;

    double speed;

    double initialAngle;
    double currentAngle;
    double goalAngle;
 
    public gyroTurnLeft(driveSubsystem subsystem, double goalAngle) {

        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);

        this.goalAngle = goalAngle;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    	speed = Preferences.getDouble("Gyro Turn Speed", 0.1);
        initialAngle = driveSubsystem.readHeading();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        currentAngle = driveSubsystem.readHeading();
        SmartDashboard.putNumber("Gyro Angle", currentAngle);
    	
    	driveSubsystem.driveTrain.driveCartesian(0, 0, -speed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        driveSubsystem.driveTrain.driveCartesian(0, 0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return currentAngle <= (initialAngle - goalAngle);
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
