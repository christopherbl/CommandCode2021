/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// need pid controller for horizontal but not vertical (servo motor)
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class AimHorizontal extends SubsystemBase {
  /* the name of the motor from the maunfacturers website is "RS775-125".
   * it has an encoder and is "for PG27 Gearbox" whatever that means */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");

  WPI_TalonSRX turnTurretMotorHorizontal = new WPI_TalonSRX(Constants.TURN_TURRET_MOTOR_HORIZONTAL_PORT);
  double steering_adjust = 0.0;

  /**
   * Creates a new AimHorizontal.
   */
  public AimHorizontal() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void m_aimHorizontal(){
    double x = tx.getDouble(0.0);

    double heading_error = -x;

    SmartDashboard.putNumber("Steering Adjust", steering_adjust);
    SmartDashboard.putNumber("Limelight x", x);
    if (x > 1.0)
    {
      steering_adjust = Constants.KP*heading_error - Constants.MIN_COMMAND;
    }
    else if (x < 1.0)
    {
      steering_adjust = Constants.KP*heading_error + Constants.MIN_COMMAND;
    }
    turnTurretMotorHorizontal.set(steering_adjust);
  }

  public void m_stopTurning(){
    turnTurretMotorHorizontal.stopMotor();
  }

  public void m_TurnOnLimelight(){
    table.getEntry("ledMode").setNumber(0);
  }

  public void m_TurnOffLimelight(){
    table.getEntry("ledMode").setNumber(1);
  }

  public double m_getSteeringAdjust(){
    return steering_adjust;
  }

  public void m_initializeShooter(){
    turnTurretMotorHorizontal.set(0.5);
  }
}
