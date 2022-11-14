package lotto.view;

import static lotto.util.Message.*;
import static lotto.util.Util.*;

import lotto.Entity.Lotto;
import lotto.Entity.ResultLotto;
import lotto.util.MatchMoney;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public void showUserLotto(List<Lotto> list){
        System.out.println(String.format(BUY_COUNT, list.size()));
        for(Lotto lotto : list){
            System.out.println(transLottoNumbersToForm(lotto.getNumbers()));
        }
    }

    public void showTotalResult(ResultLotto resultLotto, int buyMoney){
        System.out.println(RESULT_LOTTO);
        String output;
        DecimalFormat df = new DecimalFormat("###,###");
        for(MatchMoney matchMoney : resultLotto.getMap().keySet()){
            String format = df.format(matchMoney.getPrice());
            String message = selectMessage(matchMoney);
            output = String.format(message,matchMoney.getMatchNumber(), format, resultLotto.getMap().get(matchMoney));
            System.out.println(output);
        }
        System.out.println(String.format(RESULT_YEILD, resultLotto.calYield(buyMoney)));
    }

    public String selectMessage(MatchMoney matchMoney){
        if(matchMoney.getBonus()){
            return RESULT_MATCH_;
        }
        return RESULT_MATCH;
    }
}
