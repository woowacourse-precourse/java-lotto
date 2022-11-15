package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    THREE(5_000,3,-1),
    FOUR(50_000,4,-1),
    FIVE(1_500_000,5,0),
    FIVE_BONUS(30_000_000,5,1),
    SIX(2_000_000_000,6,-1),
    LOSING(0,0,-1);

    private final int prize;
    private final int sixLottoNumber;
    private final int bonusLottoNumber;

    LottoResult(int prize,int sixLottoNumber, int bonusLottoNumber){
        this.prize = prize;
        this.sixLottoNumber = sixLottoNumber;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public int getPrize(){
        return prize;
    }

    public static LottoResult fromSix(int sixLottoNumber){
        return Arrays.stream(LottoResult.values())
                .filter(it -> it.sixLottoNumber == sixLottoNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LottoResult fromBonus(int bonusLottoNumber){
        return Arrays.stream(LottoResult.values())
                .filter(it -> it.bonusLottoNumber == bonusLottoNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
