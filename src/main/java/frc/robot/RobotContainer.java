// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final climberRightSubsystem m_climberRightSubsystem = new climberRightSubsystem();
    public final climberLeftSubsystem m_climberLeftSubsystem = new climberLeftSubsystem();
    public final intakeSubsystem m_intakeSubsystem = new intakeSubsystem();
    public final elevatorSubsystem m_elevatorSubsystem = new elevatorSubsystem();
    public final shooterLiftSubsystem m_shooterLiftSubsystem = new shooterLiftSubsystem();
    public final shooterAngleSubsystem m_shooterAngleSubsystem = new shooterAngleSubsystem();
    public final shooterTurretSubsystem m_shooterTurretSubsystem = new shooterTurretSubsystem();
    public final shooterWheelSubsystem m_shooterWheelSubsystem = new shooterWheelSubsystem();
    public final visionSubsystem m_visionSubsystem = new visionSubsystem();
    public final driveSubsystem m_driveSubsystem = new driveSubsystem();

// Joysticks
private final Joystick nesStick = new Joystick(1);
private final Joystick driveStick = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveSubsystem.setDefaultCommand(new driveCommand( m_driveSubsystem ) );
    m_shooterWheelSubsystem.setDefaultCommand(new shooterWheelStill( m_shooterWheelSubsystem ) );
    m_shooterTurretSubsystem.setDefaultCommand(new shooterTurretStill( m_shooterTurretSubsystem ) );
    m_shooterAngleSubsystem.setDefaultCommand(new shooterAngleStill( m_shooterAngleSubsystem ) );
    m_shooterLiftSubsystem.setDefaultCommand(new shooterLiftStill( m_shooterLiftSubsystem ) );
    m_elevatorSubsystem.setDefaultCommand(new elevatorStill( m_elevatorSubsystem ) );
    m_intakeSubsystem.setDefaultCommand(new intakeStill( m_intakeSubsystem ) );
    m_climberLeftSubsystem.setDefaultCommand(new climberLeftStill( m_climberLeftSubsystem ) );
    m_climberRightSubsystem.setDefaultCommand(new climberRightStill( m_climberRightSubsystem ) );


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("autoCommand", new autoCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton climberLeftUpBotton = new JoystickButton(driveStick, 5);        
climberLeftUpBotton.whileHeld(new climberLeftUp( m_climberLeftSubsystem ) ,true);
    SmartDashboard.putData("climberLeftUpBotton",new climberLeftUp( m_climberLeftSubsystem ) );

final JoystickButton climberLeftDownButton = new JoystickButton(driveStick, 10);        
climberLeftDownButton.whileHeld(new climberLeftDown( m_climberLeftSubsystem ) ,true);
    SmartDashboard.putData("climberLeftDownButton",new climberLeftDown( m_climberLeftSubsystem ) );

final JoystickButton climberRightUpButton = new JoystickButton(driveStick, 7);        
climberRightUpButton.whileHeld(new climberRightUp( m_climberRightSubsystem ) ,true);
    SmartDashboard.putData("climberRightUpButton",new climberRightUp( m_climberRightSubsystem ) );

final JoystickButton climberRightDownButton = new JoystickButton(driveStick, 8);        
climberRightDownButton.whileHeld(new climberRightDown( m_climberRightSubsystem ) ,true);
    SmartDashboard.putData("climberRightDownButton",new climberRightDown( m_climberRightSubsystem ) );

final JoystickButton shooterWheelShootButton = new JoystickButton(nesStick, 1);        
shooterWheelShootButton.toggleWhenPressed(new shooterWheelShoot( m_shooterWheelSubsystem ) ,true);
    SmartDashboard.putData("shooterWheelShootButton",new shooterWheelShoot( m_shooterWheelSubsystem ) );

final JoystickButton shooterTurretLeftButton = new JoystickButton(nesStick, 1);        
shooterTurretLeftButton.whileHeld(new shooterTurretLeft( m_shooterTurretSubsystem ) ,true);
    SmartDashboard.putData("shooterTurretLeftButton",new shooterTurretLeft( m_shooterTurretSubsystem ) );

final JoystickButton shooterTurretRightButton = new JoystickButton(nesStick, 1);        
shooterTurretRightButton.whileHeld(new shooterTurretRight( m_shooterTurretSubsystem ) ,true);
    SmartDashboard.putData("shooterTurretRightButton",new shooterTurretRight( m_shooterTurretSubsystem ) );

final JoystickButton shooterAngleUpButton = new JoystickButton(nesStick, 1);        
shooterAngleUpButton.whileHeld(new shooterAngleUp( m_shooterAngleSubsystem ) ,true);
    SmartDashboard.putData("shooterAngleUpButton",new shooterAngleUp( m_shooterAngleSubsystem ) );

final JoystickButton shooterAngleDownButton = new JoystickButton(nesStick, 1);        
shooterAngleDownButton.whileHeld(new shooterAngleDown( m_shooterAngleSubsystem ) ,true);
    SmartDashboard.putData("shooterAngleDownButton",new shooterAngleDown( m_shooterAngleSubsystem ) );

final JoystickButton shooterLiftUpButton = new JoystickButton(nesStick, 1);        
shooterLiftUpButton.whileHeld(new shooterLiftUp( m_shooterLiftSubsystem ) ,true);
    SmartDashboard.putData("shooterLiftUpButton",new shooterLiftUp( m_shooterLiftSubsystem ) );

final JoystickButton shooterLiftDownButton = new JoystickButton(nesStick, 1);        
shooterLiftDownButton.whileHeld(new shooterLiftDown( m_shooterLiftSubsystem ) ,true);
    SmartDashboard.putData("shooterLiftDownButton",new shooterLiftDown( m_shooterLiftSubsystem ) );

final JoystickButton elevatorUpButton = new JoystickButton(nesStick, 1);        
elevatorUpButton.whileHeld(new elevatorUp( m_elevatorSubsystem ) ,true);
    SmartDashboard.putData("elevatorUpButton",new elevatorUp( m_elevatorSubsystem ) );

final JoystickButton elevatorDownButton = new JoystickButton(nesStick, 1);        
elevatorDownButton.whileHeld(new elevatorDown( m_elevatorSubsystem ) ,true);
    SmartDashboard.putData("elevatorDownButton",new elevatorDown( m_elevatorSubsystem ) );

final JoystickButton intakeInButton = new JoystickButton(nesStick, 1);        
intakeInButton.whileHeld(new intakeIn( m_intakeSubsystem ) ,true);
    SmartDashboard.putData("intakeInButton",new intakeIn( m_intakeSubsystem ) );

final JoystickButton intakeOutButton = new JoystickButton(nesStick, 1);        
intakeOutButton.whileHeld(new intakeOut( m_intakeSubsystem ) ,true);
    SmartDashboard.putData("intakeOutButton",new intakeOut( m_intakeSubsystem ) );



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getdriveStick() {
        return driveStick;
    }

public Joystick getnesStick() {
        return nesStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}
