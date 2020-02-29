/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.FuelCell;
import frc.robot.commands.FuelCellMotOut;
import frc.robot.subsystems.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class A_Score extends SequentialCommandGroup {

  /**
   * Creates a new A_Score.
   */
  public A_Score(Chassis m_Chassis, FuelCell m_FuelCell) {
    
    super(
      new A_MoveRaiseFC(m_Chassis, m_FuelCell),
      new FuelCellMotOut(m_FuelCell)
    );
  }
}
