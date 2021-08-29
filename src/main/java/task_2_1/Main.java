package task_2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Car> list = new ArrayList<Car>();

        list.add(new Car("Лада", "седан"));
        list.add(new Car("Лада", "хэтчбек"));
        list.add(new Car("Мерседес","седан"));
        list.add(new Car("Бмв", "кроссовер"));
        list.add(new Car("Форд", "хэтчбек"));
        list.add(new Car("Пежо","кроссовер"));
        list.add(new Car("Тойота", "седан"));

        Map<String, List<Car>> map = list.stream().collect(Collectors.groupingBy(Car::getType));

        map.forEach((key, value) -> {

            System.out.println("type: " + key);
            for (Car car : value) {
                System.out.println(car);
            }
            System.out.println();

        });

    }
}
