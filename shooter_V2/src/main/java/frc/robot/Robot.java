// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.Constants;


public class Robot extends TimedRobot {
  private DifferentialDrive ddrive;
  private static final int kJoystickPort = 0;
  private static final int kJoystick2Port = 1; 
  private MotorControllerGroup sleft; /** Left side control */
  private MotorControllerGroup sright; /** Right side control */
  private Joystick jleft = new Joystick(0);
  private Joystick jright = new Joystick(1);
  private WPI_TalonFX left0 = new WPI_TalonFX(Constants.Motors.LEFT_FALCON); 
  private WPI_TalonFX right0 = new WPI_TalonFX(Constants.Motors.RIGHT_FALCON); 

  @Override
  public void robotInit() {
    sleft = new MotorControllerGroup(left0);
    sright = new MotorControllerGroup(right0); 
    ddrive = new DifferentialDrive(left0, right0);
    this.left0.setInverted(true);
    jleft = new Joystick(kJoystickPort);
    jright = new Joystick(kJoystick2Port);
  }

  @Override
  public void teleopPeriodic() {

    ddrive.tankDrive(jleft.getY(), jright.getY());
    
  }
}
