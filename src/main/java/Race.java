import java.util.ArrayList;

public class Race {

    protected static ArrayList<Car> calculationPath(ArrayList<Car> carsList) {
        ArrayList<Car> carsForPath = new ArrayList<>(carsList);

        for (int i = 0; i < carsForPath.size(); i++) {
            int hoursInDay = 24;
            carsForPath.get(i).speed *= hoursInDay;
        }
        return carsForPath;
    }

    //Не учитываю сценария, где скорости равны или являются пустыми значениями, в ТЗ такое нет,
    //А для простой задачи писать лень;((
    protected static Car getFastestCar(ArrayList<Car> carsList) {
        Car car = new Car("name", -1);

        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).speed > car.speed) {
                car.speed = carsList.get(i).speed;
                car.name = carsList.get(i).name;
            }
        }
        return car;
    }
}
