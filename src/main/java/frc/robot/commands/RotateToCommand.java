/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.NowThisIsPodracing;;

public class RotateToCommand extends CommandBase {
  private static final double MIN_POWER = 0.25;
  private static final double DEG_TOLERANCE = Robot.isReal() ? 3 : 4.5;
  private static final int CORRECT_LOOPS_NEEDED = Robot.isReal() ? 4 : 1;    // need it to be correct for 4 loops if real robot
  private NowThisIsPodracing driveTrain;
  private double targetHeading;
  private int correctLoops;

  /**
   * Creates a new RotateToCommand.
   */
  public RotateToCommand(NowThisIsPodracing driveTrain, double targetHeading) {
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
    this.targetHeading = targetHeading;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.correctLoops = 0;
    // System.out.println("ROTATE TO COMMAND");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentHeading = driveTrain.getHeading();
    double error = targetHeading - currentHeading;
    // System.out.printf("targetHeading1= %.2f ",targetHeading);
    // System.out.printf("currentHeading1= %.2f ",currentHeading);
    // System.out.println("");
    // System.out.printf("LeftMeters= %.2f ",driveTrain.getLeftMeters());
    // System.out.printf("RightMeters= %.2f ",driveTrain.getRightMeters());
    // System.out.printf("AvgMeters= %.2f ",driveTrain.getAvgMeters());
    // System.out.println("");  
    if (Math.abs(error) <= DEG_TOLERANCE) {
      System.out.println("CORRECT!");
      // System.out.printf("targetHeading2= %.2f ",targetHeading);
      // System.out.printf("currentHeading2= %.2f ",currentHeading);
      // System.out.println("");
      correctLoops++;
      return;
    } else {
      correctLoops = 0;
    }
    driveTrain.m_arcadeDrive(0, 5, 1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.m_arcadeDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return correctLoops >= CORRECT_LOOPS_NEEDED;
  }
}
