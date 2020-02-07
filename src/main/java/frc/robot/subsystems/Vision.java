/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.LinkedList;

import javax.swing.text.TableView.TableCell;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision extends SubsystemBase {
  public static NetworkTable table;
  public static NetworkTableEntry tx, ty, ta;
  
  LinkedList<Double> LLvalues = new LinkedList<Double>();

  /**
   * Creates a new Vision.
   */
  public Vision() {
    //Sets up Lime Light Network Tables
  table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
  }
  
  //Method for LimeLight x_axis
  private double get_llx() {
    double LLx = tx.getDouble(0.0);
    return LLx;
  }

  //Method for LimeLight y_axis
  private double get_lly() {
    double LLy = ty.getDouble(0.0);
    return LLy;
  }

  //Method for LimeLight area
  private double get_llarea() {
    double LLarea = ta.getDouble(0.0);
    return LLarea;
  }
  
  //Displays LimeLight Value
  public void printLLvalues() {
    SmartDashboard.putNumber("LimelightX", get_llx());
    SmartDashboard.putNumber("LimelightY", get_lly());
    SmartDashboard.putNumber("LimelightArea", get_llarea() );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
