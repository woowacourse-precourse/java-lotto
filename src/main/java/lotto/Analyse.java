package lotto;

import java.util.List;

public class Analyse {
    public static int containNumber(Lotto winLotto, Lotto buyLotto, int winBonus) {
        int result = 0;

        List<Integer> winNumber = winLotto.getLotto();
        List<Integer> buyNumber = buyLotto.getLotto();

        for(int i=0; i<buyNumber.size(); i++) {
            if(winNumber.contains(buyNumber.get(i))) {
                result++;
            }
        }

        if(result==5) {
            if(winNumber.contains(winBonus)) {
                result=7;
            }
        }

        return result;
    }
}
