/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class PIDElevator extends PIDSubsystem {
  private WPI_TalonSRX _elevator = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);
  private DigitalInput _resetLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_RESET_LIMIT_SWITCH);
  private int MAX_ELEVATOR_POSITION = 10000; //TODO: Set Max
  private int MIN_ELEVATOR_POSITION = 0; //TODO: Set min

  private Encoder enc = new Encoder(RobotMap.DIO_ENCODER_A, RobotMap.DIO_ENCODER_B, false, Encoder.EncodingType.k4X);
  /**
   * Add your docs here.
   */
  public PIDElevator() {
    // Intert a subsystem name and PID values here
    super("PIDElevator", 1, 0, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    int count = enc.get();

    return count;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    
    _elevator.set(output);
  }
 
  public int getEncoder() {
    return enc.get();
  }

  public void setMotor(double output) {
    _elevator.set(output);
  }

  public boolean getResetLimitSwitch() {
    return _resetLimitSwitch.get(); //TODO: May need to be inverted
  }

  public void resetElevatorEncoder() {
    enc.reset();
  }
}
