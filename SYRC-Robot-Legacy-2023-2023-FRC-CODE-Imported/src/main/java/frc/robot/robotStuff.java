package frc.robot;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.RotationConstants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.subsystems.Drive_Subsystem;
import frc.robot.subsystems.Elevator_Subsystem;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.Rotation_Subsystem;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.RotationCommand;
import frc.robot.commands.EngageAuto;
import frc.robot.commands.MobilityAuto;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RobotContainer {
  private final Drive_Subsystem driveSubsystem = new Drive_Subsystem();
  private final Elevator_Subsystem elevatorSubsystem = new Elevator_Subsystem();
  private final Intake_Subsystem intakeSubsystem = new Intake_Subsystem();
  private final Rotation_Subsystem rotationSubsystem = new Rotation_Subsystem();

  private final Joystick driverController =
      new Joystick(ControllerConstants.DRIVER_CONTROLLER_PORT);
  
  SendableChooser<Command> chooser = new SendableChooser<>();

  private final Command engageAuto = new EngageAuto(driveSubsystem, elevatorSubsystem, rotationSubsystem, intakeSubsystem);
  private final Command mobilityAuto = new MobilityAuto(driveSubsystem, elevatorSubsystem, rotationSubsystem, intakeSubsystem);

  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, () -> driverController.getRawAxis(DriveConstants.DRIVE_AXIS), () -> (-driverController.getRawAxis(DriveConstants.TURN_AXIS) * DriveConstants.TURN_PROPORTION)));

    chooser.setDefaultOption("Engage Auto", engageAuto);
    chooser.addOption("Mobility Auto", mobilityAuto);
    Shuffleboard.getTab("Autonomous").add(chooser);
  }

  private void configureBindings() {
    new JoystickButton(driverController, DriveConstants.SLOW_BUTTON).onTrue(new ArcadeDriveCommand(driveSubsystem, () -> (driverController.getRawAxis(DriveConstants.DRIVE_AXIS) * DriveConstants.DRIVE_SLOW), () -> (-driverController.getRawAxis(DriveConstants.TURN_AXIS) * DriveConstants.TURN_PROPORTION * DriveConstants.TURN_SLOW)));
    new JoystickButton(driverController, DriveConstants.NORMAL_BUTTON).onTrue(new ArcadeDriveCommand(driveSubsystem, () -> driverController.getRawAxis(DriveConstants.DRIVE_AXIS), () -> (-driverController.getRawAxis(DriveConstants.TURN_AXIS) * DriveConstants.TURN_PROPORTION)));
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}