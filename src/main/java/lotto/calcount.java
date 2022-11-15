package lotto;
import java.util.Collections;
import java.util.function.Function;

import static lotto.Winning.*;


public class calcount {
    public enum CALCOUNT{
        COR3("3개 일치 (5,000원) -",price->Collections.frequency(correctNumbers, 3)),
        COR4("4개 일치 (50,000원) -",price->Collections.frequency(correctNumbers, 4)),
        COR5("5개 일치 (1,500,000원) -",price->Collections.frequency(correctNumbers, 5)),
        bonusCor5("5개 일치, 보너스 볼 일치 (30,000,000원) -",price->0),
        COR6("6개 일치 (2,000,000,000원) -",price->Collections.frequency(correctNumbers, 6));

        private final String corEA;
        private final Function<Integer,Integer> earn;

        CALCOUNT(String corEA,Function<Integer,Integer> earn){
            this.corEA = corEA;
            this.earn = earn;
        }
        public String getEA(){
            return corEA;
        }
        public Integer earnMoney(String price){
            return earn.apply(Integer.valueOf(price));
        }
    }
}
