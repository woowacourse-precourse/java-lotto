package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    MISS(0),;
    
    private final int countOfSameLottoNumber;
    
    LottoRank(final int countOfSameLottoNumber) {
        this.countOfSameLottoNumber = countOfSameLottoNumber;
    }
    
    public static LottoRank parseRank(final int countOfSameLottoNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> isCountOfSameLottoNumberSame(countOfSameLottoNumber, lottoRank))
                .findAny()
                .orElse(MISS);
    }
    
    private static boolean isCountOfSameLottoNumberSame(final int countOfSameLottoNumber, final LottoRank lottoRank) {
        return lottoRank.countOfSameLottoNumber == countOfSameLottoNumber;
    }
}
