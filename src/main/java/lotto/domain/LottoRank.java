package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

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
    
    public static LottoRank parseRank(final int countOfSameLottoNumber, final boolean existBonusLottoNumber) {
        if (isSecondRank(countOfSameLottoNumber, existBonusLottoNumber)) {
            return SECOND;
        }
        
        return Arrays.stream(values())
                .filter(Predicate.not(LottoRank::isSecond))
                .filter(lottoRank -> isCountOfSameLottoNumberSame(lottoRank, countOfSameLottoNumber))
                .findAny()
                .orElse(MISS);
    }
    
    private static boolean isSecondRank(final int countOfSameLottoNumber, final boolean existBonusLottoNumber) {
        return isCountOfMatchingLottoNumberSame(SECOND, countOfSameLottoNumber) && existBonusLottoNumber;
    }
    
    private boolean isSecond() {
        return this == SECOND;
    }
    
    private static boolean isCountOfSameLottoNumberSame(final LottoRank lottoRank, final int countOfSameLottoNumber) {
        return isCountOfMatchingLottoNumberSame(lottoRank, countOfSameLottoNumber);
    }
    
    private static boolean isCountOfMatchingLottoNumberSame(final LottoRank second, final int countOfSameLottoNumber) {
        return second.countOfSameLottoNumber == countOfSameLottoNumber;
    }
}
