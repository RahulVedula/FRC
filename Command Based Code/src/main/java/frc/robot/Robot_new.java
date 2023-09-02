// Import necessary libraries

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    // Define your member variables here

    @Override
    public void robotInit() {
        // Initialize your robot components and set default values
        robotStuff = new robotStuff();
    }

    @Override
    public void autonomousInit() {
        // Implement autonomous initialization
        autonomousCommand = robotStuff.getAutonomousCommand();
        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {
        // Implement autonomous periodic code
    }

    @Override
    public void teleopInit() {
        // Implement teleop initialization
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        CommandScheduler.getInstance().run();
        // Implement teleop periodic code
    }

    @Override
    public void disabledInit() {
        // Implement disabled initialization
    }

    @Override
    public void disabledPeriodic() {
        // Implement disabled periodic code
    }

    @Override
    public void testInit() {
        // Implement test initialization
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
        // Implement test periodic code
    }

    @Override
    public void simulationInit() {
        // Implement simulation initialization
    }

    @Override
    public void simulationPeriodic() {
        // Implement simulation periodic code
    }

    