package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.WristSubsystem;

public class RobotContainer {

   XboxController buttons = new XboxController(0);

    DriveSubsystem drive = new DriveSubsystem();
    TurretSubsystem turret = new TurretSubsystem();
    WristSubsystem wrist = new WristSubsystem();
    LauncherSubsystem launcher = new LauncherSubsystem();

    public RobotContainer() {
        defaultConfig();
    }

    private void defaultConfig() {
        drive.setDefaultCommand(
            new RunCommand(
                () -> drive.tankDrive(
                    buttons.getLeftY(),
                    buttons.getRightY()
                ),
                drive
            )
        );
        turret.setDefaultCommand(
            new RunCommand(
                () -> { int pov = buttons.getPOV();
            
                if (pov == 0) {
                    turret.runTurret(0.3);
                } else if (pov == 180) {
                    turret.runTurret(-0.3);
                } else {
                    turret.stop();
                }}, turret
            )
        );

        wrist.setDefaultCommand(
            new RunCommand(
                () -> { int pov = buttons.getPOV();

                if (pov == 270) {
                    wrist.runWrist(0.3);
                } else if (pov == 90) {
                    wrist.runWrist(-0.3);
                } else {
                    wrist.stop();
                }}, wrist
            )
        );
        
        launcher.setDefaultCommand(
            new RunCommand(
                () -> new JoystickButton(buttons, XboxController.Button.kA.value).onTrue(
                
                new SequentialCommandGroup(
                new InstantCommand(() -> launcher.start(), launcher),
                new WaitCommand(0.25),
                new InstantCommand(() -> launcher.stop(), launcher)
                )), launcher
            )
        );
    }
}