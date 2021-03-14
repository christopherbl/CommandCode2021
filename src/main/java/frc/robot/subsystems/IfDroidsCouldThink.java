package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class IfDroidsCouldThink extends  SubsystemBase {
  private static WPI_TalonSRX intakeHorizontalMotor = new WPI_TalonSRX(Constants.INTAKE_HORIZONTAL_MOTOR_PORT);

  private final DigitalInput irSensor1;
  private final DigitalInput irSensor2;
  private final DigitalInput irSensor3;
  private final DigitalInput irSensor4;

  private boolean on = false;

  public IfDroidsCouldThink() {
    irSensor1 = new DigitalInput(Constants.IR_SENSOR_1_PORT);
    irSensor2 = new DigitalInput(Constants.IR_SENSOR_2_PORT);
    irSensor3 = new DigitalInput(Constants.IR_SENSOR_3_PORT);
    irSensor4 = new DigitalInput(Constants.IR_SENSOR_4_PORT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("on", on);
    SmartDashboard.putNumber("test", intakeHorizontalMotor.get());
    intakeHorizontalMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void m_spinHorizontalMotorIn(){
    intakeHorizontalMotor.set(Constants.INTAKE_HORIZONTAL_MOTOR_SPEED);
    on = true;
  }

  public void m_spinHorizontalMotorOut(){
    intakeHorizontalMotor.set(Constants.INTAKE_HORIZONTAL_MOTOR_REVERSE_SPEED);
    on = true;
  }

  public void m_stopHorizontalMotor(){
    intakeHorizontalMotor.stopMotor();
    on = false;
  }

  public boolean m_getSensor1(){
    return irSensor1.get();
  }

  public boolean m_getSensor2(){
    return irSensor2.get();
  }

  public boolean m_getSensor3(){
    return irSensor3.get();
  }

  public boolean m_getSensor4(){
    return irSensor4.get();
  }
}