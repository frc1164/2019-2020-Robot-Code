/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// 1) Flip fuelCell with button 4, 2) Run fuelCEllEE motor according to position of solenoid.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FuelCell;


public class FuelCellSol extends CommandBase {
  private static boolean fuelCellFlipSol = false;
  private final FuelCell m_FuelCell;
  /**
   * Creates a new FuelCellScore.
   */
  public FuelCellSol(FuelCell m_FuelCell) {
    this.m_FuelCell = m_FuelCell;
    addRequirements(m_FuelCell);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    FuelCellSol.fuelCellFlipSol = !FuelCellSol.fuelCellFlipSol;
    this.m_FuelCell.fuelCellFlip(FuelCellSol.fuelCellFlipSol);
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
