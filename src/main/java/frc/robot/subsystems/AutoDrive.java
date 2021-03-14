/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;*/
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;;


public class AutoDrive extends SubsystemBase {

  private static TalonFX FrontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_PORT);
  //private static TalonFX RearLeftMotor = new TalonFX(Constants.REAR_LEFT_MOTOR_PORT);
  private static TalonFX FrontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT);
  //private static TalonFX RearRightMotor = new TalonFX(Constants.REAR_RIGHT_MOTOR_PORT);

  /*private final SpeedControllerGroup m_left =
      new SpeedControllerGroup(new WPI_TalonFX(Constants.FRONT_LEFT_MOTOR_PORT),
                               new WPI_TalonFX(Constants.REAR_LEFT_MOTOR_PORT));
 
  private final SpeedControllerGroup m_right =
      new SpeedControllerGroup(new WPI_TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT),
                               new WPI_TalonFX(Constants.REAR_RIGHT_MOTOR_PORT));
 
  private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);*/

  /**
   * Creates a new AutoDriveFowardsAndBackCommand.
   */
  public AutoDrive() {
    FrontLeftMotor.setNeutralMode(NeutralMode.Brake);
    FrontRightMotor.setNeutralMode(NeutralMode.Brake);

    FrontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

    FrontLeftMotor.setSensorPhase(Constants.PHASE_SENSOR);
    //FrontLeftMotor.setInverted(Constants.INVERTED);

    FrontLeftMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		FrontLeftMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		FrontLeftMotor.configPeakOutputForward(Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);
		FrontLeftMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);

		FrontLeftMotor.configAllowableClosedloopError(Constants.kERROR, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

		FrontLeftMotor.config_kF(Constants.PID_LOOP_IDX, Constants.kGains.kF, Constants.TIMEOUT_MS);  
    FrontLeftMotor.config_kP(Constants.PID_LOOP_IDX, Constants.kGains.kP, Constants.TIMEOUT_MS);
		FrontLeftMotor.config_kI(Constants.PID_LOOP_IDX, Constants.kGains.kI, Constants.TIMEOUT_MS);
    FrontLeftMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kD, Constants.TIMEOUT_MS);

    /*RearLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

    RearLeftMotor.setSensorPhase(Constants.PHASE_SENSOR);
    //RearLeftMotor.setInverted(Constants.INVERTED);

    RearLeftMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		RearLeftMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		RearLeftMotor.configPeakOutputForward(Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);
		RearLeftMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);

		RearLeftMotor.configAllowableClosedloopError(Constants.kERROR, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

		RearLeftMotor.config_kF(Constants.PID_LOOP_IDX, Constants.kGains.kF, Constants.TIMEOUT_MS);  
    RearLeftMotor.config_kP(Constants.PID_LOOP_IDX, Constants.kGains.kP, Constants.TIMEOUT_MS);
		RearLeftMotor.config_kI(Constants.PID_LOOP_IDX, Constants.kGains.kI, Constants.TIMEOUT_MS);
    RearLeftMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kD, Constants.TIMEOUT_MS);*/

    FrontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

    FrontRightMotor.setSensorPhase(Constants.PHASE_SENSOR);
    //FrontRightMotor.setInverted(Constants.INVERTED);

    FrontRightMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		FrontRightMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		FrontRightMotor.configPeakOutputForward(Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);
		FrontRightMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);

		FrontRightMotor.configAllowableClosedloopError(Constants.kERROR, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

		FrontRightMotor.config_kF(Constants.PID_LOOP_IDX, Constants.kGains.kF, Constants.TIMEOUT_MS);  
    FrontRightMotor.config_kP(Constants.PID_LOOP_IDX, Constants.kGains.kP, Constants.TIMEOUT_MS);
		FrontRightMotor.config_kI(Constants.PID_LOOP_IDX, Constants.kGains.kI, Constants.TIMEOUT_MS);
    FrontRightMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kD, Constants.TIMEOUT_MS);

    /*RearRightMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

    RearRightMotor.setSensorPhase(Constants.PHASE_SENSOR);
    //RearRightMotor.setInverted(Constants.INVERTED);

    RearRightMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		RearRightMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		RearRightMotor.configPeakOutputForward(Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);
		RearRightMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutput, Constants.TIMEOUT_MS);

		RearRightMotor.configAllowableClosedloopError(Constants.kERROR, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

		RearRightMotor.config_kF(Constants.PID_LOOP_IDX, Constants.kGains.kF, Constants.TIMEOUT_MS);  
    RearRightMotor.config_kP(Constants.PID_LOOP_IDX, Constants.kGains.kP, Constants.TIMEOUT_MS);
		RearRightMotor.config_kI(Constants.PID_LOOP_IDX, Constants.kGains.kI, Constants.TIMEOUT_MS);
    RearRightMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kD, Constants.TIMEOUT_MS);*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void m_driveForwardsOrBack(int distance){
    FrontLeftMotor.set(ControlMode.Position, distance);
    //RearLeftMotor.set(ControlMode.Position, -distance);
    FrontRightMotor.set(ControlMode.Position, -distance);
    //RearRightMotor.set(ControlMode.Position, distance);
    SmartDashboard.putNumber("Motor Target", FrontLeftMotor.getClosedLoopTarget(Constants.PID_LOOP_IDX));
    SmartDashboard.putNumber("Motor Position", FrontLeftMotor.getSelectedSensorPosition(Constants.PID_LOOP_IDX));
    String motorState;
    if(FrontLeftMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) > 0){
      motorState = "forward";
    }else if(FrontLeftMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) == 0){
      motorState = "stopped";
    }else{
      motorState = "reverse";
    }

    SmartDashboard.putString("Motor State", motorState);
    
    //FrontLeftMotor.set(TalonFXControlMode.PercentOutput, Constants.AUTO_DRIVE_SPEED);
    //FrontRightMotor.set(TalonFXControlMode.PercentOutput, -Constants.AUTO_DRIVE_SPEED);
  }

  public void m_zeroEncoder(){
    FrontLeftMotor.setSelectedSensorPosition(0);
    //RearLeftMotor.setSelectedSensorPosition(0);
    FrontRightMotor.setSelectedSensorPosition(0);
    //RearRightMotor.setSelectedSensorPosition(0);
  }
   
  public double m_getPosition(){
    return FrontLeftMotor.getSelectedSensorPosition();
  }

  public void m_turnLeftOrRight(int distance){
    FrontLeftMotor.set(ControlMode.Position, distance);
    //RearLeftMotor.set(ControlMode.Position, -distance);
    FrontRightMotor.set(ControlMode.Position, distance);
    //RearRightMotor.set(ControlMode.Position, -distance);
  }

  public void m_stopMotors(){
    FrontLeftMotor.set(TalonFXControlMode.PercentOutput, 0);
    FrontRightMotor.set(TalonFXControlMode.PercentOutput, 0);
  }

}
