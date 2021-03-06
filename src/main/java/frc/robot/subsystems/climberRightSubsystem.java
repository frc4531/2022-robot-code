// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climberRightSubsystem extends SubsystemBase {
  public static WPI_TalonFX climberRightMotor;
  /** Creates a new climberRightSubsystem. */
  public climberRightSubsystem() {
    climberRightMotor = new WPI_TalonFX(8);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
