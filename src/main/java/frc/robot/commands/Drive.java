/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Chassis;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class Drive extends CommandBase {
  private final Chassis m_Drive;
  /**
   * Creates a new Drive.
   */
  public Drive(Chassis m_Chassis) {
    m_Drive = m_Chassis;
    addRequirements(m_Drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.leftSpeed(RobotContainer.m_DriverStick.getRawAxis(Constants.joyStickConstants.y_Axis));
    m_Drive.rightSpeed(RobotContainer.m_DriverStick.getRawAxis(Constants.joyStickConstants.y_Axis));
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
