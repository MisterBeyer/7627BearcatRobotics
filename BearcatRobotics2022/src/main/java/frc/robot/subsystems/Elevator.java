// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Elevator extends SubsystemBase {
  // insert VEX motor here
  private VictorSPX motor;
  /** Creates a new Elevator. */
  public Elevator() {
    motor = new VictorSPX(Constants.elevator_ID);
  }

  public void moveMotor(double angle) {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
