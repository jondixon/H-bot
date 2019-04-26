package frc.robot;

// Class for defining the ports electronics are plugged into on the robot
public class RobotMap {
  // Motors
  public static int right_front_motor_port = 2;
	public static int right_back_motor_port = 4;
	public static int left_front_motor_port = 1;
	public static int left_back_motor_port = 3;

	public static int DIO_RELAY_OPEN = 1;
	public static int DIO_RELAY_CLOSE = 0;


	public static int ELEVATOR_TALON = 5;
	public static int ELEVATOR_RESET_LIMIT_SWITCH = 99; //TODO: Confirm Elevator Limit Value

	//Shoulder
	public static int shoulder_motor_port = 6;
	public static int DIO_ARM_LIMIT_LOW = 2;
	public static int DIO_ARM_LIMIT_HIGH = 3;
}