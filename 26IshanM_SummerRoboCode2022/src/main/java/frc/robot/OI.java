package frc.robot;

import commands.ToggleExtender;
import commands.ToggleFlower;
import commands.ToggleIntake;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private XboxGamepad driver;
    private static final int DRIVER_ID = 0;

    private static OI instance;

    private OI() {
        driver = new XboxGamepad(DRIVER_ID);
        initBindings();
    }

    public static OI getInstance() {
        if(instance == null) {
            instance = new OI();
        }
        return instance;
    }

    public XboxGamepad getDriver() {
        return driver;
    }

    public void initBindings() {
        driver.getButtonA().whenPressed(new ToggleIntake());
        driver.getButtonB().whenPressed(new ToggleFlower());
        driver.getButtonX().whenPressed(new ToggleExtender());
    }

    public boolean getUpDPadButton() {
        return false;
    }
}
