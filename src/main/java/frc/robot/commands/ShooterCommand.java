/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExecuteOrder66;

public class ShooterCommand extends CommandBase {
  /**
   * Creates a new ShooterCommand.
   */
  private final ExecuteOrder66 m_executeOrder66;

  public ShooterCommand(ExecuteOrder66 fireBall) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_executeOrder66 = fireBall;
    addRequirements(m_executeOrder66);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_executeOrder66.m_shoot();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_executeOrder66.m_stopSpinning();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
