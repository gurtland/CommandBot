package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {
    SparkMax turretMotor = new SparkMax(7, MotorType.kBrushless);
    SparkMaxConfig turretConfig = new SparkMaxConfig();

    public void config() {
        turretMotor.configure(turretConfig, ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
    }
}
