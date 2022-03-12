package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class visionSubsystem extends SubsystemBase {
    public Spark ledBlinkin = new Spark(0);
    public boolean isLinedUp;

    NetworkTableEntry xEntry;
    NetworkTableEntry yEntry;
    NetworkTableEntry aEntry;
    NetworkTableEntry vEntry;

    public double visX;
    public double visY;
    public double visA;
    public double visV;

    
    public visionSubsystem() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("limelight");

        xEntry = table.getEntry("tx");
        yEntry = table.getEntry("ty");
        aEntry = table.getEntry("ta");
        vEntry = table.getEntry("tv");

        isLinedUp = false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        visX = xEntry.getDouble(0.0);
        visY = yEntry.getDouble(0.0);
        visA = aEntry.getDouble(0.0);
        visV = vEntry.getDouble(0.0);

        SmartDashboard.putNumber("Limelight X Value", visX);
        SmartDashboard.putNumber("Limelight Y Value", visY);
        SmartDashboard.putNumber("Limelight A Value", visA);
        SmartDashboard.putNumber("Limelight V Value", visV);
    }

    @Override
    public void simulationPeriodic() { // This method will be called once per scheduler run when in simulation

    }
    // Put methods for controlling this subsystem here. Call these from Commands.
    
}

