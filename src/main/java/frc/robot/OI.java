package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.CloseCutter;
import frc.robot.commands.OpenCutter;


public class OI {
  public static int baseJoystickPort = 0;

  public static int LXAxis = 0;
  public static int leftStick = 1; //aka LYAxis
  public static int RXAxis = 2;
  public static int rightStick = 3; //aka RYAxis

  public static int AButton = 2;
  public static int BButton = 3;
  public static int XButton = 1;
  public static int YButton = 4;

  public Joystick base = null; 
  public Button baseAButton = null;
  public Button baseXButton = null;
	
	public OI() {

    try {
      base = new Joystick(baseJoystickPort);

      baseXButton = new JoystickButton(base, XButton);

      baseAButton = new JoystickButton(base, AButton);


      setupBaseJoystick();

      
    } catch (Exception e) {
      //TODO: handle exception
      System.out.print(e);
    }
  }

  public void setupBaseJoystick() {
    if (base != null) {
      System.out.print("3\n");

      baseXButton.whileHeld(new CloseCutter());
      System.out.print("4\n");
      
      baseAButton.whenPressed(new OpenCutter());
      System.out.print("5\n");

    }
  }
	
	public Joystick getBaseJoystick() {
		return base;
  }
}