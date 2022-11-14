package lotto.domain;

import java.util.Arrays;

public enum LottoGrade {

    fifth(5_000,3,false),
    fourth(50_000,4,false),
    third(1_500_000,5,false),
    second(30_000_000,5,true),
    first(2_000_000_000, 6,false);

    private int prize;
    private int correct;
    private boolean bonus;
    LottoGrade(int prize, int correct, boolean bonus) {
        this.prize = prize;
        this.correct = correct;
        this.bonus = bonus;
    }

    public static LottoGrade getLottoGrade(int correctOfLotto, boolean bonus){

        for(LottoGrade lottoGrade : values()){
            if(correctOfLotto==5 && bonus){
                return LottoGrade.second;
            }
            if(lottoGrade.correct == correctOfLotto){
                return lottoGrade;
            }
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrect() {
        return correct;
    }
}
