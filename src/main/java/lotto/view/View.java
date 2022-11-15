package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.Messages.*;

public class View {
    public String startLottoView(){
        System.out.println(LOTTO_BUY_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public void lottoListView(LottoTickets lottoTickets){
        int lottoCount = lottoTickets.length();
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
        for(int i = 0; i < lottoCount; i++){
            System.out.println(lottoTickets.getLottoTickets().get(i).getLottoNumber());
        }
    }

    public String winningNumberInputView(){
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public String bonusNumberInputView(){
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public void resultView(int[] result, double rateOfReturn){
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.printf(Rank.FIFTH.getMessage(), result[Rank.FIFTH.getCount()]);
        System.out.printf(Rank.FOURTH.getMessage(), result[Rank.FOURTH.getCount()]);
        System.out.printf(Rank.THIRD.getMessage(), result[Rank.THIRD.getCount()]);
        System.out.printf(Rank.SECOND.getMessage(), result[Rank.SECOND.getCount()]);
        System.out.printf(Rank.FIRST.getMessage(), result[Rank.FIRST.getCount()]);
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

}
