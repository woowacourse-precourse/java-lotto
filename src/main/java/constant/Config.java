package constant;

public class Config {
    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;
    public static final int INIT_COUNT = 0;
    public static final String RANGE_ERROR = String.format("로또 번호는 %d~%d 범위여야 합니다.", MIN_NUMBER, MAX_NUMBER);

    private Config() {

    }
}
