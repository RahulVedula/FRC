

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
  private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  private final PWMSparkMax m_shooter = new PWMSparkMax(2);
  private final PWMSparkMax m_intake = new PWMSparkMax(3);
  Encoder m_encoder = new Encoder(0, 1);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
//Setting the joystick
  private final Joystick m_joystick = new Joystick(0);
  private final AnalogGyro m_gyro = new AnalogGyro(0);
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
    m_encoder.setDistancePerPulse((Math.PI * 6) / 360.0); 
  }

  @Override
  public void autonomousPeriodic() {
    //Going to get the blue ball 
    if (count == 0){
      //Had no clue what distance to make it, WPLIB example had 5ft so i decided to stck with that
    if(m_encoder.getDistance() < 5) {
      //I wrote that it drives backwards because the shooter is facing the goal, and I believe the shooter is at the front (from the pictures I've seen)
      //So it would drive backwards to make sure the intake, which I think is at the back, makes contact with the ball first.
      //Still not to sure about the configuration so this may be wrong. 
      m_robotDrive.arcadeDrive(-0.5, 0.0);
      m_intake.set(0.5);
   } 
    else {
      m_intake.stopMotor();
      count++;
  }
}
//Turning right
//Could be wrong, but I think using p-loops, you can make a more precise way to turn the direction of the robot. However, for my sake, I just decided to do something similar to the encoder's format. 
  else if (count==1){
    //Turns right
    if (m_gyro.getAngle() <= 90){ //While the angle is less than 90, you want to turn right untill it reaches it. I think this may lead to inaccuracies.
      m_robotDrive.arcadeDrive(0.0,0.5);
    }
    else{
      m_encoder.reset(); //Trying to reset the encoder and gyro's at the very last minute to ensure accuracy when measuring
      count++;
    }
  }
  //Getting the next blue ball
  else if (count==2){
    //Relative to the distance to the frst ball, this distance is a bt bigger
    if (m_encoder.getDistance() < 8){
      m_robotDrive.arcadeDrive(0.5,0.0);
      m_intake.set(0.5);
    
    }
    else{
      m_intake.stopMotor();
      m_gyro.reset();
    }
}
//Turning to face the goal
  else if (count==3){
    if (m_gyro.getAngle() <= 90){
    m_robotDrive.arcadeDrive(0.0,0.5);
    }
    else{
    m_encoder.reset();
    count++;
  }
}
//turning into steph curry, shooting balls into the goal
  else if (count==4){
    m_timer.start();
//Hopefully 4 seconds is enough time for it to shoot. 
    if (m_timer.get() < 4.0){
      m_shooter.set(0.5);
    }
    else{
      m_shooter.stopMotor();
      m_gyro.reset();
      m_encoder.reset();
      m_robotDrive.stopMotor();

    }
  }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if (m_joystick.getRawButtonPressed(0)) {
      m_intake.stopMotor(); 
   }
   if (m_joystick.getRawButtonPressed(1)) {
    m_intake.set(0.5); 
  }
 if (m_joystick.getRawButtonPressed(2)) {
  m_intake.set(-0.5); // When pressed the intake turns on
}
  }

 
  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
