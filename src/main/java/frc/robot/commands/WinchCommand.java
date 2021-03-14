/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IHaveTheHighGround;
public class WinchCommand extends CommandBase {
  /**
   * Creates a new WinchCommand.
   */
  private final IHaveTheHighGround m_iHaveTheHighGround;

  public WinchCommand(IHaveTheHighGround winchSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_iHaveTheHighGround = winchSubsystem;
    addRequirements(m_iHaveTheHighGround);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_whatAboutTheDroidAttackOnTheWookies.m_liftOff(); - not sure if needed

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_iHaveTheHighGround.m_climbUp();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_iHaveTheHighGround.m_climbOff();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
