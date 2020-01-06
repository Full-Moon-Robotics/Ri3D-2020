/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Output;


/**
 * Have the robot drive tank style.
 */
public class RunOutput extends CommandBase {
  private final Output m_output;
  private final DoubleSupplier m_speed;
  public RunOutput(DoubleSupplier speed, Output output) {
    m_output = output;
    m_speed = speed;
    addRequirements(m_output);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_output.run_output(m_speed.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false; // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_output.run_output(0);
  }
}
