/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj.Timer;

public class A_Drive extends CommandBase {
  private final Chassis m_Chassis;
  private double m_time;
  private double m_speed;
  /**
   * Creates a new A_Drive.
   */
  public A_Drive(double time, double speed, Chassis m_Chassis) {
    this.m_Chassis = m_Chassis;
    m_time = time;
    m_speed = -speed; 
    addRequirements(m_Chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Chassis.leftSpeed(m_speed);
    m_Chassis.rightSpeed(m_speed * 7/8);
    Timer.delay(m_time);
    m_Chassis.brake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
