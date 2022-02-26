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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX frontLeft;
private WPI_TalonFX frontRight;
private WPI_TalonFX backLeft;
private WPI_TalonFX backRight;
public static MecanumDrive driveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public driveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
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

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public double getPosition() {
        return backRight.getSelectedSensorPosition();
    }

    public double getVelocity() {
        return backRight.getSelectedSensorVelocity();
    }
}

