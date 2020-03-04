/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FuelCell;
import frc.robot.Constants.fuelCellConstants;

public class FuelCellMotOut extends CommandBase {
  private final FuelCell m_FuelCell;
  private boolean buttonReleased;
  /**
   * Creates a new FuelCellMot.
   */
  public FuelCellMotOut(FuelCell m_FuelCell) {
    this.m_FuelCell = m_FuelCell;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    buttonReleased = false;
    double setFuelCellMotSpeed = fuelCellConstants.fuelCellMotSpeed;
    m_FuelCell.fuelCellSpeed(-setFuelCellMotSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_FuelCell.fuelCellSpeed(0.0);
    buttonReleased = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return buttonReleased;
  }
}
