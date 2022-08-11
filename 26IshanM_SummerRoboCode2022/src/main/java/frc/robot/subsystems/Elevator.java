package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{

    private static Elevator instance;
    private HSTalon master;
    private HSTalon follower;
    private VictorSPX follower1;
    private VictorSPX follower2;
    private static final int MASTER_ID = 0;
    private static final int FOLLOWER_ID = 0;
    private static final int FOLLOWER1_ID = 0;
    private static final int FOLLOWER2_ID = 0;
    private static final boolean MASTER_INVERT = false;
    private static final boolean FOLLOWER_INVERT = false;
    private static final boolean FOLLOWER1_INVERT = false;
    private static final boolean FOLLOWER2_INVERT = false;

    private Elevator() {
        master = new HSTalon(MASTER_ID);
        follower = new HSTalon(FOLLOWER_ID);
        follower1 = new VictorSPX(FOLLOWER1_ID);
        follower2 = new VictorSPX(FOLLOWER2_ID);
        follower.follow(master);
        follower1.follow(master);
        follower2.follow(master);
        master.setInverted(MASTER_INVERT);
        follower.setInverted(FOLLOWER_INVERT);
        follower1.setInverted(FOLLOWER1_INVERT);
        follower2.setInverted(FOLLOWER2_INVERT);
    }

    public static Elevator getInstance() {
        if(instance == null) {
            instance = new Elevator();
        }
        return instance;
    }

    public void setPercentOutput(double value) {
        master.set(ControlMode.PercentOutput, value);
    }
}
