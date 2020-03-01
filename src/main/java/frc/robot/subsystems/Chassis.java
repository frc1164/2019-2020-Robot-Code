/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants.driveConstants;

public class Chassis extends SubsystemBase {
  private final VictorSPX leftMotorRear = new VictorSPX(driveConstants.leftMotorRear);
  private final VictorSPX rightMotorRear = new VictorSPX(driveConstants.rightMotorRear);
  private final VictorSPX leftMotorFront = new VictorSPX(driveConstants.leftMotorFront);
  private final VictorSPX rightMotorFront = new VictorSPX(driveConstants.rightMotorFront);
  private final Solenoid leftLowSol, leftHighSol, rightLowSol, rightHighSol;
  private static Ultrasonic ultrasonic;
  public static double currentDistance;

  /**
   * Creates a new Chassis.
   */
  public Chassis() {
    leftLowSol = new Solenoid(driveConstants.PCM, driveConstants.leftLowSol);                      
    leftHighSol = new Solenoid(driveConstants.PCM, driveConstants.leftHighSol);
    rightLowSol = new Solenoid(driveConstants.PCM, driveConstants.rightLowSol);
    rightHighSol = new Solenoid(driveConstants.PCM, driveConstants.rightHighSol);
    ultrasonic = new Ultrasonic(driveConstants.DIO7, driveConstants.DIO6);
  }

//not sure if this needs to be in Periodic
  public void leftSpeed(double speed) {
    leftMotorRear.setInverted(driveConstants.invertLeftMotorRear);
    leftMotorFront.setInverted(driveConstants.invertLeftMotorFront);
    leftMotorFront.set(ControlMode.PercentOutput, speed);
    leftMotorRear.set(ControlMode.PercentOutput, speed);
  }

  public void rightSpeed(double speed) {
    rightMotorRear.setInverted(driveConstants.invertRightMotorRear);
    rightMotorFront.setInverted(driveConstants.invertRightMotorFront);
    rightMotorFront.set(ControlMode.PercentOutput, speed);
    rightMotorRear.set(ControlMode.PercentOutput, speed);
  }

  public void changeGear(boolean isHigh) {
    leftLowSol.set(!isHigh);
    rightLowSol.set(!isHigh);
    leftHighSol.set(isHigh);
    rightHighSol.set(isHigh);
  }

  public void currentDistance() {
    ultrasonic.setAutomaticMode(true);
    currentDistance = ultrasonic.getRangeInches();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
