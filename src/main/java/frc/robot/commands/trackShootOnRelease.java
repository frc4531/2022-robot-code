// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class trackShootOnRelease extends ParallelDeadlineGroup {
  /** Creates a new trackShootOnRelease. */
  public trackShootOnRelease() {
    // Add the deadline command in the super() call. Add other commands using
    // addCommands().
    super(new WaitCommand(3));
    addCommands(
      new trackGoal(RobotContainer.getInstance().m_visionSubsystem, RobotContainer.getInstance().m_driveSubsystem, RobotContainer.getInstance().m_shooterAngleSubsystem),
      new shooterWheelShoot(RobotContainer.getInstance().m_shooterWheelSubsystem),
      new shooterLiftUp(RobotContainer.getInstance().m_shooterLiftSubsystem)
    );
    
      
    // addCommands(new FooCommand(), new BarCommand());
  }
}
