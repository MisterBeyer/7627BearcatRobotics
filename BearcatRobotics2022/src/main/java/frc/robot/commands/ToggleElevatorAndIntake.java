// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class ToggleElevatorAndIntake extends CommandBase {
  /** Creates a new ToggleElevatorAndIntake. */
  private final Intake intake;
  private final Elevator elevator;

  public ToggleElevatorAndIntake(Elevator elevator, Intake intake) {
    this.elevator = elevator;
    this.intake = intake;
    System.out.println(" it does work");
    addRequirements(elevator, intake);
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("init");
    if (elevator.getSpeed() == 0) {
      // System.out.println("start");
      elevator.setSpeed(1.0);
      intake.setSpeed(-0.5);

    } else {
      System.out.println("stop");
      elevator.setSpeed(0);
      intake.setSpeed(0);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Execute is going");
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
