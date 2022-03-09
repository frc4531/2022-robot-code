package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class climberTraverseSubsystem extends SubsystemBase {
    public static WPI_TalonSRX climberTraverseMotor;

   
    public climberTraverseSubsystem() {
        climberTraverseMotor = new WPI_TalonSRX(11);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    // Put methods for controlling this subsystem here. Call these from Commands.

}

