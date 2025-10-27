package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIES_PROMPT = "시도할 횟수는 몇 회인가요?";
    
    public String readCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return Console.readLine();
    }
    
    public int readTries() {
        System.out.println(TRIES_PROMPT);
        String input = Console.readLine();
        
        try {
            int tries = Integer.parseInt(input);
            return tries;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
