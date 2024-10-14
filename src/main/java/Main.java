import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Принять участие в гонке? (да/нет)");

        String value = scanner.next().toLowerCase();

        switch (value) {
            case "да":
                while (true) {
                    ArrayList<Car> carsList = new ArrayList<>(3);

                    System.out.println("Для участия в гонке создайте три автомобиля.");

                    for (int i = 1; i < 4; i++) {
                        System.out.printf("Название %d-го автомобиля:", i);
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.printf("Скорость %d-го автомобиля (от 0 до 250 км/ч):", i);

                        while (true) {
                            try {
                                int speed = scanner.nextInt();

                                if (speed < 0 || speed > 250) {
                                    System.out.println("Некорректный ввод, попробуйте снова:");
                                } else {
                                    System.out.printf("%d-й автомобиль создан!\n", i);
                                    carsList.add(new Car(name, speed));
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Скорость может быть только в целочисленном" +
                                        " значении, попробуйте снова:");
                                scanner.nextLine();
                            }
                        }
                    }
                    System.out.println("Данные введены верно — приятной гонки!");
                    System.out.println("Участники:");
                    System.out.println(carsList);

                    ArrayList<Car> carsBeforeDay = Race.calculationPath(carsList);

                    System.out.println("Самый быстрый автомобиль: " +
                            Race.getFastestCar(carsBeforeDay).getName() + ".");
                    return;
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