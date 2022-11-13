package lotto;

import camp.nextstep.edu.missionutils.Console;

public class lottoTicket {
    public static int getLotteryTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.\n");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    public static int countLotteryTickets(int totalCash) {
        int ticketPrice = 1000;
        int ticketCount;
        if (totalCash % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잔돈이 발생합니다.");
        }
        ticketCount = totalCash / ticketPrice;
        return ticketCount;
    }
}
