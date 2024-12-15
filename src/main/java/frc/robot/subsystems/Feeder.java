package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {

    private final TalonFX feederMotor;
    private final DigitalInput feederSensor; // Feeder sensörü

    public Feeder() {
        feederMotor = new TalonFX(2); // Motoru başlat
        feederSensor = new DigitalInput(1); // Sensörün bağlı olduğu pin (örneğin 1)
    }

    // Feeder motorunu kontrol et
    public void setFeederSpeed(double speed) {
        // Sensör aktifse motoru durdur
        if (feederSensor.get()) {
            feederMotor.set(0);
        } else {
            feederMotor.set(speed);
        }
    }

    @Override
    public void periodic() {
        // Burada sensör verilerini izleyebiliriz
    }
}
