package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;


public class Intake extends SubsystemBase {
    /**
     * Intake.
     */
    
      private  CANSparkMax m_intakeLeft;
      private  CANSparkMax m_intakeRight;
      private  Compressor m_Compressor;

      private  DifferentialDrive m_intake;

    public Intake() {
      super();

      if(!SubsystemConstants.REAL_ROBOT){
        return;
      }
      
      m_intakeLeft = new CANSparkMax(12, MotorType.kBrushless);
  
      m_intakeRight = new CANSparkMax(13, MotorType.kBrushless);
  
      m_intakeLeft.restoreFactoryDefaults();
      m_intakeLeft.getEncoder(EncoderType.kHallSensor, 4096);

      m_intakeRight.restoreFactoryDefaults();
      m_intakeRight.getEncoder(EncoderType.kHallSensor, 4096);

      
      m_Compressor = new Compressor();
      m_Compressor.setClosedLoopControl(true);
      
      //TODO: Solenoid for lifting

    
      m_intake = new DifferentialDrive(m_intakeLeft, m_intakeRight);
  
    }
    public void run_intake(double speed){
      if(m_intake != null){
        m_intake.tankDrive(speed, speed);
      }
    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  }