/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;
import frc.robot.Constants.conPanConstants;
import frc.robot.RobotContainer;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class SetColor extends CommandBase {
  public ControlPanel m_controlPanel;
  public ColorMatch m_colorMatcher;

  public SetColor(ControlPanel m_controlPanel) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_controlPanel = m_controlPanel;
    addRequirements(m_controlPanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Code that sets the LEDs
    m_controlPanel.getColor();
    m_controlPanel.matchColor();
    m_controlPanel.printColor();

    if (ControlPanel.colorString.compareTo(conPanConstants.FMScolor) != 0) {
      m_controlPanel.conPanSpeed(conPanConstants.conPanSpeed);
      }
    else {
      m_controlPanel.conPanSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_controlPanel.conPanSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
