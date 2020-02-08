/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import frc.robot.Constants.joyStickConstants;
import frc.robot.RobotContainer;


public class Drive extends CommandBase {
  private final Chassis m_Chassis;
  /**
   * Creates a new Drive.
   */
  public Drive(Chassis m_Chassis) {
    this.m_Chassis = m_Chassis;
    addRequirements(m_Chassis);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = RobotContainer.m_DriverStick.getRawAxis(joyStickConstants.y_Axis);
    double turn = RobotContainer.m_DriverStick.getRawAxis(joyStickConstants.x_Axis);
    double scalar = RobotContainer.m_DriverStick.getRawAxis(joyStickConstants.slider);

    turn = (Math.abs(turn) <= 0.25) ? 0 : turn; 
    forward = (Math.abs(forward) <= 0.1) ? 0 : forward; 
    
    double leftMSpeed = ((-scalar*forward) - turn);
    double rightMSpeed = ((-scalar*forward) + turn);

    m_Chassis.leftSpeed(leftMSpeed);
    m_Chassis.rightSpeed(rightMSpeed);
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
