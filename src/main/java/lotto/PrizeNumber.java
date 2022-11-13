package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeNumber {
    THREE      ("3개 일치 (5,000원)", 0),
    FOUR       ("4개 일치 (50,000원)", 0),
    FIVE       ("5개 일치 (1,500,000원)", 0),
    FIVE_BONUS ("5개 일치, 보너스 볼 일치 (30,000,000원)", 0),
    SIX        ("6개 일치 (2,000,000,000원)", 0);

    private final String prizeString;
    private int numbers;

    PrizeNumber(String prizeString, int num) {
        this.prizeString = prizeString;
        this.numbers = num;
    }

    /**
     * set numbers
     * @param num set how many this state
     */
    public void setNum(int num) {
        this.numbers = num;
    }

    /**
     * get prizeString
     * @return String
     */
    public String prizeString() {
        return this.prizeString;
    }

    /**
     * get numbers
     * @return int
     */
    public int numbers() {
        return this.numbers;
    }

    private static final Map<Integer, PrizeNumber> BY_NUMBERS =
            Stream.of(values()).collect(Collectors.toMap(PrizeNumber::ordinal, Function.identity()));

    /**
     * get PrizeNumber with ordinal
     * @param sameNumber ordinal number
     * @return PrizeNumber
     */
    public static PrizeNumber getSameNumber(int sameNumber) {
        return BY_NUMBERS.get(sameNumber);
    }

}
