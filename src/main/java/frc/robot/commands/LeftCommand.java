/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IDontMindFlyingButThisIsSuicide;

public class LeftCommand extends CommandBase {
  /**
   * Creates a new LeftCommand.
   */
  private final IDontMindFlyingButThisIsSuicide m_iDontMindFlyingButThisIsSuicide;
  public LeftCommand(IDontMindFlyingButThisIsSuicide adjustmentSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_iDontMindFlyingButThisIsSuicide = adjustmentSubsystem;
    addRequirements(m_iDontMindFlyingButThisIsSuicide);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_iDontMindFlyingButThisIsSuicide.m_rightOff();
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_iDontMindFlyingButThisIsSuicide.m_leftOn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_iDontMindFlyingButThisIsSuicide.m_leftOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
