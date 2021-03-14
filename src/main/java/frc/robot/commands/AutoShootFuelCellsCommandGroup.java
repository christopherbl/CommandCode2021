/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.ExecuteOrder66;
import frc.robot.subsystems.IfDroidsCouldThink;
import frc.robot.subsystems.PowerUnlimitedPower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoShootFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoShootFuelCellsCommandGroup.
   */
  public AutoShootFuelCellsCommandGroup(ExecuteOrder66 m_executeOrder66, IfDroidsCouldThink m_ifDroidsCouldThink, PowerUnlimitedPower m_powerUnlimitedPower) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new AutoLoadFuelCellsCommandGroup(m_ifDroidsCouldThink, m_powerUnlimitedPower),
        new ShooterCommand(m_executeOrder66)
    );
  }
}
