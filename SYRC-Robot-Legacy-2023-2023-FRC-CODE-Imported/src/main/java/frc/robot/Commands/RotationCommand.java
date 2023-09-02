package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Rotation_Subsystem;

public class RotationCommand extends CommandBase {
  private final Rotation_Subsystem rotationSubsystem;
  private final double speed;
  private final double stall;

  public DriveEncoderCommand(Drive_Subsystem driveSubsystem, double speed, double distance) {
    this.rotationSubsystem = rotationSubsystem;
    this.speed = speed;
    this.stall = stall;
    addRequirements(rotationSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    rotationSubsystem.setMotor(speed, 0);
  }
  @Override
  public void end(boolean interrupted) {
    rotationSubsystem.setMotor(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}