/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.Arduino;

public class ByteCodes extends CommandBase {
  Arduino m_Arduino;
  boolean ballState = false;
  boolean targetState = false;
  String fmsColor = null;
  String gameData = DriverStation.getInstance().getGameSpecificMessage();
  /**
   * Creates a new ByteCodes.
   */
  public ByteCodes(Arduino m_Arduino) {
    this.m_Arduino = m_Arduino;
    addRequirements(m_Arduino);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(lltv != targetState){ //needs values from a limelight method(Nick)
      //call bytecode num
    }
    if(pixytv != ballState){ //needs values from a pixy method(Jessey/Riva)
      //call bytecode num
    }
    if(gameData != fmsColor){
      if(gameData.length() > 0){
        switch (gameData.charAt(0))
       {
          case 'B' :
            //Blue case code
            break;
           case 'G' :
            //Green case code
            break;
          case 'R' :
            //Red case code
            break;
          case 'Y' :
            //Yellow case code
            break;
          default :
            //This is corrupt data
            break;
      }
    } 
      else {
        //Code for no data received yet
      }
    }
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
