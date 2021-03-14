/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants;

public class AFineAdditionToMyCollection extends SubsystemBase {
  private static WPI_TalonFX intakeWheelMotor = new WPI_TalonFX(Constants.INTAKE_WHEEL_MOTOR_PORT);

  /**
   * Creates a new AFineAdditionToMyCollection.
   */
  public AFineAdditionToMyCollection() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    intakeWheelMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void m_spinWheelsIn(){
    intakeWheelMotor.set(Constants.INTAKE_WHEEL_MOTOR_SPEED);
  }

  public void m_spinWheelsOut(){
    intakeWheelMotor.set(-Constants.INTAKE_WHEEL_MOTOR_SPEED);
  }

  public void m_stopWheels(){
    intakeWheelMotor.stopMotor();
  }
}
