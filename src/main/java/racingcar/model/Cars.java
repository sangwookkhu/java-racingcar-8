package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            validateAndAddCar(carList, name);
        }

        return carList;
    }

    private void validateAndAddCar(List<Car> carList, String name) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 빈 이름이 포함되어 있습니다.");
        }
        carList.add(new Car(trimmedName));
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomValue = randomNumberGenerator.generate();
            car.move(randomValue);
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return findWinnersByPosition(maxPosition);
    }

    private List<String> findWinnersByPosition(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}