/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {

  private CANSparkMax spinnerMotor;
  //Whatever sensor to detect color

  /**
   * Creates a new ControlPanel.
   */
  public ControlPanel() {
    super();
    if(!SubsystemConstants.REAL_ROBOT){
      return;
    }

    spinnerMotor = new CANSparkMax(14, MotorType.kBrushless);
    spinnerMotor.restoreFactoryDefaults();
    spinnerMotor.getEncoder(EncoderType.kHallSensor, 4096);
  }

  public String getCurrentColor(){
    //Put sensor code here
    return "";
  }

  public void stop(){
    if(spinnerMotor != null){
      spinnerMotor.set(0);
    }
  }

  public void spin(){
    spinnerMotor.set(1);  //full power magic number 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
