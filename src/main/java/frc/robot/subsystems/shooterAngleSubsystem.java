package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class shooterAngleSubsystem extends SubsystemBase {
    public static WPI_TalonSRX shooterAngler;
    public Encoder anglerEncoder;
    public DigitalInput limitSwitch;

    public shooterAngleSubsystem() {
        limitSwitch = new DigitalInput(4);

        shooterAngler = new WPI_TalonSRX(12);

        anglerEncoder = new Encoder(0, 1, false, EncodingType.k4X);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Angler Encoder Value", getPosition());
        SmartDashboard.putBoolean("Angler Encoder Pressed", limitSwitch.get());
        
        
        if (!limitSwitch.get()) {
            resetEncoder();
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation
    }
    // Put methods for controlling this subsystem here. Call these from Commands.

    public void resetEncoder() {
        anglerEncoder.reset();
    }

    public int getPosition() {
        int val = anglerEncoder.get();
        SmartDashboard.putNumber("Angler Encoder Value", val);
        return val;
    }
}

