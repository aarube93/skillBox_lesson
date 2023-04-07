import java.util.Scanner;

public class bankAccount {

    public static void main(String[] args) {

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите сумму вклада: ");
            float sum = in.nextFloat();
            float startSum = sum;
            int feeSum = 1_000_000;

            Scanner in1 = new Scanner(System.in);
            System.out.print("Введите количество месяцев: ");
            int month = in1.nextInt();

            for (int i = 0; i < month; i++) {

                float percentSum = ((sum * 0.085F) / 12F);
                System.out.println("%: " + percentSum);
                sum += percentSum;
                System.out.println("sum: "+sum);

            }

            if (sum > feeSum) {
                float chargeFeeSum = (sum - startSum) * 0.13F;
                System.out.println("Сумма на счете на конец периода: " + (sum - chargeFeeSum));
                System.out.println("Сумма налога: " + chargeFeeSum);
                System.out.println("Прибыль: " + ((sum - startSum) - chargeFeeSum));
            } else {
                System.out.println("Сумма на счете на конец периода: " + sum);
                System.out.println("Прибыль: " + (sum - startSum));
            }
        }
    }
}
