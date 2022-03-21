

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevatorSubsystem;
import frc.robot.subsystems.intakeSubsystem;

public class intakeElevatorIn extends CommandBase {

    private final intakeSubsystem m_intakeSubsystem;
    private final elevatorSubsystem m_elevatorSubsystem;
 
    public intakeElevatorIn(intakeSubsystem subsystem, elevatorSubsystem elevator) {

        m_elevatorSubsystem = elevator;
        m_intakeSubsystem = subsystem;
        addRequirements(m_intakeSubsystem);
        addRequirements(m_elevatorSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intakeSubsystem.intakeMotor.set(-0.45);
        elevatorSubsystem.elevatorLMotor.set(-0.9);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
