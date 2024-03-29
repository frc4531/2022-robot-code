package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;


public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // The robot's subsystems
    public final climberLeftSubsystem m_climberLeftSubsystem = new climberLeftSubsystem();
    public final climberRightSubsystem m_climberRightSubsystem = new climberRightSubsystem();
    public final climberTraverseSubsystem m_climberTraverseSubsystem = new climberTraverseSubsystem();
    public final intakeSubsystem m_intakeSubsystem = new intakeSubsystem();
    public final elevatorSubsystem m_elevatorSubsystem = new elevatorSubsystem();
    public final shooterLiftSubsystem m_shooterLiftSubsystem = new shooterLiftSubsystem();
    public final intakeLiftSubsystem m_intakeLiftSubsystem = new intakeLiftSubsystem();
    public final shooterWheelSubsystem m_shooterWheelSubsystem = new shooterWheelSubsystem();
    public final visionSubsystem m_visionSubsystem = new visionSubsystem();
    public final driveSubsystem m_driveSubsystem = new driveSubsystem();

    // Joysticks
    private final Joystick nesStick = new Joystick(1);
    private final Joystick driveStick = new Joystick(0);

    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();


  private RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_driveSubsystem.setDefaultCommand(new driveCommand( m_driveSubsystem ) );
    m_shooterWheelSubsystem.setDefaultCommand(new shooterWheelStill( m_shooterWheelSubsystem ) );
    m_intakeLiftSubsystem.setDefaultCommand(new intakeLiftStill( m_intakeLiftSubsystem ) );
    m_shooterLiftSubsystem.setDefaultCommand(new shooterLiftStill( m_shooterLiftSubsystem ) );
    m_elevatorSubsystem.setDefaultCommand(new elevatorStill( m_elevatorSubsystem ) );
    m_intakeSubsystem.setDefaultCommand(new intakeStill( m_intakeSubsystem ) );
    m_climberLeftSubsystem.setDefaultCommand(new climberLeftStill( m_climberLeftSubsystem ) );
    m_climberRightSubsystem.setDefaultCommand(new climberRightStill(m_climberRightSubsystem) );
    m_climberTraverseSubsystem.setDefaultCommand(new climberTraverseStill(m_climberTraverseSubsystem) );

    // Configure autonomous sendable chooser
    //m_chooser.setDefaultOption("autoCommand", new autoCommand(m_driveSubsystem));
    //m_chooser.setDefaultOption("Move Forward", new autoMoveForward(m_driveSubsystem));
    m_chooser.setDefaultOption("Shoot Single", new autoCommand(m_driveSubsystem, m_shooterWheelSubsystem, m_shooterLiftSubsystem, m_intakeLiftSubsystem, m_intakeSubsystem, m_elevatorSubsystem, m_visionSubsystem));
    m_chooser.addOption("Move Forward", new autoMoveForward(m_driveSubsystem));

    SmartDashboard.putData("Auto Mode", m_chooser);
  }


  public static RobotContainer getInstance() {
    return m_robotContainer;
  }


  private void configureButtonBindings() {
    // ------- Test buttons to remove when not debugging -------
    //final JoystickButton testToPositionButton = new JoystickButton(nesStick, 10);
    //testToPositionButton.whenPressed(new shooterAngleToPosition(m_shooterAngleSubsystem, Preferences.getDouble("anglePos", 2000)));

    // ------- Create some buttons -------
    final JoystickButton intakeElevatorInButton = new JoystickButton(nesStick, 11);
    intakeElevatorInButton.whileHeld(new intakeElevatorIn(m_intakeSubsystem, m_elevatorSubsystem));

    final JoystickButton trackButton = new JoystickButton(nesStick, 9);        
    trackButton.toggleWhenPressed(new trackGoal(m_visionSubsystem, m_driveSubsystem, m_shooterWheelSubsystem) ,true);


    final JoystickButton climberLeftUpBotton = new JoystickButton(driveStick, 5);        
    //climberLeftUpBotton.whileHeld(new climberLeftUp( m_climberLeftSubsystem ) ,true);


    final JoystickButton climberLeftDownButton = new JoystickButton(driveStick, 10);        
    //climberLeftDownButton.whileHeld(new climberLeftDown( m_climberLeftSubsystem ) ,true);


    final JoystickButton climberRightUpButton = new JoystickButton(driveStick, 7);
    //climberRightUpButton.whileHeld(new climberRightUp(m_climberRightSubsystem) ,true);


    final JoystickButton climberRightDownButton = new JoystickButton(driveStick, 8);
    //climberRightDownButton.whileHeld(new climberRightDown(m_climberRightSubsystem) ,true);


    final JoystickButton shooterWheelShootButton = new JoystickButton(nesStick, 10);        
    //shooterWheelShootButton.whileHeld(new shooterWheelShoot( m_shooterWheelSubsystem ) ,true);


    final JoystickButton intakeLiftDownButton = new JoystickButton(nesStick, 4);        
    intakeLiftDownButton.whileHeld(new intakeLiftDown( m_intakeLiftSubsystem ) ,true);


    final JoystickButton intakeLiftUpButton = new JoystickButton(nesStick, 3);        
    intakeLiftUpButton.whileHeld(new intakeLiftUp( m_intakeLiftSubsystem ) ,true);


    //final JoystickButton shooterAngleUpButton = new JoystickButton(nesStick, 1);        
    //shooterAngleUpButton.whileHeld(new shooterAngleUp( m_shooterAngleSubsystem ) ,true);


    //final JoystickButton shooterAngleDownButton = new JoystickButton(nesStick, 2);        
    //shooterAngleDownButton.whileHeld(new shooterAngleDown( m_shooterAngleSubsystem ) ,true);


    final JoystickButton shooterLiftUpButton = new JoystickButton(nesStick, 6);        
    shooterLiftUpButton.whileHeld(new shooterLiftUp( m_shooterLiftSubsystem ) ,true);


    final JoystickButton shooterLiftDownButton = new JoystickButton(nesStick, 5);        
    shooterLiftDownButton.whileHeld(new shooterLiftDown( m_shooterLiftSubsystem ) ,true);


    final JoystickButton elevatorUpButton = new JoystickButton(nesStick, 8);        
    elevatorUpButton.whileHeld(new elevatorUp( m_elevatorSubsystem ) ,true);


    final JoystickButton elevatorDownButton = new JoystickButton(nesStick, 7);        
    elevatorDownButton.whileHeld(new elevatorDown( m_elevatorSubsystem ) ,true);


    final JoystickButton intakeInButton = new JoystickButton(nesStick, 12);        
    intakeInButton.whileHeld(new intakeIn( m_intakeSubsystem ) ,true);


    final JoystickButton intakeOutButton = new JoystickButton(nesStick, 13);        
    intakeOutButton.whileHeld(new intakeOut( m_intakeSubsystem ) ,true);

    final JoystickButton climberTraverseForwardButton = new JoystickButton(driveStick, 13);        
    //climberTraverseForwardButton.whileHeld(new climberTraverseForward( m_climberTraverseSubsystem ) ,true);

    final JoystickButton climberTraverseBackwardButton = new JoystickButton(driveStick, 14);        
    //climberTraverseBackwardButton.whileHeld(new climberTraverseBackward( m_climberTraverseSubsystem ) ,true);
  }


  public Joystick getdriveStick() {
          return driveStick;
      }


  public Joystick getnesStick() {
          return nesStick;
      }


  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
}

