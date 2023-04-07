public class MassiveWithMassive {

    public static void main(String[] args) {
        massiveWithMassive();
    }
//      Помимо массивов примитивов и массивов объектов, возможно создавать массивы массивов -
// массив - в котором содержаться другие массивы одного типа.
//Создадим массив с типа int содержащий в себе несколько массивов.
    public static void massiveWithMassive() {
        int[][] studentsMarks = {
                {2,0,0,0,0,0,2},
                {0,2,0,0,0,2,0},
                {0,0,2,0,2,0,0},
                {0,0,0,2,0,0,0},
                {0,0,2,0,2,0,0},
                {0,2,0,0,0,2,0},
                {2,0,0,0,0,0,2}
        };
//Если распечатать длину этого массива, то она будет равна 5 - пять рядов чисел.
        System.out.println("Длинна массива: " + studentsMarks.length + " объектов.");
//Что бы корректно вывести информацию из массива нужно написать несколько циклов.
// Первый цикл для вывода номера массива в массив, второй для значений, сохраненных в этом массиве:
        for(int[] array:studentsMarks){
            System.out.println(array);
        }
//        for(int i = 0; i < studentsMarks.length; i++) {
//            System.out.println("Class № : " + i + ". students: " + studentsMarks[i].length);
//
//            for(int j = 0; j < studentsMarks[i].length; j++) {
//                System.out.println("\t" + studentsMarks[i][j]);
//            }
//        }
    }
}