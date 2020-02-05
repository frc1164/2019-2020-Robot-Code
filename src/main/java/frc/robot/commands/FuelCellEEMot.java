/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FuelCellEE;
import frc.robot.RobotContainer;
import frc.robot.Constants.xBoxConstants;

public class FuelCellEEMot extends CommandBase {
  private final FuelCellEE m_FuelCellEEMot;
  /**
   * Creates a new FuelCellEEMot.
   */
  public FuelCellEEMot(FuelCellEE myFuelCellEE) {
    m_FuelCellEEMot = myFuelCellEE;
    addRequirements(m_FuelCellEEMot);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double runFuelCellEEMot = RobotContainer.m_OperatorController.getRawAxis(xBoxConstants.ry_Axis);
    m_FuelCellEEMot.fuelCellEESpeed(runFuelCellEEMot);
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
