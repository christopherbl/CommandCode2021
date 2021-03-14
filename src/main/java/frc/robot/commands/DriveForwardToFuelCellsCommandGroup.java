/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AutoDrive;
import frc.robot.subsystems.NowThisIsPodracing;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveForwardToFuelCellsCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new DriveForwardToFuelCellsCommandGroup.
   */
  public DriveForwardToFuelCellsCommandGroup(AutoDrive drive, NowThisIsPodracing m_nowThisIsPodracing) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new AutoForwardsOrBackwardsCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_FORWARDS_FUEL_CELLS_DISTANCE),
      new DelayCommand(Constants.DELAY_AFTER_PICKING_UP_FUEL_CELLS)
    );
  }
}
