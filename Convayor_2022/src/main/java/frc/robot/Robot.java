package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.Constants;

public class Robot extends TimedRobot {
  private XboxController Xbox = new XboxController(0);
  private WPI_TalonFX shooter0 = new WPI_TalonFX(Constants.Motors.LEFT_FOX); 
  private WPI_TalonFX shooter1 = new WPI_TalonFX(Constants.Motors.RIGHT_FOX);
  private CANSparkMax Conveyor1;
  private CANSparkMax Conveyor2; 
  public final int conveyor1 = 8;
  public final int conveyor2 = 5; 

  @Override
  public void robotInit() {
    /**
     * Shooter motors
     */
    this.shooter1.setInverted(true);
    SmartDashboard.putNumber("leftSpeed", 0.0); 
    SmartDashboard.putNumber("rightSpeed", 0.0);
    /**
     * Convayor motors
     */
    SmartDashboard.putNumber("Conveyor", 0.1); 
    SmartDashboard.putNumber("Conveyor-", -0.1);
    this.Conveyor2.setInverted(true);
    this.Conveyor1 = new CANSparkMax(8, MotorType.kBrushed); 
    this.Conveyor2 = new CANSparkMax(5, MotorType.kBrushed); 
    this.Conveyor1.restoreFactoryDefaults(); 
    this.Conveyor2.restoreFactoryDefaults();
  } 

  @Override
  public void teleopPeriodic() {
  //Shuffle values
    if(this.Xbox.getAButtonPressed()) { //Change value on Shuffle board
      this.shooter0.set(SmartDashboard.getNumber("leftSpeed", 0.0)); 
      this.shooter1.set(SmartDashboard.getNumber("rightSpeed", 0.0));
      this.Conveyor1.set(SmartDashboard.getNumber("Conveyor", 0.0)); 
      this.Conveyor2.set(SmartDashboard.getNumber("Conveyor", 0.0)); 
    }
    if(this.Xbox.getAButtonReleased()) { 
      this.shooter0.stopMotor();
      this.shooter1.stopMotor();
      this.Conveyor1.stopMotor();
      this.Conveyor2.stopMotor();
    }
    if(this.Xbox.getLeftBumperPressed()) {
      this.Conveyor1.set(SmartDashboard.getNumber("Conveyor", 0.0));
      this.Conveyor2.set(SmartDashboard.getNumber("Conveyor", 0.0));  
    }
    if(this.Xbox.getLeftBumperReleased()) { 
      this.Conveyor1.stopMotor(); 
      this.Conveyor2.stopMotor();
    }
    if(this.Xbox.getRightBumperPressed()) { 
      this.Conveyor1.set(SmartDashboard.getNumber("Conveyor-", 0.0)); 
      this.Conveyor2.set(SmartDashboard.getNumber("Conveyor-", 0.0)); 
    }
    if(this.Xbox.getRightBumperReleased()) { 
      this.Conveyor1.stopMotor(); 
      this.Conveyor2.stopMotor(); 
    }
  }
}