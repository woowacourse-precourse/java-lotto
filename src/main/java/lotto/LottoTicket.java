package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoTicket {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NUMBERS_ONLY = " 숫자만 입력해 주세요.";
    private static final String NO_CHANGE = " 잔돈이 발생합니다.";
    private static final String TOO_LITTLE_MONEY = " 로또의 최소 가격은 1000원 입니다.";
    public static int getLotteryTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String cash = Console.readLine();
        if (!cash.matches("[0-9]+")){
            System.out.println(ERROR_MESSAGE+NUMBERS_ONLY);
            throw new IllegalArgumentException(ERROR_MESSAGE+NUMBERS_ONLY);
        }
        int price = Integer.parseInt(cash);
        return price;
    }

    public static int countPaidLotteryTickets(int totalCash) {
        int ticketPrice = 1000;
        int ticketCount;
        if (totalCash % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE+NO_CHANGE);
        }
        if (totalCash < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE+TOO_LITTLE_MONEY);
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
