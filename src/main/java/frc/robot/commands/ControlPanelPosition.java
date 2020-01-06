/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

//Spin the control panel to a specific color
public class ControlPanelPosition extends CommandBase {
  ControlPanel controlPanel;
  boolean finished = false;
  String gameString = "";
  /**
   * Creates a new ControlPanelPosition.
   */
  public ControlPanelPosition(ControlPanel controlPanel) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.controlPanel = controlPanel;
    addRequirements(this.controlPanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gameString = DriverStation.getInstance().getGameSpecificMessage();
    if(gameString.isEmpty()){
      //Not ready!
      finished = true;
      DriverStation.reportWarning("Position Not Ready", false);
      return;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(controlPanel.getCurrentColor().equals(gameString)){
      finished = true;
    } else{
      controlPanel.spin();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    controlPanel.stop();
    DriverStation.reportWarning("Position Done", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
