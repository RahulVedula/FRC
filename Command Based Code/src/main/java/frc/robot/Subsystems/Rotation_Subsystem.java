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
public class Rotation_Subsystem extends SubsystemBase{
    public Rotation_Subsystem
    {
    final WPI_VictorSPX ROTATION = new WPI_VictorSPX(13);
    }
    
    public void rotation_speed (double rotationSpeed)
    {
        ROTATION.set(rotationSpeed);
    }
}
