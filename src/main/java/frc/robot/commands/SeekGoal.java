/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Chassis;

public class SeekGoal extends CommandBase {
  private final Chassis m_Chassis;
  private ShuffleboardTab tab = Shuffleboard.getTab("PID Settings");
  private NetworkTableEntry kP = tab.add("Line P", 0).getEntry();
  private NetworkTableEntry kI = tab.add("Line I", 0).getEntry();
  private NetworkTableEntry kD = tab.add("Line D", 0).getEntry();
  private NetworkTableEntry goal = tab.add("x Goal", 7500).getEntry();
  double P, I, D, PIDGoal;



  /**
   * Creates a new SeekBall.
   */
  public SeekGoal(Chassis m_Chassis) {
    this.m_Chassis = m_Chassis;
    addRequirements(m_Chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    P = kP.getDouble(0.0);
    I = kI.getDouble(0.0);
    D = kD.getDouble(0.0);
    PIDController testPID = new PIDController(P, I, D);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
    SmartDashboard.putNumber("test P", P);
    if (Vision.get_lltarget()) {
      double Speed_R;
      double Speed_L;

      if (Vision.get_llx() > 8) {
        Speed_L = -((Math.pow(Math.abs(Vision.get_llx()), 3) * 33750));
        Speed_R = ((Math.pow(Math.abs(Vision.get_llx()), 3) * 33750));

        m_Chassis.leftSpeed(Speed_L);
        m_Chassis.rightSpeed(Speed_R);
      }

      if (Vision.get_llx() < 8) {
        Speed_L = (Math.pow(Math.abs(Vision.get_llx()), 3) / 33750);
        Speed_R = -(Math.pow(Math.abs(Vision.get_llx()), 3) / 33750);

        m_Chassis.leftSpeed(Speed_L);
        m_Chassis.rightSpeed(Speed_R);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
