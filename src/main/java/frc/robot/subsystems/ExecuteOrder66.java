/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ExecuteOrder66 extends SubsystemBase {
  WPI_TalonFX leftShooterMotor = new WPI_TalonFX(Constants.LEFT_SHOOTER_MOTOR_PORT);
  WPI_TalonFX rightShooterMotor = new WPI_TalonFX(Constants.RIGHT_SHOOTER_MOTOR_PORT);

  /**
   * Creates a new ExecuteOrder66.
   */
  public ExecuteOrder66() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
   
  public void m_shoot() {
    leftShooterMotor.set(Constants.TURRET_FIRE_SPEED);
    rightShooterMotor.set(-Constants.TURRET_FIRE_SPEED);
  }

  public void m_stopSpinning() {
    leftShooterMotor.stopMotor();
    rightShooterMotor.stopMotor();
  }
}
