package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class PowerUnlimitedPower extends  SubsystemBase {
  private static WPI_TalonSRX intakeVerticalMotor = new WPI_TalonSRX(Constants.INTAKE_VERTICAL_MOTOR_PORT);

  public PowerUnlimitedPower() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    intakeVerticalMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void m_spinVerticalMotorIn(){
    intakeVerticalMotor.set(Constants.INTAKE_VERTICAL_MOTOR_SPEED);
  }

  public void m_spinVerticalMotorOut(){
    intakeVerticalMotor.set(Constants.INTAKE_VERTICAL_MOTOR_REVERSE_SPEED);
  }

  public void m_stopVerticalMotor(){
    intakeVerticalMotor.stopMotor();
  }
}