import java.util.ArrayList;

public class Race {

    protected static ArrayList<Car> calculationPath(ArrayList<Car> carsList) {
        ArrayList<Car> carsForPath = new ArrayList<>(carsList);

        for (int i = 0; i < carsForPath.size(); i++) {
            int hoursInDay = 24;
            int speed = carsForPath.get(i).getSpeed();

            speed *= hoursInDay;
            carsForPath.get(i).setSpeed(speed);
        }
        return carsForPath;
    }

    protected static Car getFastestCar(ArrayList<Car> carsList) {
        Car car = new Car("name", -1);

        for (int i = 0; i < carsList.size(); i++) {
            int speedCarInList = carsList.get(i).getSpeed();
            int speedCar = car.getSpeed();
            String nameCarInList = carsList.get(i).getName();

            if (speedCarInList > speedCar) {
                car.setSpeed(speedCarInList);
                car.setName(nameCarInList);
            }
        }
        return car;
    }
}
