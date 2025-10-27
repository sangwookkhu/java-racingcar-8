package racingcar.controller;

import java.util.List;
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
        try {
            String carNames = inputView.readCarNames();
            int tries = inputView.readTries();
            
            Cars cars = new Cars(carNames);
            RacingGame racingGame = new RacingGame(cars, tries);
            
            racingGame.run();
            
            outputView.printResultHeader();
            printRaceResults(racingGame);
            
            List<String> winners = racingGame.getWinners();
            outputView.printWinners(winners);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
    private void printRaceResults(RacingGame racingGame) {
        List<List<racingcar.model.Car>> raceHistory = racingGame.getRaceHistory();
        for (List<racingcar.model.Car> cars : raceHistory) {
            outputView.printRoundResult(cars);
        }
    }
}
