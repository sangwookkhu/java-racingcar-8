package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    
    public void printResultHeader() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }
    
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }
    
    private void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car.getPosition());
        System.out.println();
    }
    
    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
    
    public void printWinners(List<String> winners) {
        System.out.print(WINNER_PREFIX + String.join(", ", winners));
    }
}
