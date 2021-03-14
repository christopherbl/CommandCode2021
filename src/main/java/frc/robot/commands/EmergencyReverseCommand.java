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

public class EmergencyReverseCommand extends CommandBase {
  private final IfDroidsCouldThink m_ifDroidsCouldThink;
  private final PowerUnlimitedPower m_powerUnlimitedPower;
  /**
   * Creates a new EmergencyReverseCommand.
   */
  public EmergencyReverseCommand(IfDroidsCouldThink horizontalSubsystem, PowerUnlimitedPower verticalSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_ifDroidsCouldThink = horizontalSubsystem;
    m_powerUnlimitedPower = verticalSubsystem;
    addRequirements(m_ifDroidsCouldThink);
    addRequirements(m_powerUnlimitedPower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ifDroidsCouldThink.m_spinHorizontalMotorOut();
    m_powerUnlimitedPower.m_spinVerticalMotorOut();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ifDroidsCouldThink.m_stopHorizontalMotor();
    m_powerUnlimitedPower.m_stopVerticalMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
