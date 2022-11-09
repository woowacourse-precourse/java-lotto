package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    
    private static int money;
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> purchase() {
        List<Lotto> lotteryTickets = new ArrayList<>();
        
        System.out.println("구입금액을 입력해 주세요.");
        getMoney();

        System.out.println();

        while(money > 0) {
            lotteryTickets.add(publishLotteryTicket());
            money -= LOTTO_PRICE;
        }

        printLotteryTickets(lotteryTickets);

        return lotteryTickets;
    }

    private static void getMoney() {
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }

        validate();
    }

    private static void validate() {
        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 나뉘지 않습니다");
        }
    }

    private static Lotto publishLotteryTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private static void printLotteryTickets(List<Lotto> lotteryTickets) {
        System.out.println(lotteryTickets.size() + "개를 구매했습니다.");
        for(Lotto lotto : lotteryTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
