/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AimHorizontal;
import frc.robot.subsystems.AimVertical;

public class AutoAimCommand extends CommandBase {
  /**
   * Creates a new TurretCommand.
   */
  private final AimHorizontal m_aimHorizontal;
  private final AimVertical m_aimVertical;
  private final double delay;
  private double temp;

  public AutoAimCommand(AimHorizontal turnHorizontal, AimVertical turnVertical) {
    // Use addRequirements() here to declare subsystem dependencies.
    delay = Constants.AIM_DELAY;
    m_aimHorizontal = turnHorizontal;
    m_aimVertical = turnVertical;
    addRequirements(m_aimHorizontal);
    addRequirements(m_aimVertical);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_aimHorizontal.m_TurnOnLimelight();
    temp = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    m_aimHorizontal.m_aimHorizontal();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_aimVertical.m_aimVertical();
    m_aimHorizontal.m_TurnOffLimelight();
    m_aimHorizontal.m_stopTurning();
    //m_aimVertical.m_stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Timer.getFPGATimestamp() >= temp + delay){
      return true;
    }else{
      return false;
    }
  }
}
