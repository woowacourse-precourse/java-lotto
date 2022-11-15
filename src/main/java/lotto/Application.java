package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            LottoStatistics statistics = new LottoStatistics();
            statistics.setStatistics();
            statistics.start();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
