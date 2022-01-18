/**
 * 1.17.22
 * @author Finley Doolittle (4501)
 * @author Fox Raggio (4501)
 * Simple Falcon 500 Tank Drive Code
 */

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.constant.Constants;



public class Robot extends TimedRobot {
  
  //DiferentialDrive

  private DifferentialDrive ddrive;

  //JoyStick

  private Joystick jleft = new Joystick(0);
  private Joystick jRight = new Joystick(1);

  //MotorControllerGroup

  MotorControllerGroup sleft;  //Left side control 
  MotorControllerGroup sright; //Right side control 

  //Falcons

  private WPI_TalonFX left0 = new WPI_TalonFX(Constants.Motors.LEFT_FORWARD);  //CAN = 41
  private WPI_TalonFX left1 = new WPI_TalonFX(Constants.Motors.LEFT_BACKWARD);  //CAN = 42
  private WPI_TalonFX right0 = new WPI_TalonFX(Constants.Motors.RIGHT_FORWARD); //CAN = 43
  private WPI_TalonFX right1 = new WPI_TalonFX(Constants.Motors.RIGHT_BACKWARD); //CAN = 44
  
  @Override
  public void robotInit() {
    
    sleft = new MotorControllerGroup(left0, left1);
    sright = new MotorControllerGroup(right0, right1);
    right0.setInverted(true);
    right1.setInverted(true);
    
    ddrive = new DifferentialDrive(left0, right0);
  }

  public void teleopPeriodic() {
    ddrive.tankDrive(jleft.getY(), jRight.getY());
  }
}