/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pixy;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class bigBlock extends CommandBase {
  private final Pixy m_Pixy;
  private Block largestBlock = null;
  /**
   * Creates a new bigBlock.
   */
  public bigBlock(Pixy m_Pixy) {
    this.m_Pixy = m_Pixy;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override

  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Block b = m_Pixy.largestBlock();
    if (b == null){
      System.out.println("No Block");
      SmartDashboard.putString("Block info", "No Ball");
    }
    else{
      System.out.println("Block seen");
      SmartDashboard.putString("Block info", "Ball Seen");
      SmartDashboard.putNumber("Block width", b.getWidth());
      int offSet = m_Pixy.getXAxis(b);
      SmartDashboard.putNumber("x offset", offSet);
      System.out.println(offSet);
    }

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
