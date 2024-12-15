package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private final TalonFX intakeMotor;
    private final DigitalInput intakeSensor; // Intake sensörü

    public Intake() {
        intakeMotor = new TalonFX(1); // Motoru başlat
        intakeSensor = new DigitalInput(0); // Sensörün bağlı olduğu pin (örneğin 0)
    }

    // Intake motorunu çalıştır
    public void setIntakeSpeed(double speed) {
        // Sensör aktifse motoru durdur
        if (intakeSensor.get()) {
            intakeMotor.set(0);
        } else {
            intakeMotor.set(speed);
        }
    }
    @Override
    public void periodic() {
        // Burada sensör verilerini izleyebiliriz
    }
}

