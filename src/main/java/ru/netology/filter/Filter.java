package ru.netology.filter;
import ru.netology.logger.Logger;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {

        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");


        return source.stream()
                .filter(x -> x >= treshold)
                .collect(Collectors.toList());
/*
        //Чтобы залогировать каждый шаг можно было так. Но через стримы как-то изящнее

        List<Integer> result2 = new ArrayList<>();

        for (Integer i : source) {

            if (i >= treshold) {

                result2.add(i);
                logger.log("Элемент " + i + " прошел фильтр");

            } else {

                logger.log("Элемент " + i + " не прошел фильтр");

            }

        }
        return result2;

*/


    }
}
