package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MIN_TRIES = 1;
    
    private final Cars cars;
    private final int tries;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<List<Car>> raceHistory;
    
    public RacingGame(Cars cars, int tries) {
        validateTries(tries);
        this.cars = cars;
        this.tries = tries;
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.raceHistory = new ArrayList<>();
    }
    
    private void validateTries(int tries) {
        if (tries < MIN_TRIES) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
    
    public void run() {
        for (int i = 0; i < tries; i++) {
            cars.moveAll(randomNumberGenerator);
            raceHistory.add(new ArrayList<>(cars.getCars()));
        }
    }
    
    public List<List<Car>> getRaceHistory() {
        return raceHistory;
    }
    
    public List<String> getWinners() {
        return cars.getWinners();
    }
}
