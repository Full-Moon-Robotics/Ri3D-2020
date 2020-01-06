/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//wpilibj.buttons
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.TankDrive;
import frc.robot.commands.ControlPanelPosition;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunOutput;
import frc.robot.subsystems.ControlPanel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Output;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


  final DriveTrain m_drivetrain = new DriveTrain();
  final Elevator m_elevator = new Elevator();
  final Intake m_intake = new Intake();
  final Output m_output = new Output();
  final ControlPanel controlPanel = new ControlPanel();

  // Configure the button bindings
  final Joystick controller = new Joystick(0);
  final DoubleSupplier leftsupply = () -> controller.getRawAxis(1);
  final DoubleSupplier rightsupply = () -> controller.getRawAxis(5);
  final DoubleSupplier elevatorSupplier = () -> controller.getRawAxis(4) - controller.getRawAxis(3);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {


    CameraServer.getInstance().startAutomaticCapture();



    m_drivetrain.setDefaultCommand(new TankDrive(
    leftsupply,
    rightsupply, m_drivetrain));

    m_elevator.setDefaultCommand(new MoveElevator(elevatorSupplier, m_elevator));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      // Assign default commands

      //Print color string to console 
      //TODO replace with a command that does this in initialization and returns true on isFinished()
      new JoystickButton(controller, 1).whenPressed(()->{
        String gameString = DriverStation.getInstance().getGameSpecificMessage();
        System.out.println(gameString);
        DriverStation.reportError(gameString, false);
        SmartDashboard.putString("DB/String 0", gameString);
      });

      new JoystickButton(controller, 2).whileHeld(new RunOutput(()->-1.0, m_output));
      new JoystickButton(controller, 3).whileHeld(new RunIntake(()->-1.0, m_intake));
      new JoystickButton(controller, 4).whileHeld(new RunIntake(()->1.0, m_intake));
      new JoystickButton(controller, 5).whileHeld(new RunOutput(()->1.0, m_output));
      new JoystickButton(controller, 6).whenPressed(new ControlPanelPosition(controlPanel));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
