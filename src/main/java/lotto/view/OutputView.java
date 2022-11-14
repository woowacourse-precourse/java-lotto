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
}
