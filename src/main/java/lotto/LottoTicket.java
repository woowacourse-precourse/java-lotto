package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    public static int getLotteryTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.\n");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    public static int countPaidLotteryTickets(int totalCash) {
        int ticketPrice = 1000;
        int ticketCount;
        if (totalCash % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잔돈이 발생합니다.");
        }
        ticketCount = totalCash / ticketPrice;
        return ticketCount;
    }
    public static List<List<Integer>> paidLotteryNumberGenerator(int numberOfPaidLottery){

        List<List<Integer>> allOfLotteryNumbers = new ArrayList<>();
        for(int ticketIndex=0; ticketIndex<numberOfPaidLottery; ticketIndex++){
            allOfLotteryNumbers.add(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(allOfLotteryNumbers.get(ticketIndex));

        }
        System.out.printf("%d개를 구매했습니다.\n",numberOfPaidLottery);

        for(int i=0; i<numberOfPaidLottery; i++){
            System.out.println(allOfLotteryNumbers.get(i));
        }

        return allOfLotteryNumbers;
    }

}
