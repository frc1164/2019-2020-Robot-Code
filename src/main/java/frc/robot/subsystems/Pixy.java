/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class Pixy extends SubsystemBase {
  private static Pixy2 pixy;
  /**
   * Creates a new Pixy.
   */
  public Pixy() {
    pixy = Pixy2.createInstance(new SPILink());
    double largestBlockWidth;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pixyLED() {
    pixy.init(); // Initializes the camera and prepares to send/receive data
		pixy.setLamp((byte) 0, (byte) 0); // Turns the LEDs on
		pixy.setLED(200, 30, 255); // Sets the RGB LED to purple
  }

  public Block largestBlock() {
    	// Gets the number of "blocks", identified targets, that match signature 1 on the Pixy2,
		// does not wait for new data if none is available,
		// and limits the number of returned blocks to 25, for a slight increase in efficiency
		int blockCount = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
		System.out.println("Found " + blockCount + " blocks!"); // Reports number of blocks found
		if (blockCount <= 0) {
			return null; // If blocks were not found, stop processing
		}
		ArrayList<Block> blocks = pixy.getCCC().getBlocks(); // Gets a list of all blocks found by the Pixy2
		Block largestBlock = null;
		for (Block block : blocks) { // Loops through all blocks and finds the widest one
			if (largestBlock == null) {
				largestBlock = block;
			} else if (block.getWidth() > largestBlock.getWidth()) {
				largestBlock = block;
      }
      largestBlockWidth = largestBlock.getWidth();
		}
    return largestBlock;

    SmartDashboard.putNumber("Thicc Block", largestBlockWidth);
  }
}
