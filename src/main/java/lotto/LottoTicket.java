package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoTicket {
    public static int getLotteryTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.\n");
        String cash = Console.readLine();
        if (!cash.matches("[0-9]+")){
            String message = "[ERROR] 숫자만 입력해 주세요.\n";
            System.out.printf("%s", message);
            throw new IllegalArgumentException(message);
        }
        int price = Integer.parseInt(cash);
        return price;
    }

    public static int countPaidLotteryTickets(int totalCash) {
        int ticketPrice = 1000;
        int ticketCount;
        if (totalCash % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잔돈이 발생합니다.");
        }
        if (totalCash < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또의 최소 가격은 1000원 입니다.");
        }
        ticketCount = totalCash / ticketPrice;
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
        return ticketCount;
    }

    public static List<List<Integer>> paidLotteryNumberGenerator(int numberOfPaidLottery) {

        List<List<Integer>> allOfLotteryNumbers = new ArrayList<>();
        List<Integer> lotteryNumbers = new ArrayList<>();
        for (int ticketIndex = 0; ticketIndex < numberOfPaidLottery; ticketIndex++) {
            lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedLotteryNumbers = new ArrayList<>(lotteryNumbers);
            Collections.sort(sortedLotteryNumbers);
            allOfLotteryNumbers.add(sortedLotteryNumbers);
            System.out.println(allOfLotteryNumbers.get(ticketIndex));
        }

        return allOfLotteryNumbers;
    }

}
