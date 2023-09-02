package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RotationSubsystem;

public class EngageAuto extends SequentialCommandGroup {
  public EngageAuto(Drive_Subsystem driveSubsystem, Elevator_Subsystem elevatorSubsystem, Rotation_Subsystem rotationSubsystem, Intake_Subsystem intakeSubsystem) {
  
    addCommands(
     new ElevatorCommand(elevatorSubsystem, AutoConstants.ELEVATOR_DOWN_SPEED).withTimeout(AutoConstants.ELEVATOR_DOWN_TIME),
      new ElevatorCommand(elevatorSubsystem, AutoConstants.ELEVATOR_UP_SPEED),
      new RotationCommand(rotationSubsystem, AutoConstants.ROTATION_OUT_SPEED, 0).withTimeout(AutoConstants.ROTATION_OUT_TIME),
      new RotationCommand(rotationSubsystem, AutoConstants.ROTATION_UP_SPEED, 0).withTimeout(AutoConstants.ROTATION_UP_TIME),
      new RotationCommand(rotationSubsystem, AutoConstants.ROTATION_DOWN_SPEED, 0).withTimeout(AutoConstants.ROTATION_DOWN_TIME),
      new IntakeCommand(intakeSubsystem, AutoConstants.INTAKE_SHOOT_SPEED, 0).withTimeout(AutoConstants.INTAKE_SHOOT_TIME),  
      new DriveEncoderCommand(driveSubsystem, AutoConstants.AUTO_DRIVE_SPEED, AutoConstants.ENGAGE_ENCODER_VALUE).withTimeout(AutoConstants.ENGAGE_DRIVE_TIME),
      new DriveEncoderCommand(driveSubsystem, AutoConstants.ENGAGE_DRIVE_SPEED, AutoConstants.ENGAGE_ENCODER_VALUE));
  }
}