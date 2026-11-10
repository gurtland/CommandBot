package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {

    SparkMax left1 = new SparkMax(2, MotorType.kBrushless);
    SparkMax left2 = new SparkMax(4, MotorType.kBrushless);
    SparkMax right1 = new SparkMax(1, MotorType.kBrushless);
    SparkMax right2 = new SparkMax(3, MotorType.kBrushless);

    DifferentialDrive drive1 = new DifferentialDrive(left1, right1);

    SparkMaxConfig left1Config = new SparkMaxConfig();
    SparkMaxConfig left2Config = new SparkMaxConfig();

    SparkMaxConfig right1Config = new SparkMaxConfig();
    SparkMaxConfig right2Config = new SparkMaxConfig();

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive1.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive1.stopMotor();
    }
}