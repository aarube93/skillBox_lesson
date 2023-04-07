public class iterations {
    public static void main(String[] args) {
        long population = 10_000_000L;
        var born = 14;
        var dead = 8;

        System.out.println("MyCode:\n"+myCode(population,born,dead));

        System.out.println("ExpertCode:\n"+expertCode(population,born,dead));

    }
    public static long myCode(long population, int born, int dead) {
        for (var y = 0; y < 10; y++) {
            born--;
            dead--;
            if(born <= 6) {
                born = 7;
            }
            if (dead <= 7) {
                dead = 6;
            }
            for (var i = 0; i < population; i++) {
                if (i % 1000 == 0) {
                    population += born;
                    population -= dead;
                }
            }
        }

        return population;
    }

    public static long expertCode(long population, int born, int death) {
        for(int i = 0; i <= 10; i++){
            if (born > 7) born -= 1;
            if  (death > 6) death -=1;
            population += population * (born - death) / 1000;
        }
        return population;
    }
}
