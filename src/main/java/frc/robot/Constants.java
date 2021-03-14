/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot;
 
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int DRIVE_JOYSTICK_PORT = 0;
    public static int BUTTONS_CONTROLLER_PORT = 1;
    public static int DRIVE_CONTROLLER_PORT = 2;
    public static int BUTTONS_JOYSTICK_PORT = 3;

    public static int DROP_INTAKE_JOYSTICK_BUTTON = 1;
    public static int DROP_INTAKE_CONTROLLER_BUTTON = 6;
    public static int INTAKE_OUT_JOYSTICK_BUTTON = 2;
    public static int INTAKE_OUT_CONTROLLER_BUTTON = 5;

    public static int WINCH_JOYSTICK_BUTTON = 4;
    public static int WINCH_CONTROLLER_BUTTON = 3;
    public static int LEFT_JOYSTICK_BUTTON = 8;
    public static int LEFT_CONTROLLER_BUTTON = 7;
    public static int RIGHT_JOYSTICK_BUTTON = 9;
    public static int RIGHT_CONTROLLER_BUTTON = 8;

    public static int FRONT_LEFT_MOTOR_PORT = 3;
    public static int REAR_LEFT_MOTOR_PORT = 2;
    public static int FRONT_RIGHT_MOTOR_PORT = 0;
    public static int REAR_RIGHT_MOTOR_PORT = 1;

    public static int RAISE_INTAKE_MOTOR_PORT = 5;
    public static double RAISE_INTAKE_SPEED = -0.5;

    public static int INTAKE_WHEEL_MOTOR_PORT = 14;
    public static double INTAKE_WHEEL_MOTOR_SPEED = -0.5;

    public static int INTAKE_HORIZONTAL_MOTOR_PORT = 11;
    public static double INTAKE_HORIZONTAL_MOTOR_SPEED = -0.8;
    public static double INTAKE_HORIZONTAL_MOTOR_REVERSE_SPEED = 1.0;

    public static int INTAKE_VERTICAL_MOTOR_PORT = 12;
    public static double INTAKE_VERTICAL_MOTOR_SPEED = 1.0;
    public static double INTAKE_VERTICAL_MOTOR_REVERSE_SPEED = -0.4;

    public static int IR_SENSOR_1_PORT = 0;
    public static int IR_SENSOR_2_PORT = 4;
    public static int IR_SENSOR_3_PORT = 9;
    public static int IR_SENSOR_4_PORT = 2;
    
    public static int LOAD_FUEL_CELLS_JOYSTICK_BUTTON = 1;
    public static int LOAD_FUEL_CELLS_CONTROLLER_BUTTON = 6;
    public static int EMERGENCY_REVERSE_JOYSTICK_BUTTON = 6;
    public static int EMERGENCY_REVERSE_CONTROLLER_BUTTON = 5;

    public static int SHOOTER_SERVO_MOTOR_PORT = 2;
    public static int SHOOTER_DRUM_MOTOR_PORT = 1;

    public static double WINCH_SPEED = 0.75;
    public static int WINCH = 4;
    public static int LIFT = 0;

    public static int ADJUSTMENT_MOTOR = 13;
    public static double ADJUSTMENT_SPEED = 1.0;

    public static boolean INTERRUPTIBLE = true;
    public static boolean NOT_INTERRUPTIBLE = false;

    public static double TIME_FOR_DROPPING_INTAKE = 0.19;
    public static double TIME_FOR_RAISING_INTAKE = 0.27;

    public static int LEFT_SHOOTER_DRUM_MOTOR = 6;
    public static int RIGHT_SHOOTER_DRUM_MOTOR = 7;
    public static double SHOOTER_HIGH_GOAL_SPEED = -1.0;
    public static double SHOOTER_LOW_GOAL_SPEED = 1.0;

    public static int TURN_TURRET_MOTOR_VERT_PORT = 2;
    public static int TURN_TURRET_MOTOR_HORIZONTAL_PORT = 10;

    public static int LEFT_SHOOTER_MOTOR_PORT = 6;
    public static int RIGHT_SHOOTER_MOTOR_PORT = 7;
    public static double TURRET_FIRE_SPEED = -1.0;

    public static int AIM_JOYSTICK_BUTTON = 3;
    public static int AIM_CONTROLLER_BUTTON = 2;
    public static int KOBE_JOYSTICK_BUTTON = 2;
    public static int KOBE_CONTROLLER_BUTTON = 1;

    public static int TURN_VERTICAL_JOYSTICK_BUTTON = 5;
    public static int TURN_VERTICAL_CONTROLLER_BUTTON = 4;

    public static double KP = -0.06;
    public static double MIN_COMMAND = 0.05;

    public static double LIFT_UP_SPEED = 1.0;
    public static double LIFT_DOWN_SPEED = -0.5;

    public static int LIFT_UP_CONTROLLER_BUTTON = 9;
    public static int LIFT_DOWN_CONTROLLER_BUTTON = 10;

    public static double TURN_ADJUST = 0.4;

    public static int PID_LOOP_IDX = 0;
    public static int TIMEOUT_MS = 5;

    public static boolean PHASE_SENSOR = true;
    public static boolean INVERTED = true;

    public static int AUTO_DRIVE_FORWARD_POINT = 22016 * 4;
    public static int kERROR = 2000;

    public static Gains kGains = new Gains(2.3, 0.00002, 0.6, 0.0,  0,  0.3);

    public static double AIM_TOLERANCE = 0.06;

    public static double TIME_TO_INITIALIZE_SHOOTER = 3.000;
    public static double AIM_DELAY = 2.000;
    public static double DELAY_BEFORE_LOADING_FUEL_CELLS = 1.500;
    public static double TIME_TO_LOAD_FIRST_THREE_FUEL_CELLS = 0.500;
    public static double TIME_TO_LOAD_LAST_TWO_FUEL_CELLS = 2.000;
    public static double DELAY_AFTER_PICKING_UP_FUEL_CELLS = 1.000;

    public static int LEFT_AUTO_TURN_LEFT_DISTANCE = -2048 * 21 / 10;
    public static int LEFT_AUTO_TURN_RIGHT_DISTANCE = 2048 * 21 / 10;
    public static int LEFT_AUTO_FORWARDS_BASE_LINE_DISTANCE = 2048 * 44;
    public static int LEFT_AUTO_FORWARDS_FUEL_CELLS_DISTANCE = 2048 * 52;
    public static int LEFT_AUTO_BACKWARDS_FUEL_CELLS_DISTANCE = -2048 * 44;
    public static int LEFT_AUTO_BACKWARDS_BASE_LINE_DISTANCE = -2048 * 52;

    public static double AUTO_DRIVE_SPEED = 0.5;

    /*
    Drive is 0-3
    Winch is 4
    Raise Intake is 5
    Two Shooter drum Motors are 6 and 7
    Shooter Horizontal Motor is 10
    horizontal funnel is 11
    vertical funnel is 12
    Intake wheels is 14
    lift is 15
    */
}
 
 

