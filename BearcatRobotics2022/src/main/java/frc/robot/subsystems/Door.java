// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Door extends SubsystemBase {
  private Servo doorActuator;

  /** Creates a new Door. */
  public Door() {
    doorActuator = new Servo(Constants.DOOR_SERVO);
  }

  public void setAngle(double angle) {
    doorActuator.setAngle(angle);
  }

  public double getAngle() {
    return doorActuator.getAngle();
  }

  public void setSpeed(double speed) {
    doorActuator.setSpeed(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
