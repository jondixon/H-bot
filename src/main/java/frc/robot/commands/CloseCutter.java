/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.OI;




public class CloseCutter extends Command {

  private Joystick js = null;

  public CloseCutter() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    System.out.print("Before Requires\n");

    requires(Robot.m_bolt_cutter);
    System.out.print("After Requires\n");

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.print("Initialize\n");

    js = Robot.m_oi.getBaseJoystick();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_bolt_cutter.CloseCutter();
    System.out.print("closing\n");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if( !js.getRawButton(1)) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_bolt_cutter.StopCutter();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_bolt_cutter.StopCutter();
  }
}
