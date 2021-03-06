/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {
  /**
   * Drive Train.
   */
  
    private  CANSparkMax m_leftMotor;
    private  CANSparkMax m_leftMotor_1;
    private  CANSparkMax m_rightMotor;
    private  CANSparkMax m_rightMotor_1;
    private  DifferentialDrive m_drive;
  public DriveTrain() {
    super();
    if(!SubsystemConstants.REAL_ROBOT){ //REMOVE THIS FOR REAL ROBOT
      return;
    }

    m_leftMotor = new CANSparkMax(5, MotorType.kBrushless);
    m_leftMotor_1 = new CANSparkMax(6, MotorType.kBrushless);

    m_rightMotor = new CANSparkMax(8, MotorType.kBrushless);
    m_rightMotor_1 = new CANSparkMax(9, MotorType.kBrushless);
    
    m_drive = new DifferentialDrive(m_rightMotor, m_leftMotor);


    m_leftMotor.restoreFactoryDefaults();
    m_leftMotor.getEncoder(EncoderType.kHallSensor, 4096);
    m_leftMotor_1.restoreFactoryDefaults();
    m_leftMotor_1.getEncoder(EncoderType.kHallSensor, 4096);
    m_leftMotor_1.follow(m_leftMotor);
    
    m_rightMotor.restoreFactoryDefaults();
    m_rightMotor.getEncoder(EncoderType.kHallSensor, 4096);
    m_rightMotor_1.restoreFactoryDefaults();
    m_rightMotor_1.getEncoder(EncoderType.kHallSensor, 4096);
    m_rightMotor_1.follow(m_rightMotor);

  }
  public void drive(double left, double right){
    if(m_drive != null){
      m_drive.tankDrive(0-right, 0-left);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
