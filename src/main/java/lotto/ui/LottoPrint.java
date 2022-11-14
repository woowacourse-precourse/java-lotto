package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.rank.Rank;

public class LottoPrint {
    private static final String BUY_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_PRIZE_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String BUY_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String LOTTO_STATS = "당첨 통계";

    public void buyLottoPrice() {
        System.out.println(BUY_LOTTO_PRICE);
    }

    public void prizeNumber() {
        System.out.println(REQUEST_PRIZE_NUMBERS);
    }

    public void bonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public void buyLotto(int count) {
        System.out.println(count + BUY_LOTTO_COUNT);
    }

    public void buyLottoNumbers(List<List<Integer>> buyNumbers) {
        for (List<Integer> numbers : buyNumbers) {
            System.out.println("numbers = " + numbers);
        }
    }

    public void stats(Map<Rank, Integer> prize) {
        System.out.println(LOTTO_STATS);
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            String msg = "";
            msg += "test" + "개 일치 (" + rank.getWinAmount() + "원) - " + prize.get(rank) + "개";
            System.out.println(msg);
        }
    }

    public void rate(double amount) {
        System.out.println("총 수익률은 " + amount + "%입니다.");
    }

}
