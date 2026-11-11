package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
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

    public void config() {
        left2Config.follow(left1);
        left1Config.inverted(true);

        left1.configure(left1Config, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
        left2.configure(left2Config, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);

        right2Config.follow(right1);
        right1Config.inverted(false);

        right1.configure(right1Config, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
        right2.configure(right2Config, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
    }   

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive1.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive1.stopMotor();
    }
}