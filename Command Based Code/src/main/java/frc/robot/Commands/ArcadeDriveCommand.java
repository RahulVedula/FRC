package frc.robot.commands;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Subsystem;
public class ArcadeDriveCommand extends CommandBase {

  private final Drive_Subsystem driveSubsystem;
  private final DoubleSupplier speedFunction, turnFunction;

  public ArcadeDriveCommand(Drive_Subsystem driveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
    this.driveSubsystem = driveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    driveSubsystem.setMotor(speedFunction.getAsDouble(), turnFunction.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setMotor(0.0, 0.0);
  }

}