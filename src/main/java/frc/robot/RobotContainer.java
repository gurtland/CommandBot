package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

   XboxController buttons = new XboxController(0);

    DriveSubsystem drive = new DriveSubsystem();

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
    }
}