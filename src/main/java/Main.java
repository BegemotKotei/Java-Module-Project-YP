import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Принять участие в гонке? (да/нет)");

        String value = scanner.next().toLowerCase();// Чтобы пользователь мог писать как он хочет

        switch (value) {
            case "да":
                while (true) {
                    ArrayList<Car> carsList = Car.createCars(scanner);
                    boolean flag = Car.speedCheck(carsList);
                    if (flag) {
                        System.out.println("Данные введены верно — приятной гонки!");
                        System.out.println("Скорость гонщиков:");
                        System.out.println(carsList);
                        ArrayList<Car> carsBeforeDay = Race.calculationPath(carsList);
                        System.out.println("Самый быстрый автомобиль: " +
                                Race.getFastestCar(carsBeforeDay).name +
                                ", его скорость составила: " +
                                (Race.getFastestCar(carsBeforeDay).speed / 24) + " км/ч.");
                        return;
                    } else {
                        System.out.println("Данные введены некорректно, попробуйте снова.");
                    }
                }
            case "нет":
                System.out.println("Программа завершена.");
                break;
            default:
                System.out.println("Такой команды нет. Попробуйте запустить программу снова.");
                break;
        }
    }

}