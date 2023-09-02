package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Subsystem;

public class DriveEncoderCommand extends CommandBase {
  private final Drive_Subsystem driveSubsystem;
  private final double distance;
  private final double speed;

  public DriveEncoderCommand(Drive_Subsystem driveSubsystem, double speed, double distance) {
    this.driveSubsystem = driveSubsystem;
    this.speed = speed;
    this.distance = distance;
    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    driveSubsystem.setMotor(speed, 0);
  }
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setMotor(0, 0);
  }

  @Override
  public boolean isFinished() {
    return driveSubsystem.getEncoderDrivePosition() < distance;
  }
}