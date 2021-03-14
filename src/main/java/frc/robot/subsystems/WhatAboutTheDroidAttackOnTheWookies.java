/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
 
//import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WhatAboutTheDroidAttackOnTheWookies extends SubsystemBase {
  /**
   * Creates a new WhatAboutTheDroidAttackOnTheWookies.
   */
  private static WPI_VictorSPX lift = new WPI_VictorSPX(Constants.LIFT);
  public WhatAboutTheDroidAttackOnTheWookies() {

  }

  public void periodic(){

  }

  public void m_moveLiftUp() {
    lift.set(Constants.LIFT_UP_SPEED);
  }

  public void m_moveLiftDown(){
    lift.set(Constants.LIFT_DOWN_SPEED);
  }

  public void m_stopLift(){
    lift.stopMotor();
  }
}
