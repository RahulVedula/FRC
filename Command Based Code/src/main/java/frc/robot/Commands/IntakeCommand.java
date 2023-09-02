// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake_Subsystem;

public class IntakeCommand extends CommandBase {
  private final Intake_Subsystem intakeSubsystem;
  private final double speed;
  private final double stall;

  public IntakeCommand(Intake_Subsystem intakeSubsystem, double speed, double stall) {
    this.intakeSubsystem = intakeSubsystem;
    this.speed = speed;
    this.stall = stall;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    intakeSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setMotor(stall);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}