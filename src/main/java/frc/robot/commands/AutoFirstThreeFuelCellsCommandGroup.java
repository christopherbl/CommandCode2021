/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Constants;
import frc.robot.subsystems.IfDroidsCouldThink;
import frc.robot.subsystems.PowerUnlimitedPower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoFirstThreeFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoFirstThreeFuelCellsCommandGroup.
   */
  public AutoFirstThreeFuelCellsCommandGroup(IfDroidsCouldThink m_ifDroidsCouldThink, PowerUnlimitedPower m_powerUnlimitedPower) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new DelayCommand(Constants.TIME_TO_LOAD_FIRST_THREE_FUEL_CELLS),
        new LoadFuelCellsCommand(m_ifDroidsCouldThink, m_powerUnlimitedPower)
    );
  }
}
