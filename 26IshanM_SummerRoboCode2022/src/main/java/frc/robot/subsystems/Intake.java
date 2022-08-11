package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    
    private static Intake instance;
    private HSTalon motor;
    private static final int MOTOR_ID = 0;
    private static final boolean MOTOR_INVERTED = false;
    private DoubleSolenoid piston;
    private static final int PORT_1 = 0;
    private static final int PORT_2 = 0;
    private boolean intaking;
    
    private Intake() {
        motor = new HSTalon(MOTOR_ID);
        motor.setInverted(MOTOR_INVERTED);
        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PORT_1, PORT_2);
        intaking = false;

    }

    public static Intake getInstance() {
        if(instance == null) {
            instance = new Intake();
        }
        return instance;
    }

    public void setPercentOutput(double output) {
        intaking = output >= 0.1;
        motor.set(ControlMode.PercentOutput, output);
    }

    public void toggleValue() {
        if(piston.get() == DoubleSolenoid.Value.kReverse) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(piston.get() == DoubleSolenoid.Value.kOff) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else if(piston.get() == DoubleSolenoid.Value.kForward) {
            piston.set(DoubleSolenoid.Value.kOff);
        }
    }

    public boolean getIntake() {
        return intaking;
    }
}
