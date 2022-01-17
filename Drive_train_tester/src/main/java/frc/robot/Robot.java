/**
 * 1.17.22
 * @author Finley Doolittle (4501)
 * @author Fox Raggio (4501)
 * Simple Falcon 500 drive trian code 
 */

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.constant.Constants;

public class Robot extends TimedRobot {
  //Joy_stick
  private Joystick jleft = new Joystick(0);
  private Joystick jRight = new Joystick(1);
  //MotorControllerGroup
  MotorControllerGroup sleft; 
  MotorControllerGroup sright; 
  //Drive_trian_motors
  private DifferentialDrive ddrive;
  private WPI_TalonFX left0 = new WPI_TalonFX(Constants.Motors.LEFT_FORWARD);
  private WPI_TalonFX left1 = new WPI_TalonFX(Constants.Motors.LEFT_BACKWARD);
  private WPI_TalonFX right0 = new WPI_TalonFX(Constants.Motors.RIGHT_FORWARD);
  private WPI_TalonFX right1 = new WPI_TalonFX(Constants.Motors.RIGHT_BACKWARD);

  @Override
  public void robotInit() {
    sleft = new MotorControllerGroup(left0, left1);
    sright = new MotorControllerGroup(right0, right1);
    ddrive = new DifferentialDrive(left0, right0);
  }

  @Override
  public void teleopPeriodic() {

    ddrive.tankDrive(jleft.getY(), jRight.getY());

  
  }
}



