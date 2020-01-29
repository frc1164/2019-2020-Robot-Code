/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import frc.robot.Constants;

public class ChangeGear extends CommandBase {
  private static boolean m_changeGear = true;
  private final Chassis myChassis;
  /**
   * Creates a new ChangeGear.
   */
  public ChangeGear(Chassis newChassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.myChassis = newChassis;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ChangeGear.m_changeGear = !ChangeGear.m_changeGear;
    this.myChassis.changeGear(ChangeGear.m_changeGear);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
