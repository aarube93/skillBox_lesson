import java.util.Objects;

public class JavaClassInheritance {
//Наследование используется в том случае, если нужно расширить функционал какого-то класса, но по какой-то причине мы не
// можем просто взять и изменить код в этом классе. Например, он создан не нами и менять его нельзя или изменение
// выбьется из общей логики класса, создавать копию класса, с таким же, но расширенным кодом тоже плохая практика,
// потому что это ведет к ухудшению поддерживаемости кода, читай, дублированию.
    //Вот зачем нужно наследование:
    //1. Повторное использование уже существующих классов.
    //2. Моделирование наследования, существующего в предметной области

//Запилим практический пример, состоящий из 2 классов. Классы будут написаны в одном файле, поэтому
// модификатор доступа public не прописывается у классов в одном файле, если мы планируем их наследовать в этом же файле

    public static void main(String[] args) {
        Bus K357HA29 = new Bus(0.001);
        Bus K358HA29 = new Bus(0.001);
        Bus K359HA29 = new Bus(0.001);

        ElectricBus E001EE178 = new ElectricBus(0.001, 0.2);
        ElectricBus E002EE178 = new ElectricBus(0.001, 0.2);

        System.out.println("busCount: " + Bus.getCountBus());
        System.out.println("eBusCount: " + ElectricBus.getCountBus());
        System.out.println("allBus: " + (Bus.getCountBus() + ElectricBus.getCountBus()));
        K357HA29.refuel(1);
        E001EE178.refuel(1);

        System.out.println("reserve K357HA29: " + K357HA29.powerReserve());
        System.out.println("reserve E001EE178: " + E001EE178.powerReserve());
        System.out.println("K357HA29: go 50km " + K357HA29.run(50));
        System.out.println("E001EE178: go 50km " + E001EE178.run(50));
        System.out.println("reserve K357HA29: " + K357HA29.powerReserve());
        System.out.println("reserve E001EE178: " + E001EE178.powerReserve());
        System.out.println("E001EE178: go 850km " + E001EE178.run(850));
        System.out.println("reserve E001EE178: " + E001EE178.powerReserve());
    }
}

class Bus {
    private double tankFullnessRate; //rate of tank fullness , 0-1
    protected double consumptionRate;//rate (0-1) per 1km
    private static int countBus;

    public Bus(double consumptionRate) {
        this.consumptionRate = consumptionRate;
        countBus++;
    }

    public static int getCountBus() {
        return countBus;
    }

    public Boolean run(int distance) {
        if (powerReserve() < distance) {
            return false;
        }
        tankFullnessRate -= distance * consumptionRate;
        return true;
    }

    public void refuel(double tankRate) {
        double total = tankFullnessRate + tankRate;
        tankFullnessRate = total > 1 ? 1 : total;
    }

    public int powerReserve() {
        return (int) (tankFullnessRate / consumptionRate);
    }

    public double getTankFullnessRate() {
        return tankFullnessRate;
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Double.compare(bus.tankFullnessRate, tankFullnessRate) == 0 && Double.compare(bus.consumptionRate, consumptionRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tankFullnessRate, consumptionRate);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "tankFullnessRate=" + tankFullnessRate +
                ", consumptionRate=" + consumptionRate +
                '}';
    }
}

class ElectricBus extends Bus {

    private final double minimalTankFullnessRate;
    private static int countBus;
    private static final double degradationRate = 0.0001;
    private static final double minRateToDegrade = 0.1;

    public ElectricBus(double consumptionRate, double minimalTankFullnessRate) {
        super(consumptionRate);
        this.minimalTankFullnessRate = minimalTankFullnessRate;
        countBus++;
    }

    @Override
    public int powerReserve() {
        double remainingRate = getTankFullnessRate() - minimalTankFullnessRate;
        if (remainingRate <= 0) {
            return 0;
        }
        return (int) (remainingRate/getConsumptionRate());
    }

    public static int getCountBus() {
        return countBus;
    }

    public void refuel(double tankRate) {
        super.refuel(tankRate);
        double gfg = (int) tankRate % minRateToDegrade;
        consumptionRate += degradationRate * gfg;
    }
}
//Статические методы не умеют переопределяться. Это происходит из-за того, что методы родительского класса,
//которые являются статическими, не являются частью дочернего класса, хотя они в нем и доступны