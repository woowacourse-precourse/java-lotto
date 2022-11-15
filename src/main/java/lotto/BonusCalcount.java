package lotto;

import java.util.Collections;
import java.util.function.Function;

import static lotto.Winning.correctNumbers;

public class BonusCalcount {
    public enum BONUS_CALCOUNT{
        COR3("3개 일치 (5,000원) -",price-> Collections.frequency(correctNumbers, 3)),
        COR4("4개 일치 (50,000원) -",price->Collections.frequency(correctNumbers, 4)),
        COR5("5개 일치 (1,500,000원) -",price->0),
        bonusCor5("5개 일치, 보너스 볼 일치 (30,000,000원) -",price->(Collections.frequency(correctNumbers, 5))),
        COR6("6개 일치 (2,000,000,000원) -",price->Collections.frequency(correctNumbers, 6));

        private final String corBonusEA;
        private final Function<Integer,Integer> Bonusearn;

        BONUS_CALCOUNT(String corBonusEA,Function<Integer,Integer> Bonusearn){
            this.corBonusEA = corBonusEA;
            this.Bonusearn = Bonusearn;
        }

        public String getBonusEA(){
            return corBonusEA;
        }
        public Integer earnBonusMoney(String price){
            return Bonusearn.apply(Integer.valueOf(price));
        }
    }
}
