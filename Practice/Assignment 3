package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
  //Initializing the motor
  private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  private final PWMSparkMax m_shooter = new PWMSparkMax(2);
  //Setting the joystick
  private final Joystick m_stick = new Joystick(0);
  //Setting a timer for autonomous period
  private final Timer m_timer = new Timer();
  private int count = 0;

 
  @Override
  public void robotInit() {
    m_rightDrive.setInverted(true);
  }


  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    if (count==0){
      if (m_timer.get() <= 2.0) {
        m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards at half speed for 2
      } 
      else {
        m_robotDrive.stopMotor(); 
        count++;
      }
    }
    else if (count==1){
      if (m_timer.get() <= 5.0) {
        m_robotDrive.arcadeDrive(-0.5, 0.0); // drive backwards at half speed for 3
        if (m_timer.get() <= 4.0){
          m_shooter.set(0.5); //Runs shooter for 2 while driving backwards
        }
      }
      else {
        m_robotDrive.stopMotor(); 
        count++;
      }
    }
   else if (count==2){
      if (m_timer.get() <= 10.0){
        m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards at half speed for 5
      }
      else {
        m_robotDrive.stopMotor(); 
        count++;
      }
    }
   else if (count==3){
    if (m_timer.get() <= 11.0){
        m_robotDrive.arcadeDrive(0.0, 0.5); // turns right at half speed for 1 
      }
      else {
        m_robotDrive.stopMotor(); 
        count++;
      }
    }
}


  @Override
  public void teleopInit() {}


  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX()); //Kept this here as you probably want ur robot moving dure teleop period
    m_shooter.set(m_stick.getY()); //Shooter speed set to the y of the joy stick
  }


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
