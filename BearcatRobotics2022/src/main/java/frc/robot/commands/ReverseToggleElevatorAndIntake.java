// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class ReverseToggleElevatorAndIntake extends CommandBase {
  /** Creates a new ToggleElevatorAndIntake. */
  private final Intake intake;
  private final Elevator elevator;

  public ReverseToggleElevatorAndIntake(Elevator elevator,Intake intake) {
    this.elevator=elevator;
    this.intake=intake;

    addRequirements(elevator,intake);
    // Use addRequirements() here to declare subsystem dependencies.
   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 if (elevator.getSpeed()==0) {
   elevator.setSpeed(-1.0);
   intake.setSpeed(0.3);
  
 }  
 else {
   elevator.setSpeed(0);
   intake.setSpeed(0);
 }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
