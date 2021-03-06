package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PIDElevator;
import frc.robot.subsystems.BoltCutter;
import frc.robot.subsystems.AngleGrinder;

public class Robot extends TimedRobot {
 // public static DriveTrain m_drive_train = new DriveTrain();
  public static BoltCutter m_bolt_cutter = new BoltCutter();
  public static PIDElevator m_elevator = new PIDElevator();
  public static AngleGrinder m_grinder = new AngleGrinder();

  public static OI m_oi;
  Command m_autonomousCommand;

  @Override
  public void robotInit() {
    m_oi = new OI();
    System.out.println("Done robotInit");
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  // @Override
  // public void testPeriodic() {
  // }
}