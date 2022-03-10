package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.climberTraverseSubsystem;

public class climberTraverseForward extends CommandBase {

  private final climberTraverseSubsystem m_climberTraverseSubsystem;

  public climberTraverseForward(climberTraverseSubsystem subsystem) {
    m_climberTraverseSubsystem = subsystem;
    addRequirements(m_climberTraverseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climberTraverseSubsystem.climberTraverseMotor.set(0.8);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

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
