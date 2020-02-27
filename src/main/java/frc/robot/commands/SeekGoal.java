/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Chassis;
import frc.robot.RobotContainer;

public class SeekGoal extends CommandBase {
  private final Chassis m_Chassis;
  private ShuffleboardTab tab = Shuffleboard.getTab("PID Settings");
  private NetworkTableEntry kP = tab.add("Line P", 0.017).getEntry();
  private NetworkTableEntry kI = tab.add("Line I", 0.006).getEntry();
  private NetworkTableEntry kD = tab.add("Line D", 0.003).getEntry();
  double P, I, D; 
  public static double PIDout = 0.0;
  boolean buttonReleased;
  PIDController testPID = new PIDController(P, I, D);



  /**
   * Creates a new SeekBall.
   */
  public SeekGoal(Chassis m_Chassis) {
    this.m_Chassis = m_Chassis;
    addRequirements(m_Chassis);
  }

  // Called when the command is initially scheduled.-
  @Override
  public void initialize() {
  P = kP.getDouble(0.0);
  I = kI.getDouble(0.0);
  D = kD.getDouble(0.0);
  testPID.setPID(P, I, D);
  testPID.setSetpoint(0.0);
  testPID.enableContinuousInput(-29.8, 29.8);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
    buttonReleased = false;
    if (Vision.get_lltarget()) {
    PIDout = testPID.calculate(Vision.get_llx());
    //m_Chassis.rightSpeed (-PIDout);
    //m_Chassis.leftSpeed (PIDout);
    }
    SmartDashboard.putNumber("test Vision", PIDout);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    PIDout = 0.0;
    buttonReleased = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return buttonReleased;
  }
}
