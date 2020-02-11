/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Chassis;

public class SeekGoal extends CommandBase {
  private final Chassis m_Chassis;
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
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Vision.get_lltarget()) {
      double Speed_R;
      double Speed_L;

      if (Vision.get_llx() > 8) {
        Speed_L = -(0.20 + (Math.abs(Vision.get_llx()) * 0.02));
        Speed_R = (0.20 + (Math.abs(Vision.get_llx()) * 0.02));

        m_Chassis.leftSpeed(Speed_L);
        m_Chassis.rightSpeed(Speed_R);
      }

      if (Vision.get_llx() < 8) {
        Speed_L = (0.20 + (Math.abs(Vision.get_llx()) * 0.02));
        Speed_R = -(0.20 + (Math.abs(Vision.get_llx()) * 0.02));

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
