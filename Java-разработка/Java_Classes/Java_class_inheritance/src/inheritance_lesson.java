public class inheritance_lesson {
    public static void main(String[] args) {
        Box box1 = new Box(10, 15, 20);
        ColorBox cBox1 = new ColorBox(15, 20, 25, "green");
        HeavyBox hBox1 = new HeavyBox(20, 25, 30, "orange", 0.545);

        System.out.println(hBox1.getSetting() + " " + hBox1.getClass().getName());
        System.out.println(cBox1.getSetting() + " " + cBox1.getClass().getName());
        System.out.println(box1.getVolume() + " " + box1.getClass().getName());
    }
}

class Box {
    double height, width, depth;

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    double getVolume() {
        return height * width * depth;
    }
}

class ColorBox extends Box {
    String color;

    public ColorBox(double height, double width, double depth, String color) {
        super(height, width, depth);
    }

    String getSetting() {
        return "Volume: " + getVolume() + "Color" + color;
    }
}

class HeavyBox extends ColorBox {
    double weight;

    public HeavyBox(double height, double width, double depth, String color, double weight) {
        super(height, width, depth, color);
    }

    String getSetting() {
        return "Weight: " + weight;
    }
}
