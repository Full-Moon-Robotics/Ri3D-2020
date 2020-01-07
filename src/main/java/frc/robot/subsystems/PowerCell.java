package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;


public class PowerCell extends SubsystemBase {
    /**
     * Intake.
     */
    
      private  CANSparkMax intakeMotor;
      private  CANSparkMax beltMotor;
      private CANSparkMax outputMotor;
      private  Compressor m_Compressor;


    public PowerCell() {
      super();

      if(!SubsystemConstants.REAL_ROBOT){
        return;
      }
      
      intakeMotor = new CANSparkMax(12, MotorType.kBrushed); //changed to reflect final motor
      beltMotor = new CANSparkMax(11, MotorType.kBrushless);
      outputMotor = new CANSparkMax(14, MotorType.kBrushless);
  
      intakeMotor.restoreFactoryDefaults();

      beltMotor.restoreFactoryDefaults();
      beltMotor.getEncoder(EncoderType.kHallSensor, 4096);

      outputMotor.restoreFactoryDefaults();
      outputMotor.getEncoder(EncoderType.kHallSensor, 4096);

      
      m_Compressor = new Compressor();
      m_Compressor.setClosedLoopControl(true);
            
  
    }
    public void run_intake(double speed){
      if(intakeMotor != null){
        intakeMotor.set(speed);
        beltMotor.set(speed);
      }
    }
    
    public void run_output(double speed){
      if(intakeMotor != null){
        outputMotor.set(speed);
      }
    }
    public void run_belt(double speed){
      if(intakeMotor != null){
        outputMotor.set(speed);
      }
    }
    

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  }