// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
public static WPI_TalonFX frontLeft;
public static WPI_TalonFX frontRight;
public static WPI_TalonFX backLeft;
public static WPI_TalonFX backRight;
public static MecanumDrive driveTrain;
public static AHRS driveGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public driveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        driveGyro = new AHRS(SerialPort.Port.kUSB);
        
        frontLeft = new WPI_TalonFX(1);
        frontLeft.setInverted(true);
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

frontRight = new WPI_TalonFX(2);
frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

backLeft = new WPI_TalonFX(3);
backLeft.setInverted(true);
backLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

backRight = new WPI_TalonFX(4);
backRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
 

driveTrain = new MecanumDrive(frontLeft, backLeft,
frontRight, backRight);
 addChild("driveTrain",driveTrain);
 driveTrain.setSafetyEnabled(true);
driveTrain.setExpiration(0.1);
driveTrain.setMaxOutput(0.9);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("BR Encoder Position", getPosition());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
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
    	double gyroVal = driveGyro.getAngle(); //getAngle
    	SmartDashboard.putNumber("Drive Gyro Value", gyroVal);
    	return gyroVal;
    }

    public static void resetGyro() {
    	//driveGyro.reset();
    	driveGyro.zeroYaw();
    }
}

