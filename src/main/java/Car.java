import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    //Не обрабатываю пустые значения, повторы и неккорректный ввод пользователя,
    //В ТЗ такое нет, а для простой задачи писать лень;(
    protected static ArrayList<Car> createCars(Scanner scanner) {
        ArrayList<Car> carsSet = new ArrayList<>(3);

        System.out.println("Для участия в гонке создайте три автомобиля.");

        for (int i = 1; i < 4; i++) {
            System.out.printf("Название %d-го автомобиля:", i);
            String name = scanner.next();
            System.out.printf("Скорость %d-го автомобиля:", i);
            int speed = scanner.nextInt();
            carsSet.add(new Car(name, speed));
            System.out.printf("%d-й автомобиль создан!\n", i);
        }
        return carsSet;
    }

    protected static boolean speedCheck(ArrayList<Car> carsList) {
        boolean flag = false;

        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).speed > 0) {
                if (carsList.get(i).speed <= 250) {
                    flag = !flag;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Автомобиль: " + name + ", скорость: " + speed + " км/ч"; //Всего 3 автомобиля,
        // Поэтом не стал печатать каждую строку с новой строки
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(speed, car.speed) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed);
    }
}
