/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import frc.robot.Constants;
import frc.robot.Constants.conPanConstants;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ControlPanel extends SubsystemBase {
  private final TalonSRX talon = new TalonSRX(conPanConstants.talon);

  private final Color kBlueTarget;
  private final Color kGreenTarget;
  private final Color kRedTarget;
  private final Color kYellowTarget;

  public final ColorSensorV3 m_colorSensor;
  public final ColorMatch m_colorMatcher;

  public static Color detectedColor;
  public static String colorString = "Unknown";
  public static ColorMatchResult match;

  /**
   * Creates a new ControlPanel.
   */
  public ControlPanel() {
    m_colorSensor = new ColorSensorV3(conPanConstants.i2cPort);
    m_colorMatcher = new ColorMatch();
    
  //Calibrates RGB values colors
    kBlueTarget = ColorMatch.makeColor(conPanConstants.blue[0], conPanConstants.blue[1], conPanConstants.blue[2]);
    kGreenTarget = ColorMatch.makeColor(conPanConstants.green[0], conPanConstants.green[1], conPanConstants.green[2]);
    kRedTarget = ColorMatch.makeColor(conPanConstants.red[0], conPanConstants.red[1], conPanConstants.red[2]);
    kYellowTarget = ColorMatch.makeColor(conPanConstants.yellow[0], conPanConstants.yellow[1], conPanConstants.yellow[2]);

  //Assigns colors to matcher
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  
  } 
    
  //Gets color (helpful for LED programming, etc.)
  public void getColor() {
    detectedColor = m_colorSensor.getColor();
  }

  //Sets string to matched color
  public void matchColor() {  
  match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } 
    else if (match.color == kRedTarget) {
      colorString = "Red";
    } 
    else if (match.color == kGreenTarget) {
      colorString = "Green";
    } 
    else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } 
    else {
      colorString = "Unknown";
    }
  }

  //Prints color to SmartDashboard
  public void printColor() {
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putString("Detected Color", colorString);
    }

  //Control panel motor
  public void conPanSpeed(double conPanSpeed) {
    talon.set(ControlMode.PercentOutput, conPanSpeed);
    SmartDashboard.putNumber("conPanTalon", conPanSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
