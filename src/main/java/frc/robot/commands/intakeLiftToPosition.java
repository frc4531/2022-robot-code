package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeLiftSubsystem;

public class intakeLiftToPosition extends CommandBase {
  private final intakeLiftSubsystem m_intakeLiftSubsystem;

  double position;
  double moveSpeed = 0.5;
  double movementThreshold = 10;

  public intakeLiftToPosition(intakeLiftSubsystem subsystem, double position) {
    m_intakeLiftSubsystem = subsystem;
    addRequirements(m_intakeLiftSubsystem);

    this.position = position;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_intakeLiftSubsystem.getPosition() < position) {
      intakeLiftSubsystem.intakeLiftMotor.set(moveSpeed);
    } else if (m_intakeLiftSubsystem.getPosition() > position) {
      intakeLiftSubsystem.intakeLiftMotor.set(-moveSpeed);
    } else {
      intakeLiftSubsystem.intakeLiftMotor.set(0);
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeLiftSubsystem.intakeLiftMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ((m_intakeLiftSubsystem.getPosition() < position + movementThreshold) && (m_intakeLiftSubsystem.getPosition() > position - movementThreshold));
  }

  @Override
  public boolean runsWhenDisabled() {
    return false;
  }
}
