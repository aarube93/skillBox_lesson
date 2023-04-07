public interface ElectricDevice {

    boolean isSwitchedOn();

    void switchOn();

    void switchOff();

    double getEnergyConsumption();

     default void toggle() {
        if(isSwitchedOn()) {
            switchOff();
        } else {
            switchOn();
        }
    }
}
