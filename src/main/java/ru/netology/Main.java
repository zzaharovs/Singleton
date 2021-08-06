package ru.netology;


import ru.netology.filter.Filter;
import ru.netology.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        System.out.println("Здравствуйте");
        logger.log("Начало работы программы");

        List <Integer> numbers = generateNumberList(
                numberRequest("размер списка"),
                numberRequest("верхний порог генерируемых чисел")
        );

        printList(numbers, "Сгенерированный список");

        Filter filter = new Filter(
                numberRequest("порог для фильтра")
        );

        printList(filter.filterOut(numbers), "Отфильтрованный список");

        logger.log("Завершаем программу");


    }

    public static int numberRequest(String message) {

        Logger logger = Logger.getInstance();
        logger.log("Запрашиваем у пользователя " + message);

        while (true) {

            try {

                Scanner sc = new Scanner(System.in);
                int value;
                System.out.println("Укажите " + message);
                System.out.println("Введите целое положительное число больше нуля!");

                value = sc.nextInt();

                if (value > 0) {
                    logger.log("Число принято");
                    return value;
                }

                logger.log("Число не принято");

            } catch (Exception ignored) {

                logger.log("Введены некорректные данные");

            }

        }

    }

    public static List<Integer> generateNumberList(int size, int upperBound) {

        Logger logger = Logger.getInstance();
        logger.log("Генерируем список на основе введенных данных");
        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {

            numberList.add(rand.nextInt(upperBound));
            logger.log("Сгенерировано число " + numberList.get(i));

        }

        return numberList;
    }

    public static void printList (List <Integer> numbers, String message) {

        Logger logger = Logger.getInstance();
        logger.log("Выводим на печать " + message);

        System.out.println(message + ":");
        numbers.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }


}
