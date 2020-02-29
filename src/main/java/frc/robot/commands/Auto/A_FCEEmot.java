/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FuelCell;
import edu.wpi.first.wpilibj.Timer;

public class A_FCEEmot extends CommandBase {
  private final FuelCell m_FuelCell;
  private double m_speed;
  private double m_time;
  /**
   * Creates a new A_FCEEmot.
   */
  public A_FCEEmot(double timeToWait, double speed, FuelCell m_FuelCell) {
    this.m_FuelCell = m_FuelCell;
    m_speed = speed;
    m_time = timeToWait;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_FuelCell.fuelCellSpeed(m_speed);
    Timer.delay(m_time);
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
