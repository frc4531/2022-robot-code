package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;


public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // The robot's subsystems
    public final climberSubsystem m_climberSubsystem = new climberSubsystem();
    public final climberTraverseSubsystem m_climberTraverseSubsystem = new climberTraverseSubsystem();
    public final intakeSubsystem m_intakeSubsystem = new intakeSubsystem();
    public final elevatorSubsystem m_elevatorSubsystem = new elevatorSubsystem();
    public final shooterLiftSubsystem m_shooterLiftSubsystem = new shooterLiftSubsystem();
    public final shooterAngleSubsystem m_shooterAngleSubsystem = new shooterAngleSubsystem();
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
    m_shooterAngleSubsystem.setDefaultCommand(new shooterAngleStill( m_shooterAngleSubsystem ) );
    m_shooterLiftSubsystem.setDefaultCommand(new shooterLiftStill( m_shooterLiftSubsystem ) );
    m_elevatorSubsystem.setDefaultCommand(new elevatorStill( m_elevatorSubsystem ) );
    m_intakeSubsystem.setDefaultCommand(new intakeStill( m_intakeSubsystem ) );
    m_climberSubsystem.setDefaultCommand(new climberStill( m_climberSubsystem ) );
    m_climberTraverseSubsystem.setDefaultCommand(new climberTraverseStill(m_climberTraverseSubsystem) );

    // Configure autonomous sendable chooser
    m_chooser.setDefaultOption("autoCommand", new autoCommand());

    SmartDashboard.putData("Auto Mode", m_chooser);
  }


  public static RobotContainer getInstance() {
    return m_robotContainer;
  }


  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton testButton = new JoystickButton(driveStick, 1);        
    testButton.whileHeld(new trackGoal(m_visionSubsystem, m_driveSubsystem, m_shooterAngleSubsystem) ,true);

    final JoystickButton trackButtonStageOne = new JoystickButton(driveStick, 2);        
    trackButtonStageOne.whileHeld(new trackGoal(m_visionSubsystem, m_driveSubsystem, m_shooterAngleSubsystem), true);

    final JoystickButton trackButtonStageTwo = new JoystickButton(driveStick, 2);        
    trackButtonStageTwo.whenReleased(new trackGoal(m_visionSubsystem, m_driveSubsystem, m_shooterAngleSubsystem), false);


    final JoystickButton climberUpBotton = new JoystickButton(driveStick, 7);        
    climberUpBotton.whileHeld(new climberUp( m_climberSubsystem ) ,true);


    final JoystickButton climberDownButton = new JoystickButton(driveStick, 8);        
    climberDownButton.whileHeld(new climberDown( m_climberSubsystem ) ,true);


    final JoystickButton shooterWheelShootButton = new JoystickButton(nesStick, 9);        
    shooterWheelShootButton.whileHeld(new shooterWheelShoot( m_shooterWheelSubsystem ) ,true);


    final JoystickButton intakeLiftDownButton = new JoystickButton(nesStick, 1);        
    intakeLiftDownButton.whileHeld(new intakeLiftDown( m_intakeLiftSubsystem ) ,true);


    final JoystickButton intakeLiftUpButton = new JoystickButton(nesStick, 2);        
    intakeLiftUpButton.whileHeld(new intakeLiftUp( m_intakeLiftSubsystem ) ,true);


    final JoystickButton shooterAngleUpButton = new JoystickButton(nesStick, 3);        
    shooterAngleUpButton.whileHeld(new shooterAngleUp( m_shooterAngleSubsystem ) ,true);


    final JoystickButton shooterAngleDownButton = new JoystickButton(nesStick, 4);        
    shooterAngleDownButton.whileHeld(new shooterAngleDown( m_shooterAngleSubsystem ) ,true);


    final JoystickButton shooterLiftUpButton = new JoystickButton(nesStick, 5);        
    shooterLiftUpButton.whileHeld(new shooterLiftUp( m_shooterLiftSubsystem ) ,true);


    final JoystickButton shooterLiftDownButton = new JoystickButton(nesStick, 6);        
    shooterLiftDownButton.whileHeld(new shooterLiftDown( m_shooterLiftSubsystem ) ,true);


    final JoystickButton elevatorUpButton = new JoystickButton(nesStick, 7);        
    elevatorUpButton.whileHeld(new elevatorUp( m_elevatorSubsystem ) ,true);


    final JoystickButton elevatorDownButton = new JoystickButton(nesStick, 8);        
    elevatorDownButton.whileHeld(new elevatorDown( m_elevatorSubsystem ) ,true);


    final JoystickButton intakeInButton = new JoystickButton(nesStick, 12);        
    intakeInButton.whileHeld(new intakeIn( m_intakeSubsystem ) ,true);


    final JoystickButton intakeOutButton = new JoystickButton(nesStick, 13);        
    intakeOutButton.whileHeld(new intakeOut( m_intakeSubsystem ) ,true);

    final JoystickButton climberTraverseForwardButton = new JoystickButton(driveStick, 13);        
    climberTraverseForwardButton.whileHeld(new climberTraverseForward( m_climberTraverseSubsystem ) ,true);

    final JoystickButton climberTraverseBackwardButton = new JoystickButton(driveStick, 14);        
    climberTraverseBackwardButton.whileHeld(new climberTraverseBackward( m_climberTraverseSubsystem ) ,true);
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

