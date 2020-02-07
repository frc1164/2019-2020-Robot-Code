/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// 1) Flip fuelCellEE with button 4, 2) Run fuelCEllEE motor according to position of solenoid.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FuelCellEE;


public class FuelCellEESol extends CommandBase {
  private static boolean fuelCellEEFlipSol = true;
  private final FuelCellEE m_FuelCellEE;
  /**
   * Creates a new FuelCellEEScore.
   */
  public FuelCellEESol(FuelCellEE m_FuelCellEE) {
    this.m_FuelCellEE = m_FuelCellEE;
    addRequirements(m_FuelCellEE);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    FuelCellEESol.fuelCellEEFlipSol = !FuelCellEESol.fuelCellEEFlipSol;
    this.m_FuelCellEE.fuelCellEEFlip(FuelCellEESol.fuelCellEEFlipSol);
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
