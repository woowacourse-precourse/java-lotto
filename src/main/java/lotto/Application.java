package lotto;

import java.util.List;

import static lotto.LottoTicket.*;
import static lotto.LottoNumbers.*;
import static lotto.Lotto.*;
import static lotto.LottoResult.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = getLotteryTicketPrice();
        int tickets = countPaidLotteryTickets(price);
        List<List<Integer>> ticketNumbers = paidLotteryNumberGenerator(tickets);
        List<Integer> winningNumbers =getLotteryWinningNumbers();
        int bonusNumber = getLotteryBonusNumber();

        lotteryStatistics(compareResult(winningNumbers,ticketNumbers,bonusNumber)); ;
        int sum = sumOfAllPrizes(compareResult(winningNumbers,ticketNumbers,bonusNumber));
        earningRatioCalculator(price,sum);


    }

}
