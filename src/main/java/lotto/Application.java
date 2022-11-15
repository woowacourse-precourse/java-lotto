package lotto;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.LottoTicket.*;
import static lotto.LottoNumbers.*;
import static lotto.Lotto.*;
import static lotto.LottoResult.*;


public class Application {
    public static void main(String[] args) {
        int cash = getLotteryTicketPrice();
        int tickets = countPaidLotteryTickets(cash);
        List<List<Integer>> ticketNumbers = paidLotteryNumberGenerator(tickets);
        List<Integer> winningNumbers = getLotteryWinningNumbers();
        int bonusNumber = getLotteryBonusNumber();

        Lotto lotto = new Lotto(winningNumbers,bonusNumber);
        lotto.inputValidity(winningNumbers,bonusNumber);

        lotteryStatistics(compareResult(winningNumbers, ticketNumbers, bonusNumber));

        int sum = sumOfAllPrizes(compareResult(winningNumbers, ticketNumbers, bonusNumber));
        double earningRatio = earningRatioCalculator(cash, sum);
        System.out.println("총 수익률은 " + earningRatio + "%입니다.");
    }
}
