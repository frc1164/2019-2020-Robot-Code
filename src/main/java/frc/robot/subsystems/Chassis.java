/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.driveConstants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Chassis extends SubsystemBase {
  private final VictorSPX leftMotorRear = new VictorSPX(driveConstants.leftMotorRear);
  private final VictorSPX rightMotorRear = new VictorSPX(driveConstants.rightMotorRear);
  private final VictorSPX leftMotorFront = new VictorSPX(driveConstants.leftMotorFront);
  private final VictorSPX rightMotorFront = new VictorSPX(driveConstants.rightMotorFront);
  private final Solenoid leftLowSol, leftHighSol, rightLowSol, rightHighSol;

  /**
   * Creates a new Chassis.
   */
  public Chassis() {
    leftLowSol = new Solenoid(Constants.driveConstants.PCM,
                              Constants.driveConstants.leftLowSol);                      
    leftHighSol = new Solenoid(Constants.driveConstants.PCM,
                               Constants.driveConstants.leftHighSol);
    rightLowSol = new Solenoid(Constants.driveConstants.PCM,
                               Constants.driveConstants.rightLowSol);
    rightHighSol = new Solenoid(Constants.driveConstants.PCM,
                                Constants.driveConstants.rightHighSol);

    
    leftMotorRear.setInverted(driveConstants.invertLeftMotorRear);
    rightMotorRear.setInverted(driveConstants.invertRightMotorRear);
    leftMotorFront.setInverted(driveConstants.invertLeftMotorFront);
    rightMotorFront.setInverted(driveConstants.invertRightMotorFront);

  }
//not sure if this needs to be in Periodic
  public void leftSpeed(double speed) {
    leftMotorFront.set(ControlMode.PercentOutput, speed);
    leftMotorRear.set(ControlMode.PercentOutput, speed);
  }

  public void rightSpeed(double speed) {
    rightMotorFront.set(ControlMode.PercentOutput, speed);
    rightMotorRear.set(ControlMode.PercentOutput, speed);
  }

  public void changeGear(boolean isHigh){
    leftLowSol.set(!isHigh);
    rightLowSol.set(!isHigh);
    leftHighSol.set(isHigh);
    rightHighSol.set(isHigh);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
