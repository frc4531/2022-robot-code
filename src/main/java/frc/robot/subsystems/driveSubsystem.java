package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;


public class driveSubsystem extends SubsystemBase {
    public static WPI_TalonFX frontLeft;
    public static WPI_TalonFX frontRight;
    public static WPI_TalonFX backLeft;
    public static WPI_TalonFX backRight;
    public static MecanumDrive driveTrain;
    public static AHRS driveGyro;

    
    public driveSubsystem() {
        driveGyro = new AHRS(SerialPort.Port.kUSB);
        
        frontLeft = new WPI_TalonFX(1);
        frontLeft.setInverted(true);
        //frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

        frontRight = new WPI_TalonFX(2);
        //frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

        backLeft = new WPI_TalonFX(3);
        backLeft.setInverted(true);
        //backLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

        backRight = new WPI_TalonFX(4);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

        driveTrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
        addChild("driveTrain",driveTrain);
        driveTrain.setSafetyEnabled(true);
        driveTrain.setExpiration(0.1);
        driveTrain.setMaxOutput(0.9);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("BR Encoder Position", getPosition());
        SmartDashboard.putNumber("Tilt", driveGyro.getRoll());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    // Put methods for controlling this subsystem here. Call these from Commands.
    public static double getPosition() {
        return backRight.getSelectedSensorPosition();
    }

    public double getVelocity() {
        return backRight.getSelectedSensorVelocity();
    }

    public static void resetEncoder() {
        backRight.setSelectedSensorPosition(0);
    }

    public static double readHeading() {
    	double gyroVal = driveGyro.getYaw(); //getAngle
    	SmartDashboard.putNumber("Drive Gyro Value", gyroVal);
    	return gyroVal;
    }

    public static void resetGyro() {
    	//driveGyro.reset();
    	driveGyro.zeroYaw();
    }
}

