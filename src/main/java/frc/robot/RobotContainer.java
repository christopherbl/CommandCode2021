/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot;
 
import frc.robot.subsystems.*;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
 
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final NowThisIsPodracing m_nowThisIsPodracing = new NowThisIsPodracing();
  private final AnotherHappyLanding m_anotherHappyLanding = new AnotherHappyLanding();
  private final AFineAdditionToMyCollection m_aFineAdditionToMyCollection = new AFineAdditionToMyCollection();

  private final PowerUnlimitedPower m_powerUnlimitedPower = new PowerUnlimitedPower();
  private final IfDroidsCouldThink m_ifDroidsCouldThink = new IfDroidsCouldThink();

  private final WhatAboutTheDroidAttackOnTheWookies m_whatAboutTheDroidAttackOnTheWookies = new WhatAboutTheDroidAttackOnTheWookies();
  private final IHaveTheHighGround m_iHaveTheHighGround = new IHaveTheHighGround();
  private final IDontMindFlyingButThisIsSuicide m_iDontMindFlyingButThisIsSuicide = new IDontMindFlyingButThisIsSuicide();

  private final ExecuteOrder66 m_executeOrder66 = new ExecuteOrder66();
  private final AimHorizontal m_aimHorizontal = new AimHorizontal();
  private final AimVertical m_aimVertical = new AimVertical();

  //private final DropIntakeCommand m_dropIntakeCommand = new DropIntakeCommand(m_aFineAdditionToMyCollection, m_anotherHappyLanding);
  private final IntakeWheelsOutCommand m_intakeWheelsOutCommand = new IntakeWheelsOutCommand(m_aFineAdditionToMyCollection);
  private final ResetWheelIntakeCommand m_resetWheelIntakeCommand = new ResetWheelIntakeCommand(m_aFineAdditionToMyCollection, m_anotherHappyLanding);
  private final IntakeWheelsInCommand m_intakeWheelsInCommand = new IntakeWheelsInCommand(m_aFineAdditionToMyCollection);

  private final LoadFuelCellsCommand m_loadFuelCellsCommand = new LoadFuelCellsCommand(m_ifDroidsCouldThink, m_powerUnlimitedPower);
  private final EmergencyReverseCommand m_emergencyReverseCommand = new EmergencyReverseCommand(m_ifDroidsCouldThink, m_powerUnlimitedPower);
  private final DefaultFunnelCommand m_defaultFunnelCommand = new DefaultFunnelCommand(m_ifDroidsCouldThink, m_powerUnlimitedPower);
  private final TurnVerticalCommand m_turnVerticalCommand = new TurnVerticalCommand(m_powerUnlimitedPower);

  private final DropIntakeCommandGroup m_dropIntakeCommandGroup = new DropIntakeCommandGroup(m_aFineAdditionToMyCollection, m_anotherHappyLanding);
  //private final IntakeWheelsOutCommandGroup m_intakeWheelsOutCommandGroup = new IntakeWheelsOutCommandGroup(m_aFineAdditionToMyCollection);
 // private final WheelIntake m_WheelIntake = new WheelIntake();
  //private final IntakeCommand m_IntakeCommand = new IntakeCommand();
 
  private final LeftCommand m_leftCommand = new LeftCommand(m_iDontMindFlyingButThisIsSuicide);
  private final RightCommand m_rightCommand = new RightCommand(m_iDontMindFlyingButThisIsSuicide);

  //private final WinchDownCommand m_winchDownCommand = new WinchDownCommand(m_iHaveTheHighGround);
  private final WinchCommand m_winchCommand = new WinchCommand(m_iHaveTheHighGround);

  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_executeOrder66);
  private final TurretCommand m_turretCommand = new TurretCommand(m_aimHorizontal, m_aimVertical);

  private final LiftUpCommand m_liftUpCommand = new LiftUpCommand(m_whatAboutTheDroidAttackOnTheWookies);
  private final LiftDownCommand m_liftDownCommand = new LiftDownCommand(m_whatAboutTheDroidAttackOnTheWookies);

  private final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);
  private final Joystick buttonsJoystick = new Joystick(Constants.BUTTONS_JOYSTICK_PORT);
  private final Joystick driveController = new Joystick(Constants.DRIVE_CONTROLLER_PORT);
  private final Joystick buttonsController = new Joystick(Constants.BUTTONS_CONTROLLER_PORT);

  //private final SendableChooser<Joystick> driveChooser = new SendableChooser<Joystick>();
  //private final SendableChooser<Joystick> buttonsChooser = new SendableChooser<Joystick>();

  private final AutoDrive m_autoDrive = new AutoDrive();

  // private final AutoDriveTest m_autoDriveTest = new AutoDriveTest(m_autoDrive, m_nowThisIsPodracing);

  private final AutonomousCommandGroup m_autonomousCommandGroup = new AutonomousCommandGroup(m_aimHorizontal, m_aimVertical, m_executeOrder66, m_ifDroidsCouldThink, m_powerUnlimitedPower, m_aFineAdditionToMyCollection, m_anotherHappyLanding, m_autoDrive, m_nowThisIsPodracing);

 // JoystickButton dropIntakeButton = new JoystickButton(driveJoystick, Constants.dropIntakeButton);
 // JoystickButton intakeOutButton = new JoystickButton(driveJoystick, Constants.intakeOutButton);
 
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    /*driveChooser.setDefaultOption("Drive Joystick", driveJoystick);
    driveChooser.addOption("Drive Controller", driveController);

    buttonsChooser.setDefaultOption("Buttons Controller", buttonsController);
    buttonsChooser.addOption("Buttons Joystick", buttonsJoystick);

    SmartDashboard.putData("Drive Chooser", driveChooser);
    SmartDashboard.putData("Buttons Chooser", buttonsChooser);*/

    // Configure the button bindings
    configureButtonBindings();
 
    m_nowThisIsPodracing.setDefaultCommand(
      new DriveCommand(m_nowThisIsPodracing, 
      () -> -driveJoystick.getRawAxis(1), 
      () -> -driveJoystick.getRawAxis(2),
      () -> driveJoystick.getRawAxis(3)));
  
    /*m_whatAboutTheDroidAttackOnTheWookies.setDefaultCommand(
      new LiftCommand(m_whatAboutTheDroidAttackOnTheWookies,
      () -> buttonsJoystick.getRawAxis(3),
      () -> buttonsJoystick.getRawAxis(2)));*/
  

    m_ifDroidsCouldThink.setDefaultCommand(m_defaultFunnelCommand);
    m_powerUnlimitedPower.setDefaultCommand(m_defaultFunnelCommand);
  }
 
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //if(driveChooser.getSelected().equals(driveJoystick)){
      JoystickButton dropIntakeButton = new JoystickButton(driveJoystick, Constants.DROP_INTAKE_JOYSTICK_BUTTON);
      dropIntakeButton.whileActiveOnce(m_dropIntakeCommandGroup, Constants.INTERRUPTIBLE).whenInactive(m_resetWheelIntakeCommand, Constants.INTERRUPTIBLE);

      Trigger intakeOutTrigger = new JoystickButton(driveJoystick, Constants.INTAKE_OUT_JOYSTICK_BUTTON)
      .and(new JoystickButton(driveJoystick, Constants.DROP_INTAKE_JOYSTICK_BUTTON));
      intakeOutTrigger.whileActiveContinuous(m_intakeWheelsOutCommand, Constants.INTERRUPTIBLE)
      .whenInactive(m_intakeWheelsInCommand, Constants.INTERRUPTIBLE);
    /*}else{
      JoystickButton dropIntakeButton = new JoystickButton(driveController, Constants.DROP_INTAKE_CONTROLLER_BUTTON);
      dropIntakeButton.whileActiveOnce(m_dropIntakeCommandGroup, Constants.INTERRUPTIBLE).whenInactive(m_resetWheelIntakeCommand, Constants.INTERRUPTIBLE);
  
      Trigger intakeOutTrigger = new JoystickButton(driveController, Constants.INTAKE_OUT_CONTROLLER_BUTTON)
      .and(new JoystickButton(driveController, Constants.DROP_INTAKE_CONTROLLER_BUTTON));
      intakeOutTrigger.whileActiveContinuous(m_intakeWheelsOutCommand, Constants.INTERRUPTIBLE)
      .whenInactive(m_intakeWheelsInCommand, Constants.INTERRUPTIBLE);
    }
    if(buttonsChooser.getSelected().equals(buttonsController)){*/
      JoystickButton loadFuelCellsButton = new JoystickButton(buttonsController, Constants.LOAD_FUEL_CELLS_CONTROLLER_BUTTON);
      loadFuelCellsButton.whileActiveOnce(m_loadFuelCellsCommand, Constants.INTERRUPTIBLE);  

      JoystickButton emergencyReverseButton = new JoystickButton(buttonsController, Constants.EMERGENCY_REVERSE_CONTROLLER_BUTTON);
      emergencyReverseButton.whileActiveContinuous(m_emergencyReverseCommand, Constants.INTERRUPTIBLE);

      JoystickButton turnVerticalButton = new JoystickButton(buttonsController, Constants.TURN_VERTICAL_CONTROLLER_BUTTON);
      turnVerticalButton.whileActiveContinuous(m_turnVerticalCommand, Constants.NOT_INTERRUPTIBLE);
    
      JoystickButton winchButton = new JoystickButton(buttonsController, Constants.WINCH_CONTROLLER_BUTTON);
      winchButton.whileActiveContinuous(m_winchCommand, Constants.INTERRUPTIBLE);

      JoystickButton leftButton = new JoystickButton(buttonsController, Constants.LEFT_CONTROLLER_BUTTON);
      leftButton.whileActiveContinuous(m_leftCommand, Constants.INTERRUPTIBLE);

      JoystickButton rightButton = new JoystickButton(buttonsController, Constants.RIGHT_CONTROLLER_BUTTON);
      rightButton.whileActiveContinuous(m_rightCommand, Constants.INTERRUPTIBLE);
    
      JoystickButton fireBallTrigger = new JoystickButton(buttonsController, Constants.KOBE_CONTROLLER_BUTTON);
      fireBallTrigger.whileActiveContinuous(m_shooterCommand, Constants.INTERRUPTIBLE);
      
      JoystickButton aimTrigger = new JoystickButton(buttonsController, Constants.AIM_CONTROLLER_BUTTON);
      aimTrigger.whileActiveContinuous(m_turretCommand, Constants.INTERRUPTIBLE);

      JoystickButton liftUpButton = new JoystickButton(buttonsController, Constants.LIFT_UP_CONTROLLER_BUTTON);
      liftUpButton.whileActiveContinuous(m_liftUpCommand, Constants.INTERRUPTIBLE);

      JoystickButton liftDownButton = new JoystickButton(buttonsController, Constants.LIFT_DOWN_CONTROLLER_BUTTON);
      liftDownButton.whileActiveContinuous(m_liftDownCommand, Constants.INTERRUPTIBLE);
    /*}else{
      JoystickButton loadFuelCellsButton = new JoystickButton(buttonsJoystick, Constants.LOAD_FUEL_CELLS_JOYSTICK_BUTTON);
      loadFuelCellsButton.whileActiveOnce(m_loadFuelCellsCommand, Constants.INTERRUPTIBLE);  

      JoystickButton emergencyReverseButton = new JoystickButton(buttonsJoystick, Constants.EMERGENCY_REVERSE_JOYSTICK_BUTTON);
      emergencyReverseButton.whileActiveContinuous(m_emergencyReverseCommand, Constants.INTERRUPTIBLE);

      JoystickButton turnVerticalButton = new JoystickButton(buttonsJoystick, Constants.TURN_VERTICAL_JOYSTICK_BUTTON);
      turnVerticalButton.whileActiveContinuous(m_turnVerticalCommand, Constants.NOT_INTERRUPTIBLE);
    
      JoystickButton winchButton = new JoystickButton(buttonsJoystick, Constants.WINCH_JOYSTICK_BUTTON);
      winchButton.whileActiveContinuous(m_winchCommand, Constants.INTERRUPTIBLE);

      JoystickButton leftButton = new JoystickButton(buttonsJoystick, Constants.LEFT_JOYSTICK_BUTTON);
      leftButton.whileActiveContinuous(m_leftCommand, Constants.INTERRUPTIBLE);

      JoystickButton rightButton = new JoystickButton(buttonsJoystick, Constants.RIGHT_JOYSTICK_BUTTON);
      rightButton.whileActiveContinuous(m_rightCommand, Constants.INTERRUPTIBLE);
    
      JoystickButton fireBallTrigger = new JoystickButton(buttonsJoystick, Constants.KOBE_JOYSTICK_BUTTON);
      fireBallTrigger.whileActiveContinuous(m_shooterCommand, Constants.INTERRUPTIBLE);
      
      JoystickButton aimTrigger = new JoystickButton(buttonsJoystick, Constants.AIM_JOYSTICK_BUTTON);
      aimTrigger.whileActiveContinuous(m_turretCommand, Constants.INTERRUPTIBLE);
    }*/
  }
 
 
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommandGroup;
  }
}

