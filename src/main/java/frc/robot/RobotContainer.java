package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakingCommand;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

public class RobotContainer {
    // Subsystem ve controller nesnelerini başlatıyoruz
    Intake intake = new Intake();
    Feeder feeder = new Feeder();
    PS5Controller mDrivController = new PS5Controller(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // Joystick butonları ile komutları bağla
        new JoystickButton(mDrivController, 1).onTrue(new IntakingCommand(intake, 1, feeder, 0.7));
        new JoystickButton(mDrivController, 2).onTrue(new IntakingCommand(intake, -1, feeder, -0.7));
    }

    public Command getAutonomousCommand() {
        // Otonom komut buraya eklenebilir
        return null;
    }
}
