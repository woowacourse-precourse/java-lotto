package lotto.domain;

public class LottoGenerator {
    int generateCount;
    // List<Integer> numbers;
    public LottoGenerator(int money) {
        try {
            if (checkMoneyUnit(money)) {
                generateCount = money / 1000;
            }
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR");
        }
    }

    private Boolean checkMoneyUnit(int money) throws IllegalArgumentException {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }


}
