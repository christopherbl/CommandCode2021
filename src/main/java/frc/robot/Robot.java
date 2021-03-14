/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot;
 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Servo;

//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.cameraserver.CameraServer;
 
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
  private Command m_autonomousCommand;
 
  private RobotContainer m_robotContainer;
 
  Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);
  Joystick buttonsJoystick = new Joystick(Constants.BUTTONS_CONTROLLER_PORT);
  Joystick buttonsJoystick2 = new Joystick(Constants.BUTTONS_JOYSTICK_PORT);
  
  //Servo turretServo = new Servo(Constants.SHOOTER_SERVO_MOTOR_PORT);
  WPI_TalonFX leftShooterDrumMotor = new WPI_TalonFX(Constants.LEFT_SHOOTER_DRUM_MOTOR);
  WPI_TalonFX rightShooterDrumMotor = new WPI_TalonFX(Constants.RIGHT_SHOOTER_DRUM_MOTOR);

  // COMMENTED OUT 2 TalonSRX lines below so that simulator can run
  //WPI_TalonSRX raiseIntakeMotor = new WPI_TalonSRX(Constants.RAISE_INTAKE_MOTOR_PORT);

  //WPI_TalonSRX turnTurretMotorHorizontal = new WPI_TalonSRX(Constants.TURN_TURRET_MOTOR_HORIZONTAL_PORT);

  WPI_TalonFX winch = new WPI_TalonFX(Constants.WINCH);
 
  /*SpeedController m_frontLeft = new WPI_TalonFX(Constants.frontLeftMotorPort);
  SpeedController m_rearLeft = new WPI_TalonFX(Constants.rearLeftMotorPort);
  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
 
  SpeedController m_frontRight = new WPI_TalonFX(Constants.frontRightMotorPort);
  SpeedController m_rearRight = new WPI_TalonFX(Constants.rearRightMotorPort);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
 
  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
 
  static double xSpeed;
  static double zRotation;*/
 
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    
  CameraServer.getInstance().startAutomaticCapture();
  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }
 
  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }
 
  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }
 
  @Override
  public void disabledPeriodic() {
  }
 
  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  //@Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
 
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }
 
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }
 
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
 
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    /*xSpeed = driveJoystick.getRawAxis(1);
    zRotation = driveJoystick.getRawAxis(2);
    m_drive.arcadeDrive(xSpeed, zRotation);*/
    //if(driveJoystick.getRawButton(4)) turretServo.set(1.0);
    //else turretServo.set(0.0);
    /*if(buttonsJoystick.getRawButton(4)){
      leftShooterDrumMotor.set(Constants.SHOOTER_HIGH_GOAL_SPEED);
      rightShooterDrumMotor.set(-Constants.SHOOTER_HIGH_GOAL_SPEED);
    }
    else if (buttonsJoystick.getRawButton(9)){
      leftShooterDrumMotor.set(Constants.SHOOTER_LOW_GOAL_SPEED);
      rightShooterDrumMotor.set(Constants.SHOOTER_LOW_GOAL_SPEED);
    }
    else{
      leftShooterDrumMotor.stopMotor();
      rightShooterDrumMotor.stopMotor();
    }

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    //SmartDashboard.putNumber("Lift Intake Motor Current", raiseIntakeMotor.getStatorCurrent());
    SmartDashboard.putNumber("tx", x);
    SmartDashboard.putNumber("ty", y);
    SmartDashboard.putNumber("area", area);

    /*if (buttonsJoystick.getRawButtonPressed(1)){
      turretServo.set(turretServo.get() + 0.025);
    }
    if (buttonsJoystick.getRawButtonPressed(2)){
      turretServo.set(turretServo.get() - 0.0125);
    }*/

    /*if(buttonsJoystick.getRawButton(7)){
      turnTurretMotorHorizontal.set(0.25);
    } else if(buttonsJoystick.getRawButton(8)){
      turnTurretMotorHorizontal.set(-0.25);
    } else{
      //turnTurretMotorHorizontal.stopMotor();
    }*/
    
    /*if(buttonsJoystick.getRawButton(Constants.LOAD_FUEL_CELLS_CONTROLLER_BUTTON)){
      new WPI_TalonFX(Constants.FRONT_LEFT_MOTOR_PORT).set(1.0);
      new WPI_TalonFX(Constants.REAR_LEFT_MOTOR_PORT).set(1.0);
      new WPI_TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT).set(-1.0);
      new WPI_TalonFX(Constants.REAR_RIGHT_MOTOR_PORT).set(-1.0);
    }*/

    if(buttonsJoystick2.getRawButton(1)){
      winch.set(-Constants.WINCH_SPEED);
    }else{
      winch.stopMotor();
    }
  }
 
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }
 
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
 

