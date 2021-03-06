// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.swervedrivespecialties.swervelib.SdsModuleConfigurations;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
        public static final class DriveBase {

              

                public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(206.17968750000003 - 10 - 26);
                public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(89.46990966796875 + 180 - 10);
                public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(25.74920654296875 + 180 + 20 + 22);
                public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(106.8695068359375 + 19);

                // TODO: Tune To Your Robot
                public static final double TRACKWIDTH = Units.inchesToMeters(23.5);
                public static final double WHEELBASE = Units.inchesToMeters(23.125);

                // TODO: Tune TO Your Robot
                public static final double SPEED_MULTIPLIER = .5;

                public static final double MAX_VOLTAGE = 12.0;

                public static final double MAX_VELOCITY_METERS_PER_SECOND = 6380.0 / 60.0 *
                                SdsModuleConfigurations.MK3_STANDARD.getDriveReduction() *
                                SdsModuleConfigurations.MK3_STANDARD.getWheelDiameter() * Math.PI;

                public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = MAX_VELOCITY_METERS_PER_SECOND /
                                Math.hypot(TRACKWIDTH / 2.0, WHEELBASE / 2.0);

                public static final SwerveDriveKinematics DRIVE_KINEMATICS = new SwerveDriveKinematics(
                                // Front left
                                new Translation2d(TRACKWIDTH / 2.0, WHEELBASE / 2.0),
                                // Front right
                                new Translation2d(TRACKWIDTH / 2.0, -WHEELBASE / 2.0),
                                // Back left
                                new Translation2d(-TRACKWIDTH / 2.0, WHEELBASE / 2.0),
                                // Back right
                                new Translation2d(-TRACKWIDTH / 2.0, -WHEELBASE / 2.0));

        }

        public static final int DOOR_SERVO = 0;
        public static final int Intake_ID = 28;
        public static final int Elevator_ID = 7;
        public static final double START_DOOR_ANGLE = 19;
        public static final double END_DOOR_ANGLE = 89; // Cannot go over 90 degrees
        // This is a github test
        // double allision_is_dumb = 7.8;
        // String allision_is_semiDumb = "qort";
        // boolean allision_is_lessDumb = true;
        // if ( allision_is_dumb == 7.8) {
        //         System.out.print("declan is screaming");
        // this video shows you just about everything that has to do with coding and if you ever need to know something check this video 
        // https://www.youtube.com/watch?v=dQw4w9WgXcQ
        // }
}
