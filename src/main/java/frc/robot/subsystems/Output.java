package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Output extends SubsystemBase {
    /**
     * Output.
     */
    
      private  CANSparkMax m_outputLeft;
      private  CANSparkMax m_outputRight;


      private  DifferentialDrive m_output;

    public Output() {
      super();
      if(!SubsystemConstants.REAL_ROBOT){
        return;
      }
      m_outputLeft = new CANSparkMax(12, MotorType.kBrushless);
  
      m_outputRight = new CANSparkMax(13, MotorType.kBrushless);
  
      m_outputLeft.restoreFactoryDefaults();
      m_outputLeft.getEncoder(EncoderType.kHallSensor, 4096);

      
      m_outputRight.restoreFactoryDefaults();
      m_outputRight.getEncoder(EncoderType.kHallSensor, 4096);
    
      m_output = new DifferentialDrive(m_outputLeft, m_outputRight);
  
    }
    public void run_output(double speed){
      if(m_output != null){
         m_output.tankDrive(speed, speed);
      }
    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  }