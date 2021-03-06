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

public class IDontMindFlyingButThisIsSuicide extends SubsystemBase {
  /**
   * Creates a new IDontMindFlyingButThisIsSuicide.
   */
  private static WPI_TalonFX adjustmentMotor = new WPI_TalonFX(Constants.ADJUSTMENT_MOTOR);

  public IDontMindFlyingButThisIsSuicide() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void m_leftOn(){
    adjustmentMotor.set(-Constants.ADJUSTMENT_SPEED);
  }
  public void m_rightOn(){
    adjustmentMotor.set(Constants.ADJUSTMENT_SPEED);

  }
  public void m_leftOff(){
    adjustmentMotor.set(0);

  }
  public void m_rightOff(){
    adjustmentMotor.set(0);
  }
}
