package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static Shop shop;

    private Shop() {}

    public static Shop getInstance() {
        if (shop == null) {
            shop = new Shop();
        }

        return shop;
    }

    public List<Lotto> saleLottery() {
        List<Lotto> lotteryTickets = publishLotteryTicket(chargeMoney());

        showLotteryTickets(lotteryTickets);

        return lotteryTickets;
    }

    private int chargeMoney() {
        int money = 0;

        System.out.println("구입금액을 입력해 주세요.");

        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }

        validate(money);

        return money;
    }

    private void validate(int money) {
        if (money % LottoConstant.PRICE.value > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 나뉘지 않습니다");
        }
    }

    private List<Lotto> publishLotteryTicket(int money) {
        List<Lotto> lotteryTickets = new ArrayList<>();

        while (money > 0) {
            lotteryTickets.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(
                            LottoConstant.START_NUMBER.value,
                            LottoConstant.END_NUMBER.value,
                            LottoConstant.NUMBER_COUNT.value
                    )));

            money -= LottoConstant.PRICE.value;
        }

        return lotteryTickets;
    }

    private void showLotteryTickets(List<Lotto> lotteryTickets) {
        System.out.println();
        System.out.println(lotteryTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lotteryTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
