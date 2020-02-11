/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import frc.robot.Constants.conPanConstants;

public class ControlPanel extends SubsystemBase {
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatch;
  private final Color kBlueTarget;
  private final Color kGreenTarget;
  private final Color kRedTarget;
  private final Color kYellowTarget;

  /**
   * Creates a new ControlPanel.
   */
  public ControlPanel() {

    
  //Calibrates RGB values colors
  public void calibrateRGB() {
  kBlueTarget = ColorMatch.makeColor(conPanConstants.blue[0], conPanConstants.blue[1], conPanConstants.blue[2]);
  kGreenTarget = ColorMatch.makeColor(conPanConstants.green[0], conPanConstants.green[1], conPanConstants.green[2]);
  kRedTarget = ColorMatch.makeColor(conPanConstants.red[0], conPanConstants.red[1], conPanConstants.red[2]);
  kYellowTarget = ColorMatch.makeColor(conPanConstants.yellow[0], conPanConstants.yellow[1], conPanConstants.yellow[2]);
  }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
