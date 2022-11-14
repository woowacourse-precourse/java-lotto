package lotto;

import java.util.Arrays;

public enum LottoRanking {
    ETC(0, 0),
    FIFTH_PLACE(3, 5000),
    FOURTH_PLACE(4, 50000),
    THIRD_PLACE(5, 1500000),
    SECOND_PLACE(5, 30000000),
    FIRST_PLACE(6, 2000000000);
    private int match;
    private int price;
    private LottoRanking(int match, int price){
        this.match = match;
        this.price = price;
    }

    public static LottoRanking findByMatchingInformation(int match, boolean hasBonusNumber){
        if(hasBonusNumber && match == SECOND_PLACE.match){
            return SECOND_PLACE;
        }
        return Arrays.stream(LottoRanking.values())
                        .filter(lottoRanking -> lottoRanking != SECOND_PLACE && lottoRanking.match == match)
                        .findAny()
                        .orElse(ETC);
    }

    public int getMatch(){
        return match;
    }
    public int getPrice(){
        return price;
    }
}
