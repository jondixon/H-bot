package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem {

  //create talon objects
  private WPI_TalonSRX _rightFront = new WPI_TalonSRX(RobotMap.right_front_motor_port);
  private WPI_TalonSRX _rightRear = new WPI_TalonSRX(RobotMap.right_back_motor_port);
  private WPI_TalonSRX _leftFront = new WPI_TalonSRX(RobotMap.left_front_motor_port);
  private WPI_TalonSRX _leftRear = new WPI_TalonSRX(RobotMap.left_back_motor_port);

  //initialize the differential drive
  private DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rightFront);

  private double rightGoverned = 0.0;
  private double leftGoverned = 0.0;
  private double motor_gain = 1; //TODO: Set Motor Gain

  public DriveTrain() {
    _rightFront.setInverted(true); //TODO: Confirm Inversion
    _leftFront.setInverted(true); //TODO: Confirm Inversion
    _rightRear.setInverted(true); //TODO: Confirm Inversion
    _leftRear.setInverted(false); //TODO: Confirm Inversion
    _rightRear.set(ControlMode.Follower, RobotMap.right_front_motor_port);
    _leftRear.set(ControlMode.Follower, RobotMap.left_front_motor_port);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  public void drivetrainStop() {
    _rightFront.set(0);
    _leftFront.set(0);
  }
  
  public void tankDriveByJoystick(double left, double right) {
    if (left < 0)
      leftGoverned = (left * left) * -motor_gain;
    else 
      leftGoverned = (left * left) * motor_gain;

    if (right < 0)
      rightGoverned = (right * right) * -motor_gain;
    else 
      rightGoverned = (right * right) * motor_gain;

    _diffDrive.tankDrive(leftGoverned, rightGoverned);
	}
}