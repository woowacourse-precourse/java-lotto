package lotto.view;

import lotto.domain.PrizeMoney;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printException(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printLottoQuantity(int lottoQuantity) {
        System.out.println(String.valueOf(lottoQuantity) + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> purchaserLotto) {
        System.out.print("[");

        for (int i = 0; i < 6; i++) {
            System.out.print(purchaserLotto.get(i));
            if (i != 5) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public void printWinningHistory(Map<PrizeMoney, Integer> purchaserWinningHistory) {
        System.out.println("당첨 통계");
        purchaserWinningHistory.forEach((prizeMoney, countOfWinning) -> {
            String answer = prizeMoney.getCountOfMatch() + "개 일치";

            if (isSecond(prizeMoney)) {
                answer += ", 보너스 볼 일치 ";
            }
            answer += " (" + prizeMoney.getMoney() + "원) - " + countOfWinning + "개";

            System.out.println(answer);
        });
    }

    public void printRateReturn(String rateReturn) {
        System.out.println("총 수익률은 "+rateReturn+"%입니다.");
    }

    private boolean isSecond(PrizeMoney prizeMoney) {
        return prizeMoney.equals(PrizeMoney.SECOND);
    }
}
