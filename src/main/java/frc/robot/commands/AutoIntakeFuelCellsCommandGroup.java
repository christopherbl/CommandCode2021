/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.AFineAdditionToMyCollection;
import frc.robot.subsystems.AutoDrive;
import frc.robot.subsystems.IfDroidsCouldThink;
import frc.robot.subsystems.NowThisIsPodracing;
import frc.robot.subsystems.PowerUnlimitedPower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoIntakeFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoIntakeFuelCellsCommandGroup.
   */
  public AutoIntakeFuelCellsCommandGroup(AutoDrive drive, AFineAdditionToMyCollection m_aFineAdditionToMyCollection,
                                        IfDroidsCouldThink m_ifDroidsCouldThink, PowerUnlimitedPower m_powerUnlimitedPower,
                                        NowThisIsPodracing m_nowThisIsPodracing) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new DriveForwardToFuelCellsCommandGroup(drive, m_nowThisIsPodracing),
        new IntakeWheelsInCommand(m_aFineAdditionToMyCollection),
        new DefaultFunnelCommand(m_ifDroidsCouldThink, m_powerUnlimitedPower)
    );
  }
}
