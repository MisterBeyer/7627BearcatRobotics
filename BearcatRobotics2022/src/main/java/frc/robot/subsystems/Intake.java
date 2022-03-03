// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  CANSparkMax motor;

  public Intake() {
    motor = new CANSparkMax(Constants.Intake_ID, MotorType.kBrushless);
  }

  // public void on() {
  //  motor.set(1.0);
  // }
  // public void off() {
  //   motor.set(0.0);
  //  }
   public void setSpeed(double speed){
    motor.set(speed);
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
