// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  VictorSPX motor;
  public Elevator() {
    motor = new VictorSPX(Constants.Elevator_ID);

  }
// public void on() {
//   motor.set(ControlMode.PercentOutput, 1.0);
// }
// public void off() {
//   motor.set(ControlMode.PercentOutput, 0.0);
// }
  public double getSpeed() {
    return motor.getMotorOutputPercent();
  }
  public void setSpeed(double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
