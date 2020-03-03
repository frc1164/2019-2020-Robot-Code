/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Vision;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class A_SeekGoalUntil extends ParallelDeadlineGroup {
  /**
   * Creates a new A_SeekGoalUntil.
   */
  public A_SeekGoalUntil(Chassis m_Chassis, Vision m_Vision) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
      new A_CenterGoalDrive(0.2, m_Chassis, m_Vision),
      new A_Delay(4)
    );
  }
}
