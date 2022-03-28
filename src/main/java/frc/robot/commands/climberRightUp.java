// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climberRightSubsystem;

public class climberRightUp extends CommandBase {

  private final climberRightSubsystem m_climberRightSubsystem;

  public climberRightUp(climberRightSubsystem subsystem) {

      m_climberRightSubsystem = subsystem;
      addRequirements(m_climberRightSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      climberRightSubsystem.climberRightMotor.set(0.8);
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
