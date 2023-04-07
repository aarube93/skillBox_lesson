package com.animals.meat_eating;

public class Tiger {
    private int weight;
    private String name;
    private boolean isHunter;

    public Tiger(int weight, String name, boolean isHunter) {
        this.weight = weight;
        this.name = name;
        this.isHunter = isHunter;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHunter() {
        return isHunter;
    }

    public void setHunter(boolean hunter) {
        isHunter = hunter;
    }
}

