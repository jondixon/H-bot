/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorDrive extends Command {
  private Joystick js = Robot.m_oi.getBaseJoystick();
  private boolean dpadUp = js.getPOV() == 0;
  private boolean dpadDown = js.getPOV() == 180;
  private double targetPosition = 0.0;
  private double increment = 10;

  public ElevatorDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_elevator.enable();
    Robot.m_elevator.setSetpoint(Robot.m_elevator.getEncoder());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println(js.getPOV());
    if (dpadUp) 
      targetPosition = targetPosition + increment;
    else if (dpadDown)
      targetPosition = targetPosition - increment;
    

    Robot.m_elevator.setSetpoint(targetPosition);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_elevator.setMotor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_elevator.setMotor(0);
  }
}
