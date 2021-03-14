/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AFineAdditionToMyCollection;
import frc.robot.subsystems.AnotherHappyLanding;
import edu.wpi.first.wpilibj.Timer;

public class ResetWheelIntakeCommand extends CommandBase {
  private final AFineAdditionToMyCollection m_aFineAdditionToMyCollection;
  private final AnotherHappyLanding m_anotherHappyLanding;
  private final Timer timer = new Timer();
  private double tempTimer;

  /**
   * Creates a new ResetWheelIntakeCommand.
   */
  public ResetWheelIntakeCommand(AFineAdditionToMyCollection intakeWheelsSubsystem, AnotherHappyLanding dropIntakeSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_aFineAdditionToMyCollection = intakeWheelsSubsystem;
    m_anotherHappyLanding = dropIntakeSubsystem;
    addRequirements(m_aFineAdditionToMyCollection);
    addRequirements(m_anotherHappyLanding);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_aFineAdditionToMyCollection.m_stopWheels();
    timer.start();
    tempTimer = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_anotherHappyLanding.m_raiseIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_anotherHappyLanding.m_stopMovingIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() >= tempTimer + Constants.TIME_FOR_RAISING_INTAKE){
      return true;
    }else{
      return false;
    }
  }
}
