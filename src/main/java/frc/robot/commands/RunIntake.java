/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;


/**
 * Have the robot drive tank style.
 */
public class RunIntake extends CommandBase {
  private final Intake m_intake;
  private final DoubleSupplier m_speed;
  public RunIntake(DoubleSupplier speed, Intake intake) {
    m_intake = intake;
    m_speed = speed;
    addRequirements(m_intake);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_intake.run_intake(m_speed.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false; // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_intake.run_intake(0);
  }
}
