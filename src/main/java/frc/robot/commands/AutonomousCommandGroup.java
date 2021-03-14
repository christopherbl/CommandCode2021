/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants;
import frc.robot.subsystems.AFineAdditionToMyCollection;
import frc.robot.subsystems.AimHorizontal;
import frc.robot.subsystems.AimVertical;
import frc.robot.subsystems.AnotherHappyLanding;
import frc.robot.subsystems.ExecuteOrder66;
import frc.robot.subsystems.IfDroidsCouldThink;
import frc.robot.subsystems.PowerUnlimitedPower;
import frc.robot.subsystems.AutoDrive;
import frc.robot.subsystems.NowThisIsPodracing;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutonomousCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new AutonomousCommandGroup.
   */
  public AutonomousCommandGroup(AimHorizontal m_aimHorizontal, AimVertical m_aimVertical,
                                ExecuteOrder66 m_executeOrder66,
                                IfDroidsCouldThink m_ifDroidsCouldThink, PowerUnlimitedPower m_powerUnlimitedPower,
                                AFineAdditionToMyCollection m_aFineAdditionToMyCollection, AnotherHappyLanding m_anotherHappyLanding,
                                AutoDrive drive,
                                NowThisIsPodracing m_nowThisIsPodracing) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(     
      new RotateToCommand(m_nowThisIsPodracing,0),
      new DriveAheadCommand(m_nowThisIsPodracing,3),
      new RotateToCommand(m_nowThisIsPodracing,-90),
      new DriveAheadCommand(m_nowThisIsPodracing,2), 
      new RotateToCommand(m_nowThisIsPodracing,180),
      new DriveAheadCommand(m_nowThisIsPodracing,2),                     
      new InitializeShooterCommand(m_aimHorizontal),
      new AutoAimCommand(m_aimHorizontal, m_aimVertical),
      new AutoShootFuelCellsCommandGroup(m_executeOrder66, m_ifDroidsCouldThink, m_powerUnlimitedPower),
      new AutoDriveTest(drive, m_nowThisIsPodracing)
      /*new AutoTurnLeftOrRightCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_TURN_LEFT_DISTANCE),
      new DropIntakeCommand(m_aFineAdditionToMyCollection, m_anotherHappyLanding),
      new AutoForwardsOrBackwardsCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_FORWARDS_BASE_LINE_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_TURN_RIGHT_DISTANCE),
      new AutoIntakeFuelCellsCommandGroup(drive, m_aFineAdditionToMyCollection, m_ifDroidsCouldThink, m_powerUnlimitedPower, m_nowThisIsPodracing),
      new AutoForwardsOrBackwardsCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_BACKWARDS_FUEL_CELLS_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_TURN_LEFT_DISTANCE),
      new AutoForwardsOrBackwardsCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_BACKWARDS_BASE_LINE_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_nowThisIsPodracing, Constants.LEFT_AUTO_TURN_RIGHT_DISTANCE),
      new AutoAimCommand(m_aimHorizontal, m_aimVertical),
      new AutoShootFuelCellsCommandGroup(m_executeOrder66, m_ifDroidsCouldThink, m_powerUnlimitedPower)*/
    );
  }
}
