package frc.robot;

public class RobotMap {
	// CAN
  public static int right_front_motor_port = 2;
	public static int right_back_motor_port = 4;
	public static int left_front_motor_port = 1;
	public static int left_back_motor_port = 3;
	public static int ELEVATOR_TALON = 5;
	public static int CAN_ID_ARM = 6;

	// DIO
	public static int ELEVATOR_RESET_LIMIT_SWITCH = 3;
	public static int DIO_ARM_LIMIT_HIGH = 5;
	public static int DIO_ARM_LIMIT_LOW = 4;
	public static int DIO_RELAY_CLOSE = 0;
	public static int DIO_RELAY_OPEN = 1;
	public static int DIO_ENCODER_A = 8;
	public static int DIO_ENCODER_B = 9;

	// PWM
	public static int PWM_GRINDER = 9;
}