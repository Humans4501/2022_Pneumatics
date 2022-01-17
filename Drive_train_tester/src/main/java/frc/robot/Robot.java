package frc.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.constant.Constants;

public class Robot extends TimedRobot {
  //JoyStick
  private Joystick jleft = new Joystick(0);
  private Joystick jRight = new Joystick(1);
  //MotorControllerGroup
  MotorControllerGroup sleft; 
  MotorControllerGroup sright; 
  //Drive trian
  private DifferentialDrive ddrive;
  private WPI_TalonFX left0 = new WPI_TalonFX(Constants.Motors.LEFT_FORWARD);
  private WPI_TalonFX left1 = new WPI_TalonFX(Constants.Motors.LEFT_BACKWARD);
  private WPI_TalonFX right0 = new WPI_TalonFX(Constants.Motors.RIGHT_FORWARD);
  private WPI_TalonFX right1 = new WPI_TalonFX(Constants.Motors.RIGHT_BACKWARD);
  
  public static void wait(int ms)
{
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
}

  @Override
  public void robotInit() {
    sleft = new MotorControllerGroup(left0, left1);
    sright = new MotorControllerGroup(right0, right1);

    right0.setInverted(true);
    right1.setInverted(true);

    ddrive = new DifferentialDrive(left0, right0); 

  }

  @Override
  public void teleopPeriodic() {
    ddrive.tankDrive(jleft.getY(), jRight.getY());
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {

  double time = Timer.getFPGATimestamp(); 

  if (time <  120) {
    sleft.set(0.75);
    sright.set(0.75);
  } else { 
    sleft.set(0);
    sright.set(0); 
  }

  wait(5000);
  
  if (time < 120) {
    sleft.set(-0.75); 
    sright.set(-0.75);
  } else { 
    sleft.set(0.0); 
    sright.set(0.0); 
  }

  }
} 

