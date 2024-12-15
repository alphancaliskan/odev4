package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

public class IntakingCommand extends CommandBase {

    private final Intake intake;
    private final Feeder feeder;
    private final double intakeSpeed;
    private final double feederSpeed;

    public IntakingCommand(Intake intake, double intakeSpeed, Feeder feeder, double feederSpeed) {
        this.intake = intake;
        this.intakeSpeed = intakeSpeed;
        this.feeder = feeder;
        this.feederSpeed = feederSpeed;
        addRequirements(intake, feeder);
    }

    @Override
    public void execute() {
        // Intake motorunu hızla çalıştır
        intake.setIntakeSpeed(intakeSpeed);

        // Feeder motorunu hızla çalıştır
        feeder.setFeederSpeed(feederSpeed);
    }

    @Override
    public boolean isFinished() {
        // Sensörlerden biri tetiklenirse, işlem bitmeli
        return intake.isIntakeSensorTriggered() || feeder.isFeederSensorTriggered();
    }

    @Override
    public void end(boolean interrupted) {
        // Komut bittiğinde motorları durdur
        intake.setIntakeSpeed(0);
        feeder.setFeederSpeed(0);
    }
}
