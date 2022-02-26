// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveDefault;
import frc.robot.commands.ToggleDoor;
import frc.robot.subsystems.Door;
import frc.robot.subsystems.Drivebase;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final Drivebase driveBase = new Drivebase();
  private final Door door = new Door();

  XboxController driveGamepad = new XboxController(0);

  // Creates a SlewRateLimiter that limits the rate of change of the signal to 0.5
  // units per second
  SlewRateLimiter filter = new SlewRateLimiter(0.5);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    driveBase.setDefaultCommand(new DriveDefault(
        driveBase,
        () -> (Constants.DriveBase.SPEED_MULTIPLIER)
            * (filter.calculate(driveGamepad.getLeftX()) * Constants.DriveBase.MAX_VELOCITY_METERS_PER_SECOND),
        () -> (Constants.DriveBase.SPEED_MULTIPLIER)
            * -(filter.calculate(driveGamepad.getLeftY()) * Constants.DriveBase.MAX_VELOCITY_METERS_PER_SECOND),
        () -> (Constants.DriveBase.SPEED_MULTIPLIER)
            * (filter.calculate(driveGamepad.getRightX())
                * Constants.DriveBase.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND)));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(driveGamepad, 1)
        .whenPressed(() -> driveBase.zeroGyroscope());

    new JoystickButton(driveGamepad, 2)
        .whenPressed(new InstantCommand(() -> door.setAngle(0)));

    new JoystickButton(driveGamepad, 3)
        .whenPressed(new ToggleDoor(door));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand();
  }
}
