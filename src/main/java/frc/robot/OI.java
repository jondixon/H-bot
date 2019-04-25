package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.commands.CloseCutter;
import frc.robot.commands.OpenCutter;


public class OI {
  public static int baseJoystickPort = 0;

  public static int LXAxis = 0;
  public static int leftStick = 1; //aka LYAxis
  public static int RXAxis = 2;
  public static int rightStick = 5; //aka RYAxis

  public static int AButton = 0;
  public static int BButton = 1;
  public static int XButton = 2;
  public static int YButton = 3;

  public Joystick base = null; 
  public Button baseAButton = null;
  public Button baseXButton = null;
	
	public OI() {

    try {
      base = new Joystick(baseJoystickPort);

      
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public void setupBaseJoystick() {
    if (base != null) {
      baseXButton.whileHeld(new CloseCutter());
      baseAButton.whileHeld(new OpenCutter());
    }
  }
	
	public Joystick getBaseJoystick() {
		return base;
  }
}