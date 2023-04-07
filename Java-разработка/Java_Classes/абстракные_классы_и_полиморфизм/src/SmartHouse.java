import java.util.ArrayList;

public class SmartHouse {

    private ArrayList<ElectricDevice> collectDevisesOfTheHouse;

    public SmartHouse(){
        collectDevisesOfTheHouse = new ArrayList<>();
        initLightingDevises();
    }

    public double getEnergyConsumption() {
         double sum = 0;
         for (ElectricDevice item : collectDevisesOfTheHouse) {
             sum =+ item.getEnergyConsumption();
         }
         return sum;
    }

    public void switchOffAllLight() {
        for(ElectricDevice item: collectDevisesOfTheHouse) {
            if (item instanceof LightingDevise){
                item.switchOff();
            }
        }
    }

    public void switchOffAllDevises() {
        for(ElectricDevice item : collectDevisesOfTheHouse) {
            item.switchOff();
        }
    }

    public void initLightingDevises() {
        collectDevisesOfTheHouse.add(new Lamp(150));
        collectDevisesOfTheHouse.add(new Lamp(100));
        collectDevisesOfTheHouse.add(new Lamp(90));
        collectDevisesOfTheHouse.add(new Lamp(60));
        collectDevisesOfTheHouse.add(new Chandelier(100,4));
        collectDevisesOfTheHouse.add(new Chandelier(400,10));
        collectDevisesOfTheHouse.add(new Chandelier(250,5));
        collectDevisesOfTheHouse.add(new Chandelier(120,3));
    }
}
