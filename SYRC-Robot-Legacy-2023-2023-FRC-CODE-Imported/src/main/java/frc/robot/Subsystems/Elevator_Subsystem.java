package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Constants.DriveConstants;

public class ElevatorSubsystem extends SubsystemBase{
  /** Creates a new ElevatorSubsystem. */
  private final CANSparkMax elevatorLeft = new CANSparkMax(ElevatorConstants.ELEVATOR_LEFT, MotorType.kBrushless);
  private final CANSparkMax elevatorRight = new CANSparkMax(ElevatorConstants.ELEVATOR_RIGHT, MotorType.kBrushless);
  private final MotorControllerGroup elevator= new MotorControllerGroup(elevatorLeft, elevatorRight);
  private final RelativeEncoder encoderRightElevator = elevatorRight.getEncoder();
  private final DigitalInput limitSwitchElevator = new DigitalInput(ElevatorConstants.LIMIT_SWITCH_PORT);

  public void setMotor(double speed) {
    elevator.set(speed);
  }

public boolean getLimitSwitchElevatorState() {
    return (limitSwitchElevator.get());
  }
  
  public double getEncoderElevatorPosition() {
    return (encoderRightElevator.getPosition());
  }


  public ElevatorSubsystem() {
    elevatorRight.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Right Encoder", getEncoderElevatorPosition());
    SmartDashboard.putBoolean("Limit Switch State", getLimitSwitchElevatorState());
    // This method will be called once per scheduler run
  }

  
}
