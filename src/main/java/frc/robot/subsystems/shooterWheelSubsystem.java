package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class shooterWheelSubsystem extends SubsystemBase {
    public static WPI_TalonFX shooterWheel;


    public shooterWheelSubsystem() {
        shooterWheel = new WPI_TalonFX(5);
        shooterWheel.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Shooter Wheel Velocity", getVelocity());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    // Put methods for controlling this subsystem here. Call these from Commands.
    public double getVelocity() {
        return shooterWheel.getSelectedSensorVelocity();
    }
}

