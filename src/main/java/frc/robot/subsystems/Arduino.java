/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SerialPort;

public class Arduino extends SubsystemBase {
  /**
   * Creates a new Arduino.
   */

   public SerialPort arduino;

  public Arduino() {
    try{
      arduino = new SerialPort(9600, SerialPort.Port.kUSB);
      System.out.println("USB1 connected");
    }
    catch(Exception e){
      System.out.println("USB1 did not connect");

      try{
        arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
        System.out.println("USB2 connected");
      }
      catch(Exception e1){
        System.out.println("USB2 did not connect");
        
        try{
          arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
          System.out.println("USB3 connected");
        }
        catch(Exception e2){
          System.out.println("USB3 did not connect");
        }
      }
    }
  }

  public void sendRed() {
    arduino.write(new byte[] {0x12}, 1);
    System.out.println("Sent Red");
  }

  public void sendGreen() {
    arduino.write(new byte[] {0x13}, 1);
    System.out.println("Sent Green");
  }

  public void sendBlue() {
    arduino.write(new byte[] {0x14}, 1);
    System.out.println("Sent Blue");
  }

  public void sendYellow() {
    arduino.write(new byte[] {0x15}, 1);
    System.out.println("Sent Yellow");
  }

  public void readArduino() {
    if(arduino.getBytesReceived() > 0) {
      System.out.print(arduino.readString());
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
