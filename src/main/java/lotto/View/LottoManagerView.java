package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import java.util.List;
import static lotto.View.IOMessage.*;

public class LottoManagerView {
    public static String inputUserMoney(){
        System.out.println(GET_LOTTO_PRICE_MESSAGE);
        return Console.readLine();
    }

    public static void printIssuedLotto(int ticketNumber, List<Lotto> userLotto){
        System.out.println(String.valueOf(ticketNumber) + LOTTO_TICKET_NUMBER_MESSAGE);
        for(Lotto lotto: userLotto){
            System.out.println(lotto);
        }
    }

    public static String inputBonusNumber(){
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers(){
        System.out.println(GET_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static void printWinningHistory(List<Integer> record){
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(WinningState.MATCHING_THREE + String.valueOf(record.get(0)) + "개");
        System.out.println(WinningState.MATCHING_FOUR + String.valueOf(record.get(1)) + "개");
        System.out.println(WinningState.MATCHING_FIVE + String.valueOf(record.get(2)) + "개");
        System.out.println(WinningState.MATCHING_FIVE_WITH_BONUS + String.valueOf(record.get(3)) + "개");
        System.out.println(WinningState.MATCHING_SIX + String.valueOf(record.get(4)) + "개");
    }

    public static void printEarningRate(String earning){
        System.out.println(TOTAL_EARNING_RATE_MESSAGE + earning + "%입니다.");
    }
}
