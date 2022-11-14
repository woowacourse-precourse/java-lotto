package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoTickets;

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

}
