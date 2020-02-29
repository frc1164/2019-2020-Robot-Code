/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arduino;

public class ByteCodes extends CommandBase {
  Arduino m_Arduino;
  static boolean ballState = false;
  static boolean targetState = false;
  static String fmsColor = null;
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
    //if(lltv != targetState){ //needs values from a limelight method(Nick)
      //call bytecode num
   // }
    //if(pixytv != ballState){ //needs values from a pixy method(Jessey/Riva)
      //call bytecode num
   // }
    if(!(Arduino.gameData().equalsIgnoreCase(fmsColor)))  
        if(Arduino.gameData().length() > 0){
        switch (Arduino.gameData().charAt(0))
       {
          case 'B' :
            m_Arduino.sendBlue();
            break;
           case 'G' :
            m_Arduino.sendGreen();
            break;
           case 'R' :
            m_Arduino.sendRed();
            break;
           case 'Y' :
            m_Arduino.sendYellow();
            break;
           default :
            //This is corrupt data
            break;
      }
       m_Arduino.readArduino();
    }
    fmsColor = Arduino.gameData();
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
