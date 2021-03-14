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

public class IHaveTheHighGround extends SubsystemBase {
  /**
   * Creates a new IHaveTheHighGround.
   */
  private static WPI_TalonFX winch = new WPI_TalonFX(Constants.WINCH);
  public IHaveTheHighGround() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void m_climbUp(){
    winch.set(Constants.WINCH_SPEED);
  }
  public void m_climbDown(){
    winch.set(-Constants.WINCH_SPEED);
  }
  public void m_climbOff(){
    winch.set(0);
  }
}
