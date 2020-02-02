/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Drive;
import frc.robot.commands.ChangeGear;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Chassis;
import frc.robot.Constants.joyStickConstants;
import frc.robot.subsystems.FuelCellEE;
import frc.robot.commands.FuelCellEEScore;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Chassis m_Chassis;
  private final Drive m_Drive;
  private final FuelCellEE m_FuelCellEE;
  private final FuelCellEEScore m_FuelCellEEScore;
  public static Joystick m_DriverStick;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_Chassis = new Chassis();
    m_Drive = new Drive(m_Chassis);
    m_Chassis.setDefaultCommand(m_Drive);
    m_FuelCellEE = new FuelCellEE();
    m_FuelCellEEScore = new FuelCellEEScore(m_FuelCellEE);

    m_DriverStick = new Joystick(Constants.joyStickConstants.stickPort);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_DriverStick, joyStickConstants.changeGear)
                       .whenPressed(new ChangeGear(m_Chassis));

    new JoystickButton(m_DriverStick, joyStickConstants.fuelCellEE)
                       .whenPressed(new FuelCellEEScore(m_FuelCellEE));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
