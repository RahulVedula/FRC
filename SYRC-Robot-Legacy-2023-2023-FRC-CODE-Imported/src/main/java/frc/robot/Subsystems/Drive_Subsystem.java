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

public class Drive_Subsystem extends SubsystemBase {
    final WPI_VictorSPX FRONT_LEFT = new WPI_VictorSPX(4);
    final WPI_VictorSPX FRONT_RIGHT = new WPI_VictorSPX(6);
    final WPI_VictorSPX BACK_LEFT = new WPI_VictorSPX(12);
    final WPI_VictorSPX BACK_RIGHT = new WPI_VictorSPX(5);
    final WPI_VictorSPX ROTATION = new WPI_VictorSPX(13);
    final MotorControllerGroup LEFT_DRIVE = new MotorControllerGroup(FRONT_LEFT, BACK_LEFT);
    final MotorControllerGroup RIGHT_DRIVE = new MotorControllerGroup(FRONT_RIGHT, BACK_RIGHT);
    final DifferentialDrive ROBOT_DRIVE = new DifferentialDrive(LEFT_DRIVE, RIGHT_DRIVE);
    final Encoder encoderA = new Encoder(1, 2);
    final AHRS gyro = new AHRS(SPI.Port.kMXP);
      @Override
    public double getDrivePosition() {
        return (encoderA.getDistance());
    }
    public driveRobot(){
        FRONT_LEFT.setNeutralMode(NeutralMode.Brake);
        FRONT_RIGHT.setNeutralMode(NeutralMode.Brake);
        BACK_LEFT.setNeutralMode(NeutralMode.Brake);
        BACK_RIGHT.setNeutralMode(NeutralMode.Brake);
    }
    public void periodic() {
        SmartDashboard.putNumber("Encoder Distance", encoderA.getDistance());
    }

    public void setMotor(double forwardSpeed, double turnSpeed) {
        driveRobot.arcadeDrive(forwardSpeed, turnSpeed);
    }

    public void stopMotor() {
        driveRobot.stopMotor();
    }

    public void resetEncoder() {
        encoderA.reset();
    }

    public void resetGyro() {
        gyro.reset();
    }
}
//Error after error IM HIM 