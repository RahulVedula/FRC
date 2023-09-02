package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator_Subsystem;
public class ElevatorCommand extends CommandBase {
  private final Elevator_Subsystem elevatorSubsystem;
  private final double speed;

  public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, double speed) {
    this.elevatorSubsystem = elevatorSubsystem;
    this.speed = speed;
    addRequirements(elevatorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    elevatorSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.setMotor(0);
  }

}