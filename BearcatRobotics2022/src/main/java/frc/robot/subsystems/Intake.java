// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private CANSparkMax motor;
  /** Creates a new Intake. */
  public Intake() {
    // either messed up the constructor part or i just couldn't make it without the null
    motor = new CANSparkMax(Constants.intake_Motor_Id, null);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
