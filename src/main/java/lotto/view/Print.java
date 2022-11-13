package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;

public class Print {

    public void requestPurchasePrice() {
        out("구입금액을 입력해 주세요.");
    }

    public void lottoNumbers(List<Lotto> lottos) {
        blank();
        out(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            out(lotto.toString());
        }
    }

    public void requestWinLottoNumber() {
        blank();
        out("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        blank();
        out("보너스 번호를 입력해 주세요.");
    }

    public void statics(Map<Prize, Integer> lottoStatics) {
        blank();
        out("당첨 통계");
        out("---");

        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        for (Map.Entry<Prize, Integer> prizeAndCount : lottoStatics.entrySet()) {
            Prize prize = prizeAndCount.getKey();

            out(String.format("%d개 일치%s (%s원) - %d개",
                    prize.getMatch(), bonusText(prize), numberFormat.format(prize.getMoney()),
                    prizeAndCount.getValue()));
        }
    }

    private String bonusText(Prize prize) {
        if (prize.isBonus()) {
            return ", 보너스 볼 일치";
        }

        return "";
    }

    public void yield(double profits) {
        out(String.format("총 수익률은 %.1f%%입니다.", profits));
    }

    public void out(String text) {
        System.out.println(text);
    }

    private void blank() {
        System.out.println();
    }
}
