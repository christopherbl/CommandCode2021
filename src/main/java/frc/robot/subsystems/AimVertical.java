/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// do not need pid controller for vertical aim motor (servo motor)
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class AimVertical extends SubsystemBase {
  Servo turnTurretMotorVert = new Servo(Constants.TURN_TURRET_MOTOR_VERT_PORT);
  
  /**
   * Creates a new AimVertical.
   */
  public AimVertical() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void m_aimVertical(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    NetworkTableEntry ta = table.getEntry("ta");

    double area = ta.getDouble(0.0);

    double angle = 0.5063092 * Math.exp(-(area - 1.475047)*(area - 1.475047)/(2*0.9995115*0.9995115));

    turnTurretMotorVert.set(angle);

    SmartDashboard.putNumber("Servo Position", turnTurretMotorVert.get());
  }

  public void m_stop(){
    //turnTurretMotorVert.stopMotor();
  }
}




