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

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /**
   * Elevator.
   */
  
    private final CANSparkMax m_leftMotor;
    private final CANSparkMax m_rightMotor;
    /*
    private final PWMSparkMax m_leftMotor;
    private final PWMSparkMax m_rightMotor;
    */
    private final DifferentialDrive m_elevator;
    
  public Elevator() {
    super();
    
    m_leftMotor = new CANSparkMax(10, MotorType.kBrushless);

    m_rightMotor = new CANSparkMax(11, MotorType.kBrushless);
    
    

    /*
    m_leftMotor = new PWMSparkMax(0);
    m_rightMotor = new PWMSparkMax(1);
    */
    m_elevator = new DifferentialDrive(m_leftMotor, m_rightMotor);

    m_leftMotor.restoreFactoryDefaults();
    m_leftMotor.getEncoder(EncoderType.kHallSensor, 4096);
    
    m_rightMotor.restoreFactoryDefaults();
    m_rightMotor.getEncoder(EncoderType.kHallSensor, 4096);

  }
  public void drive(double left, double right){
    m_elevator.tankDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}