package racingcar.model;

public class RandomNumberGenerator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    
    public int generate() {
        return (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1)) + MIN_VALUE;
    }
}
