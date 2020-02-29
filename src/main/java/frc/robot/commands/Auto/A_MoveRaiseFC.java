/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.FuelCell;
import frc.robot.subsystems.Chassis;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class A_MoveRaiseFC extends ParallelCommandGroup {
  /**
   * Creates a new A_Score.
   */
  public A_MoveRaiseFC (Chassis m_Chassis, FuelCell m_FuelCell) {
    addCommands(
      new A_Drive(2.0, .2, m_Chassis),
      new A_FCEEsol(true, m_FuelCell)
    );
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
