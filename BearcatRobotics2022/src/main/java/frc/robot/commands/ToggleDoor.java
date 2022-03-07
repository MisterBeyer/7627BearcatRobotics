// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Door;

public class ToggleDoor extends CommandBase {
  private final Door door;
  /** Creates a new ToggleDoor. */
  public ToggleDoor(Door door) {
    this.door = door;

    addRequirements(door);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (door.getAngle() == 70) {
      door.setAngle(0);
      // System.out.print("angle 0");
    } else {
      door.setAngle(70);
      // System.out.print("angle 50");
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
