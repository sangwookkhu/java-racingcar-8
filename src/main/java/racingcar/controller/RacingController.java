package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String carNames = inputView.readCarNames();
        int tries = inputView.readTries();

        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, tries);

        racingGame.run();

        outputView.printResultHeader();
        printRaceResults(racingGame);

        List<String> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }

    private void printRaceResults(RacingGame racingGame) {
        List<List<Car>> raceHistory = racingGame.getRaceHistory();
        for (List<Car> cars : raceHistory) {
            outputView.printRoundResult(cars);
        }
    }
}