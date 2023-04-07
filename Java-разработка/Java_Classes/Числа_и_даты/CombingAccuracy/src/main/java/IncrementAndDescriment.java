public class IncrementAndDescriment {
    public static void main(String[] args) {
        postIncrement();
        preIncrement();
    }

    public static void postIncrement() {
       int value = 38;
       int post = value++;//Увеличение значения происходит после его возвращения
        System.out.println(post);//=38
    }

    public static void preIncrement() {
        int value = 38;
        int post = ++value;//Разница в том, что сначала произойдет операци инкремента, то есть число value будет
        // увеличино на 1 а потом проийзойдет операция присмвоения.
        System.out.println(post);
    }

}
