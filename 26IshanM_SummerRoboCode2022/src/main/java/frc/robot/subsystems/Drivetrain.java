package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    // singleton variable
    private static Drivetrain instance;

    private HSTalon leftMaster;
    private HSTalon rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;

    //constant for motor device id
    private static int LEFT_MASTER_ID = 0;
    private static int RIGHT_MASTER_ID = 0;
    private static int LEFT_FOLLOWER_ID = 0;
    private static int RIGHT_FOLLOWER_ID = 0;

    boolean leftMasterInvert = false;
    boolean rightMasterInvert = false;
    boolean leftFollowerInvert = false;
    boolean rightFollowerInvert = false;

    

    private Drivetrain() {
        leftMaster = new HSTalon(LEFT_MASTER_ID);
        rightMaster = new HSTalon(RIGHT_MASTER_ID);
        leftFollower = new VictorSPX(LEFT_FOLLOWER_ID);
        rightFollower = new VictorSPX(RIGHT_FOLLOWER_ID);
        rightFollower.follow(rightMaster);
        leftFollower.follow(leftMaster);
        leftMaster.setInverted(leftMasterInvert);
        rightMaster.setInverted(rightMasterInvert);
        leftFollower.setInverted(leftFollowerInvert);
        rightFollower.setInverted(rightFollowerInvert);
        
    }

    public HSTalon getLeftMaster() {
        return leftMaster;
    }

    public HSTalon getRightMaster() {
        return rightMaster;
    }

    public VictorSPX getLeftFollower() {
        return leftFollower;
    }
    
    public VictorSPX getRightFollower() {
        return rightFollower;
    }

    public void setArcadeDrive(double speed, double turn) {
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
    }

    // returns the drivetrain instance
    public static Drivetrain getInstance() {
        if(instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }
}
