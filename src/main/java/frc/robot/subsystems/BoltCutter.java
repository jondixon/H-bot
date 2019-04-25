/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class BoltCutter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DigitalOutput openRelay = null;
  public DigitalOutput closeRelay = null;
  
  public BoltCutter () {

    openRelay = new DigitalOutput(RobotMap.DIO_RELAY_OPEN);
    closeRelay = new DigitalOutput(RobotMap.DIO_RELAY_CLOSE);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void CloseCutter() {

      openRelay.set(true);
      closeRelay.set(false);
  }

  public void OpenCutter() {

    openRelay.set(false);
    closeRelay.set(true);
  }

  public void StopCutter() {

    openRelay.set(true);
    closeRelay.set(true);
  }
}
