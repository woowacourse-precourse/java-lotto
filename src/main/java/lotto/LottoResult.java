package lotto;

public enum LottoResult {


    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FOURTH(50000L),
    FIFTH(5000L),
    NOTHING(0L);

    LottoResult(Long compensation) {
    }
}
