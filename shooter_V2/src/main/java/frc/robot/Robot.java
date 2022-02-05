//2/3/22
//4501 HUMANS
//Fox Raggio

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.Constants;

public class Robot extends TimedRobot {
  private XboxController Xbox = new XboxController(1);
  private WPI_TalonFX shooter0 = new WPI_TalonFX(Constants.Motors.LEFT_FALCON); 
  private WPI_TalonFX shooter1 = new WPI_TalonFX(Constants.Motors.RIGHT_FALCON);

  @Override
  public void robotInit() {
    this.shooter1.setInverted(true);
    SmartDashboard.putNumber("leftSpeed", 0.0); 
    SmartDashboard.putNumber("rightSpeed", 0.0);
  } 

  @Override
  public void teleopPeriodic() {
//Shuffle values
    if(this.Xbox.getXButtonPressed()) { //Change value on Shuffle board
      this.shooter0.set(SmartDashboard.getNumber("leftSpeed", 0.0)); 
      this.shooter1.set(SmartDashboard.getNumber("rightSpeed", 0.0)); 
    }
    if(this.Xbox.getXButtonReleased()){ 
      this.shooter0.stopMotor();
      this.shooter1.stopMotor();
    }
//hard set values
    if(this.Xbox.getAButtonPressed()) { //uper port speeds
      this.shooter0.set(-0.71);
      this.shooter1.set(-0.63);
    }
    if(this.Xbox.getAButtonReleased()){ 
      this.shooter0.stopMotor();
      this.shooter1.stopMotor();
    }
    if(this.Xbox.getBButtonPressed()) { //lower port speeds ---> needs to be tested and tuned
      this.shooter0.set(-0.2);
      this.shooter1.set(-0.3);
    }
    if(this.Xbox.getBButtonReleased()) {
      this.shooter0.stopMotor();
      this.shooter1.stopMotor();
    }

  }
}
