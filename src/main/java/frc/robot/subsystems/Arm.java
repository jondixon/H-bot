/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  private TalonSRX _shoulderMotor = new TalonSRX(RobotMap.CAN_ID_ARM);
  private int DEG_2_COUNTS = 0; //TODO: set after cal
  private DigitalInput _highLimitSwitch = new DigitalInput(RobotMap.DIO_ARM_LIMIT_HIGH);
  private DigitalInput _lowLimitSwitch = new DigitalInput(RobotMap.DIO_ARM_LIMIT_LOW);
  private int MAX_ARM_ANGLE = 160 * DEG_2_COUNTS;
  private int MIN_ARM_ANGLE = 15 * DEG_2_COUNTS;

  public Arm() {
    _shoulderMotor.setInverted(true); //TODO: Confirm Inversion
    _shoulderMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    _shoulderMotor.setSensorPhase(true); //TODO: Confirm
    _shoulderMotor.configForwardSoftLimitThreshold(MAX_ARM_ANGLE);
    _shoulderMotor.configReverseSoftLimitThreshold(MIN_ARM_ANGLE);

    _shoulderMotor.configForwardSoftLimitEnable(true);
    _shoulderMotor.configReverseSoftLimitEnable(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setOutput(double output) {
    _shoulderMotor.set(ControlMode.PercentOutput, output);
  }

  public void setPosition(double pos_deg) {
    _shoulderMotor.set(ControlMode.Position,pos_deg * DEG_2_COUNTS);
  }

  public void stop () {
    this.setOutput(0);
  }

  public void setEncoderPosition_deg(double pos_deg) {
    _shoulderMotor.setSelectedSensorPosition((int)(pos_deg * DEG_2_COUNTS));
  }

  public double getEncoderPosition_deg() {
    return _shoulderMotor.getSelectedSensorPosition() * DEG_2_COUNTS;
  }

  public boolean getHighLimit() {
    return _highLimitSwitch.get();
  }

  public boolean getLowLimit() {
    return _lowLimitSwitch.get();
  }
}
