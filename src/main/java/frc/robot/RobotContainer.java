/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

//Controllers
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

//Constants
import frc.robot.Constants.joyStickConstants;
import frc.robot.Constants.xBoxConstants;

//Subsystems
import frc.robot.subsystems.FuelCell;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Pixy;
import frc.robot.subsystems.Arduino;

//Teleop Commands
import frc.robot.commands.ChangeGear;
import frc.robot.commands.Drive;
import frc.robot.commands.FuelCellSol;
import frc.robot.commands.bigBlock;
import frc.robot.commands.PrintLLvalues;
import frc.robot.commands.CenterGoal;
import frc.robot.commands.FuelCellMot;
import frc.robot.commands.FuelCellMotOut;
import frc.robot.commands.setPLED;
import frc.robot.commands.SeekBall;
import frc.robot.commands.ByteCodes;

//Auto Commands
import frc.robot.commands.Auto.A_Drive;
import frc.robot.commands.Auto.A_MoveRaiseFC;
import frc.robot.commands.Auto.A_Score;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and default commands are defined here...
    //Subsystems
  private final Chassis m_Chassis;
  private final FuelCell m_FuelCell;
  private final Vision m_Vision;
  private final Pixy m_Pixy;
  private final Arduino m_Arduino;

  //Default Commands
  private final ByteCodes m_ByteCodes;
  private final Drive m_Drive;
  private final FuelCellMot m_FuelCellMot;
  private final PrintLLvalues m_PrintLLvalues;

  //Defined Controllers
  public static Joystick m_DriverStick;
  public static XboxController m_OperatorController;

  //Define/Instantiate Chooser
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

   //Instantiate Subsystems 
    m_Vision = new Vision();
    m_Chassis = new Chassis();
    m_FuelCell = new FuelCell();
    m_Pixy = new Pixy();
    m_Arduino = new Arduino();

    //Set Default Commands
    m_Drive = new Drive(m_Chassis);
    m_FuelCellMot = new FuelCellMot(m_FuelCell);
    m_PrintLLvalues = new PrintLLvalues(m_Vision);

    m_Chassis.setDefaultCommand(m_Drive);
    m_FuelCell.setDefaultCommand(m_FuelCellMot);
    m_Vision.setDefaultCommand(m_PrintLLvalues);
    m_ByteCodes = new ByteCodes(m_Arduino);

    m_Chassis.setDefaultCommand(m_Drive);
    m_FuelCell.setDefaultCommand(m_FuelCellMot);
    m_Arduino.setDefaultCommand(m_ByteCodes);


    
    //Define Controller
    m_DriverStick = new Joystick(joyStickConstants.stickPort);
    m_OperatorController = new XboxController(xBoxConstants.operatorPort);

    // Configure the button bindings
    configureButtonBindings();

    //define auto commands
    final Command m_simpleAuto = new ChangeGear(m_Chassis);
    final Command m_complexAuto = new A_Score(m_Chassis, m_FuelCell);
    final Command m_driveOffLine = new A_Drive(2, .3, m_Chassis);

    //Autonomous chooser options
   
    m_chooser.setDefaultOption("Simple Auto", m_simpleAuto);
    m_chooser.addOption("Complex Auto", m_complexAuto);
    m_chooser.addOption("Drive Off Line", m_driveOffLine);

    // Put the chooser on the dashboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
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

    new JoystickButton(m_OperatorController, xBoxConstants.A_BUTTON)
                       .whenPressed(new FuelCellSol(m_FuelCell));
    
    new JoystickButton(m_OperatorController, xBoxConstants.X_BUTTON)
                        .whenPressed(new setPLED(m_Pixy));

    new JoystickButton(m_OperatorController, xBoxConstants.B_BUTTON)
                        .whileHeld(new SeekBall(m_Chassis, m_Pixy));
                        
    new JoystickButton(m_OperatorController, xBoxConstants.RIGHT_BUMPER)
                        .whileHeld(new FuelCellMotOut(m_FuelCell));

    new JoystickButton(m_OperatorController, xBoxConstants.Y_BUTTON)
                      .whileHeld(new CenterGoal(m_Vision));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return  m_chooser.getSelected();
  }
}
