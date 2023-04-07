import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Lamp iliich = new Lamp(60);
        iliich.setType(Lamp.Type.INCANDESCENT);

        ArrayList<Lamp> lamps = new ArrayList<>();
        lamps.add(new Lamp(100));
        lamps.add(new Lamp(40));
        lamps.add(new Lamp(20));
        lamps.add(new Lamp(250));

        Collections.sort(lamps );

        for (Lamp item : lamps) {
            System.out.println(item);
        }
    }
}

class Lamp extends LightingDevise {

    public Type type;

    public enum Type{
        INCANDESCENT,
        LED,
        LUMINESCENT,
        FILAMENT
    }

    public Lamp(int power) {
        super(power);
    }

    @Override
    public double getEnergyConsumption() {
        return power * brightness;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

class Chandelier extends LightingDevise {

    private static final int LAMP_BRIGHTNESS_STEPS = 2;
    private static final double CONSUMPTION_COEFF = 1.095;

    private final int lampCount;

    private Controller controller;

    private class Controller {
        public void reset() {
             //some logic
        }
    }

    public Chandelier(int power, int lampCount) {
        super(power);
        this.lampCount = lampCount;
        controller = new Controller();
    }

    @Override
    public void setBrightness(double level) {
        double step = 1.0 / (lampCount * LAMP_BRIGHTNESS_STEPS);
        int stepCount = (int) Math.round(level / step);
        super.setBrightness(step * stepCount);
        if (brightness == 0) {
            controller.reset();
        }
    }

    @Override
    public double getEnergyConsumption() {
        return power * Math.pow(brightness, CONSUMPTION_COEFF);
    }
}

abstract class LightingDevise
implements ElectricDevice, Comparable  {
    public static final double MAX_BRIGHTNESS = 1D;
    public static final double MIN_BRIGHTNESS = 0D;

    protected final int power;
    protected double brightness;

    @Override
    public boolean isSwitchedOn() {
        return brightness > 0;
    }

    @Override
    public void switchOff() {
        setBrightness(MIN_BRIGHTNESS);
    }

    @Override
    public void switchOn() {
        setBrightness(MAX_BRIGHTNESS);
    }

    public LightingDevise(int power) {
        this.power = power;
    }

    public void setBrightness(double level) {
        if (level < MIN_BRIGHTNESS) {
            brightness = MIN_BRIGHTNESS;
        } else if (level > MAX_BRIGHTNESS) {
            brightness = MAX_BRIGHTNESS;
        } else {
            brightness = level;
        }
    }

    public double getBrightness() {
        return brightness;
    }

    public void changeBrightness(double rate) {
        setBrightness(brightness + brightness * rate);
    }

    @Override
    public int compareTo(Object o) {
        LightingDevise devise = (LightingDevise) o;
        return Integer.compare(power, devise.power);
    }

    public String toString() {
        return getClass().getName() + " Devise with power: " + power;
    }
}

//class Fun implements ElectricDevice {
//
//    @Override
//    public void switchOn() {
//
//    }
//
//    @Override
//    public void switchOff() {
//
//    }
//
//    @Override
//    public double getEnergyConsumption() {
//        return 0;
//    }
//}