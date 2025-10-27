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
        String positionString = repeatString("-", car.getPosition());
        System.out.println(car.getName() + " : " + positionString);
    }

    private String repeatString(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNER_PREFIX + String.join(", ", winners));
    }
}