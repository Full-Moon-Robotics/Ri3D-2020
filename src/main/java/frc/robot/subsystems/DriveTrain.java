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
  
    private final CANSparkMax m_leftMotor;
    private final CANSparkMax m_leftMotor_1;
    private final CANSparkMax m_leftMotor_2;
    private final CANSparkMax m_rightMotor;
    private final CANSparkMax m_rightMotor_1;
    private final CANSparkMax m_rightMotor_2;
    /*
    private final PWMSparkMax m_leftMotor;
    private final PWMSparkMax m_rightMotor;
    */
    private final DifferentialDrive m_drive;
    
  public DriveTrain() {
    super();
    
    m_leftMotor = new CANSparkMax(5, MotorType.kBrushless);
    m_leftMotor_1 = new CANSparkMax(6, MotorType.kBrushless);
    m_leftMotor_2 = new CANSparkMax(7, MotorType.kBrushless);

    m_rightMotor = new CANSparkMax(8, MotorType.kBrushless);
    m_rightMotor_1 = new CANSparkMax(9, MotorType.kBrushless);
    m_rightMotor_2 = new CANSparkMax(10, MotorType.kBrushless);

    /*
    m_leftMotor = new PWMSparkMax(0);
    m_rightMotor = new PWMSparkMax(1);
    */
    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    m_leftMotor.restoreFactoryDefaults();
    m_leftMotor.getEncoder(EncoderType.kHallSensor, 4096);
    m_leftMotor_1.restoreFactoryDefaults();
    m_leftMotor_1.getEncoder(EncoderType.kHallSensor, 4096);
    m_leftMotor_1.follow(m_leftMotor);
    m_leftMotor_2.restoreFactoryDefaults();
    m_leftMotor_2.getEncoder(EncoderType.kHallSensor, 4096);
    m_leftMotor_2.follow(m_leftMotor);
    
    m_rightMotor.restoreFactoryDefaults();
    m_rightMotor.getEncoder(EncoderType.kHallSensor, 4096);
    m_rightMotor_1.restoreFactoryDefaults();
    m_rightMotor_1.getEncoder(EncoderType.kHallSensor, 4096);
    m_rightMotor_1.follow(m_rightMotor);
    m_rightMotor_2.restoreFactoryDefaults();
    m_rightMotor_2.getEncoder(EncoderType.kHallSensor, 4096);
    m_rightMotor_2.follow(m_rightMotor);

  }
  public void drive(double left, double right){
    m_drive.tankDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
