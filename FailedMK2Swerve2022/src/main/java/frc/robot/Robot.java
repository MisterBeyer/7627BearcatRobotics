package frc.robot;

import frc.robot.subsystems.DrivetrainSubsystem;

import org.frcteam2910.common.robot.Utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private static OI oi;

    private static DrivetrainSubsystem drivetrain;

    Joystick joystick = new Joystick(0);
    //Joystick flightStick = new Joystick(1);

    public static OI getOi() {
        return oi;
    }

    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain = DrivetrainSubsystem.getInstance();
    }

    public void teleopInit() {

    }

    public void teleopPeriodic() {
        double speed = 1; //Math.abs(flightStick.getRawAxis(3));
        //swerveDrive(flightStick.getRawAxis(1) * speed, flightStick.getRawAxis(0) * speed, flightStick.getRawAxis(2) * speed);
        swerveDrive(joystick.getRawAxis(1) * speed, joystick.getRawAxis(0) * speed, joystick.getRawAxis(4) * speed);
    }

    public void swerveDrive(double forward, double strafe, double rotation) {
        forward = Utilities.deadband(forward, .1);
        
        strafe = Utilities.deadband(strafe, .1);
        if(forward == 0 && Math.abs(strafe) > 0)
          forward = 0.1;
    
        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 2.0), forward);
    
        // Square the strafe stick
        strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);
    
        rotation = Utilities.deadband(rotation);
        // Square the rotation stick
        rotation = Math.copySign(Math.pow(rotation, 2.0), rotation);
    
        DrivetrainSubsystem.getInstance().drive(new Translation2d(forward, strafe), rotation, true);
      }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
