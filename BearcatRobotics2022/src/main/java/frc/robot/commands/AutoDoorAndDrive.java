// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import frc.robot.Constants;
import frc.robot.subsystems.Door;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;

import java.util.function.DoubleSupplier;

public class AutoDoorAndDrive extends CommandBase {

  private final Drivebase driveBase;

  private final Door door;
  
  private final Elevator elevator;

  private Timer timer;

  double doorOpenTime = 3;

  private final DoubleSupplier translationXSupplier;
  private final DoubleSupplier translationYSupplier;
  private final DoubleSupplier rotationSupplier;

      /** Creates a new AutoDoorAndDrive. */
      public AutoDoorAndDrive(Drivebase driveBase,
        Door door,
        Elevator elevator,
        DoubleSupplier translationXSupplier,
        DoubleSupplier translationYSupplier,
        DoubleSupplier rotationSupplier) {
    this.driveBase = driveBase;
    this.translationXSupplier = translationXSupplier;
    this.translationYSupplier = translationYSupplier;
    this.rotationSupplier = rotationSupplier;
    this.door = door;
    this.elevator = elevator;

    addRequirements(driveBase, door, elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer();
    timer.start();
    driveBase.zeroGyroscope();
    door.setAngle(Constants.END_DOOR_ANGLE);
    elevator.setSpeed(1.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    // if (timer.get() == doorOpenTime) {
    //   door.setAngle(Constants.START_DOOR_ANGLE);
    if (timer.get() > doorOpenTime) {
      door.setAngle(Constants.START_DOOR_ANGLE);
      elevator.setSpeed(0);
      driveBase.drive(
          ChassisSpeeds.fromFieldRelativeSpeeds(
                translationXSupplier.getAsDouble(),
                translationYSupplier.getAsDouble(),
                rotationSupplier.getAsDouble(),
                driveBase.getGyroscopeRotation()));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > doorOpenTime + 4; // Run drive command for 4 seconds
  }
}
