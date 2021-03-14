/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IfDroidsCouldThink;
import frc.robot.subsystems.PowerUnlimitedPower;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DefaultFunnelCommand extends CommandBase {
  private final IfDroidsCouldThink m_ifDroidsCouldThink;
  private final PowerUnlimitedPower m_powerUnlimitedPower;
  private boolean firstIRSensor, secondIRSensor, thirdIRSensor, fourthIRSensor;

  private static boolean temp = true;
  private static double tempTime = 0;

  /**
   * Creates a new DefaultFunnelCommand.
   */
  public DefaultFunnelCommand(IfDroidsCouldThink horizontalSubsystem, PowerUnlimitedPower verticalSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_ifDroidsCouldThink = horizontalSubsystem;
    m_powerUnlimitedPower = verticalSubsystem;
    addRequirements(m_ifDroidsCouldThink);
    addRequirements(m_powerUnlimitedPower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ifDroidsCouldThink.m_stopHorizontalMotor();
    m_powerUnlimitedPower.m_stopVerticalMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    firstIRSensor = !m_ifDroidsCouldThink.m_getSensor1();
    secondIRSensor = !m_ifDroidsCouldThink.m_getSensor2();
    thirdIRSensor = !m_ifDroidsCouldThink.m_getSensor3();
    fourthIRSensor = !m_ifDroidsCouldThink.m_getSensor4();

    SmartDashboard.putString("IR Sensor 1", Boolean.toString(firstIRSensor));
    SmartDashboard.putString("IR Sensor 2", Boolean.toString(secondIRSensor));
    SmartDashboard.putString("IR Sensor 3", Boolean.toString(thirdIRSensor));
    SmartDashboard.putString("IR Sensor 4", Boolean.toString(fourthIRSensor));

    SmartDashboard.putBoolean("temp", temp);
    SmartDashboard.putNumber("tempTime", tempTime);

    if(!secondIRSensor && !thirdIRSensor && !fourthIRSensor && firstIRSensor){
      m_ifDroidsCouldThink.m_spinHorizontalMotorIn();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
    else if (firstIRSensor && secondIRSensor && thirdIRSensor && fourthIRSensor){
      m_ifDroidsCouldThink.m_stopHorizontalMotor();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
    else if(fourthIRSensor && !thirdIRSensor && !secondIRSensor && firstIRSensor){
      m_ifDroidsCouldThink.m_spinHorizontalMotorIn();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
    else if(fourthIRSensor && !thirdIRSensor && secondIRSensor){
      m_ifDroidsCouldThink.m_stopHorizontalMotor();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
    else if(secondIRSensor || thirdIRSensor){
      m_ifDroidsCouldThink.m_stopHorizontalMotor();
      m_powerUnlimitedPower.m_spinVerticalMotorIn();
    }
    else if (fourthIRSensor && thirdIRSensor && secondIRSensor){
      m_ifDroidsCouldThink.m_stopHorizontalMotor();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
    else{
      m_ifDroidsCouldThink.m_stopHorizontalMotor();
      m_powerUnlimitedPower.m_stopVerticalMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
