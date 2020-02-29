/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.fuelCellConstants;
import frc.robot.Constants.driveConstants;
import edu.wpi.first.wpilibj.Solenoid;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FuelCell extends SubsystemBase {
  private final TalonSRX fuelCellMot = new TalonSRX(fuelCellConstants.fuelCellMot);
  private final Solenoid fuelCellSolenoidExtend;
  private final Solenoid fuelCellSolenoidRetract;
  /**
   * Creates a new FuelCell.
   */
  public FuelCell() {
    fuelCellSolenoidExtend = new Solenoid(driveConstants.PCM, fuelCellConstants.fuelCellSolenoidExtend);
    fuelCellSolenoidRetract = new Solenoid(driveConstants.PCM, fuelCellConstants.fuelCellSolenoidRetract);
  }

  public void fuelCellSpeed(double fuelCellSpeed) {
    fuelCellMot.set(ControlMode.PercentOutput, fuelCellSpeed);
  }

  public void fuelCellRaise(boolean raise) {
    fuelCellSolenoidRetract.set(!raise);
    fuelCellSolenoidExtend.set(raise);
  }

  public void fuelCellFlip(boolean isExtended) {
    fuelCellSolenoidRetract.set(!isExtended);
    fuelCellSolenoidExtend.set(isExtended);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
