package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class intakeLiftSubsystem extends SubsystemBase {
    public static WPI_TalonSRX intakeLiftMotor;
    private Encoder intakeLiftEncoder;
    

    public intakeLiftSubsystem() {
        intakeLiftMotor = new WPI_TalonSRX(16);

        intakeLiftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
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

    public void resetEncoder() {
        intakeLiftEncoder.reset();
    }

    public int getPosition() {
        int val = intakeLiftEncoder.get();
        SmartDashboard.putNumber("Intake Lift Encoder Value", val);
        return val;
    }
}

