package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {
    PneumaticHub hub = new PneumaticHub(1);
    
    Solenoid one = hub.makeSolenoid(1);
    Solenoid two = hub.makeSolenoid(2);
    Solenoid three = hub.makeSolenoid(3);
    Solenoid four = hub.makeSolenoid(4);
    Solenoid five = hub.makeSolenoid(5);

    public void config(){
        hub.enableCompressorDigital();
    }

    public void start() {
        one.set(true);
        two.set(true);
        three.set(true);
        four.set(true);
        five.set(true);
    }

    public void stop() {
        one.set(false);
        two.set(false);
        three.set(false);
        four.set(false);
        five.set(false);
    }
}
