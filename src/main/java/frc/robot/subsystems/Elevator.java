/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorDrive;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  private TalonSRX _elevator = new TalonSRX(RobotMap.ELEVATOR_TALON);
  private DigitalInput _resetLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_RESET_LIMIT_SWITCH);
  private int MAX_ELEVATOR_POSITION = 10000; //TODO: Set Max
  private int MIN_ELEVATOR_POSITION = 0; //TODO: Set min

  public Elevator() {
    _elevator.setInverted(true); //TODO: Confirm Inversion
    _elevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    _elevator.setSensorPhase(true); //TODO: Confirm
    _elevator.configForwardSoftLimitThreshold(MAX_ELEVATOR_POSITION);
    _elevator.configReverseSoftLimitThreshold(MIN_ELEVATOR_POSITION);

    _elevator.configForwardSoftLimitEnable(true);
    _elevator.configReverseSoftLimitEnable(true);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorDrive());
  }

  public void elevatorStop() {
    _elevator.set(ControlMode.PercentOutput, 0);
  }

  public void elevatorGetEncoder() {
    _elevator.getSelectedSensorPosition();
  }

  public void elevatorByPower(double power) {
    _elevator.set(ControlMode.PercentOutput, power);
  }

  public void resetElevatorEncoder() {
    _elevator.setSelectedSensorPosition(0);
  }
  
  public void elevatorToTarget(double target) {
    _elevator.set(ControlMode.Position, target);
  }
  
  public boolean getResetLimitSwitch() {
    return _resetLimitSwitch.get(); //TODO: May need to be inverted
  }
}