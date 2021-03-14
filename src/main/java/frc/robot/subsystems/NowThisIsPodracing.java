/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.subsystems;
 
//import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
 
// SIMULATION RELATED IMPORTS
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
// END OF SIMULATION IMPORTS

public class NowThisIsPodracing extends SubsystemBase {

  private static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(Constants.FRONT_LEFT_MOTOR_PORT);
  private static WPI_TalonFX rearLeftMotor = new WPI_TalonFX(Constants.REAR_LEFT_MOTOR_PORT);
  private static WPI_TalonFX frontRightMotor = new WPI_TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT);
  private static WPI_TalonFX rearRightMotor = new WPI_TalonFX(Constants.REAR_RIGHT_MOTOR_PORT);
 
  // SIMULATION RELATED FIELDS
   public static final double TRACK_WIDTH_METERS = 0.5; 
   private static final double SIM_ROBOT_METERS_PER_S = 3;
   private Field2d field2d = new Field2d();
   private Double simLastOdometryUpdate;
   private double simLeftMeters = 0, simRightMeters = 0;
   private double simHeading = 0;
   private Pose2d simPose;
   private DifferentialDriveWheelSpeeds simWheelSpeeds = new DifferentialDriveWheelSpeeds(0, 0);
   private DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(simHeading));
   public static final DifferentialDriveKinematics KINEMATICS = new DifferentialDriveKinematics(TRACK_WIDTH_METERS);
   // END OF SIMULATION RELATED FIELDS
   
  DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

  public NowThisIsPodracing() {
    /*frontLeftMotor.configFactoryDefault();
    rearLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();
    rearRightMotor.configFactoryDefault();

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    rearLeftMotor.follow(frontLeftMotor);
    rearRightMotor.follow(frontRightMotor);

    rearLeftMotor.setInverted(InvertType.FollowMaster);
    rearRightMotor.setInverted(InvertType.FollowMaster);

    drive.setRightSideInverted(true);*/
    SmartDashboard.putData("Field", field2d);
  }
 
  public void m_arcadeDrive(double forward, double rotation, double throttle) {
    //drive.arcadeDrive(-forward*throttle, rotation*throttle*Constants.TURN_ADJUST);

    frontLeftMotor.setNeutralMode(NeutralMode.Coast);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Coast);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    double leftPower = skim(((forward * throttle) - (rotation * throttle * Constants.TURN_ADJUST)));
    double rightPower = skim(((forward * throttle) + (rotation * throttle * Constants.TURN_ADJUST)));

    SmartDashboard.putNumber("leftPower", leftPower);
    SmartDashboard.putNumber("rightPower", rightPower);
    
    frontLeftMotor.set(leftPower);
    rearLeftMotor.set(leftPower);
    frontRightMotor.set(-rightPower);
    rearRightMotor.set(-rightPower);

    // added following three lines for SIMULATION
    if (Robot.isSimulation()) {
      simWheelSpeeds = DifferentialDriveSim.arcadeDriveMeters(forward, rotation, true, SIM_ROBOT_METERS_PER_S);
    }
  }

  public double skim(double num){
    if (num > 1.0) {
      return 1.0;
    } else if (num < -1.0) {
      return -1.0;
    }
    else{
      return num;
    } 
  }
 
// START OF SIMULATION RELATED METHOD - using periodic method with subsystem (also can be used with commands) 

public double getHeading() {
  return simHeading;
}

public double getLeftMeters() {
  return simLeftMeters;
}

public double getRightMeters() {
  return simRightMeters;
}

public double getAvgMeters() {
  return (simLeftMeters+simRightMeters)/2;
}


@Override
  public void periodic() {
    if (Robot.isReal()) {
    } else {
      if (simLastOdometryUpdate == null) {
        simLastOdometryUpdate = Timer.getFPGATimestamp();
        return;
      }
      if (!drive.isAlive()) {
        //System.out.println("Watchdog not fed, no sim odometry update");
        return;
      }
      double dt = Timer.getFPGATimestamp() - simLastOdometryUpdate;
      simLeftMeters += simWheelSpeeds.leftMetersPerSecond * dt;
      simRightMeters += simWheelSpeeds.rightMetersPerSecond * dt;
      simHeading += Math.toDegrees(KINEMATICS.toChassisSpeeds(simWheelSpeeds).omegaRadiansPerSecond) * 0.25 * dt;
      if (simHeading > 180) {
        simHeading -= 360;
      } else if (simHeading < -180) {
        simHeading += 360;
      }
      odometry.update(Rotation2d.fromDegrees(simHeading), simLeftMeters, simRightMeters);
      double odometryX = odometry.getPoseMeters().getTranslation().getX();
      double odometryY = odometry.getPoseMeters().getTranslation().getY();
      simPose = new Pose2d(odometryX + 0, odometryY + 0, Rotation2d.fromDegrees(simHeading));
      simLastOdometryUpdate = Timer.getFPGATimestamp();

      field2d.setRobotPose(simPose);
    }
  }
}

