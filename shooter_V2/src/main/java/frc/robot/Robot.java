//2/3/22
//4501 HUMANS
//Fox Raggio

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.Constants;

public class Robot extends TimedRobot {
  private XboxController Xbox = new XboxController(1);
  private WPI_TalonFX left0 = new WPI_TalonFX(Constants.Motors.LEFT_FALCON); 
  private WPI_TalonFX right0 = new WPI_TalonFX(Constants.Motors.RIGHT_FALCON);

  @Override
  public void robotInit() {
    this.left0.setInverted(true);
  } 

  @Override
  public void teleopPeriodic() {
    if(this.Xbox.getAButtonPressed()) { //uper port speeds
      this.left0.set(-0.71);
      this.right0.set(-0.63);
    }
    if(this.Xbox.getAButtonReleased()){ 
      this.left0.stopMotor();
      this.right0.stopMotor();
    }
    if(this.Xbox.getBButtonPressed()) { //lower port speeds
      this.left0.set(-0.2);
      this.right0.set(-0.3);
    }
    if(this.Xbox.getBButtonReleased()) {
      this.left0.stopMotor();
      this.right0.stopMotor();
    }

  }
}
