package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase {
    SparkMax wristMotor = new SparkMax(10, MotorType.kBrushless);
    SparkMaxConfig wristConfig = new SparkMaxConfig();

    public void config() {
        wristMotor.configure(wristConfig, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
    }

    public void runWrist(double wSpeed){
        wristMotor.set(wSpeed);
    }

    public void stop() {
        wristMotor.stopMotor();
    }
}
