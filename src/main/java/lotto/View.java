package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.User;
import lotto.domain.WinningCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {
    
    public void showWinCase(WinningCount winningCount) {
        System.out.println(Constant.WINNING_STATS);
        System.out.println("---");
        System.out.println(Constant.THREE_MATCH + winningCount.getCount().get(Constant.FIFTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FOUR_MATCH + winningCount.getCount().get(Constant.FOURTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_MATCH + winningCount.getCount().get(Constant.THIRD_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_BONUS_MATCH + winningCount.getCount().get(Constant.SECOND_PLACE) + Constant.PIECE);
        System.out.println(Constant.SIX_MATCH + winningCount.getCount().get(Constant.FIRST_PLACE) + Constant.PIECE);
    }

    public void showProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
