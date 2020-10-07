package com.company;

public class Main {

    public static void main(String[] args) {
        Student[] s1 = new Student[5];
        s1[0] = new Student("Lopatina Kristina", 12);
        s1[1] = new Student("Lopatina Polina", 3);
        s1[2] = new Student("Cheglakova Margorita", 4);
        s1[3] = new Student("Kopcova Dary", 6);
        s1[4] = new Student("Kolomarov Vladimir", 25);

        Student[] s2=new Student[7];
        s2[0] = new Student("Lopatina Kristina", 33);
        s2[1] = new Student("Lopatina Polina", 8);
        s2[2] = new Student("Cheglakova Margorita", 9);
        s2[3] = new Student("Kopcova Dary", 11);
        s2[4] = new Student("Kolomarov Vladimir", 34);
        s2[5] = new Student("Kopcova Dary", 15);
        s2[6] = new Student("Kolomarov Vladimir", 30);

        Student[] s=new Student[12];
        System.arraycopy(s1, 0, s, 0, 5);
        System.arraycopy(s2, 0, s, 5, 7);
        mergeSort(s, 0, 11);
        for (int i=0; i<12; i++){
            System.out.println(s[i]);
        }

    }
    public static void mergeSort(Student[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || source[cursor].ID > source[delimiter].ID) {
                buffer[i] = source[cursor].ID;
                cursor++;
            } else {
                buffer[i] = source[delimiter].ID;
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }


}
