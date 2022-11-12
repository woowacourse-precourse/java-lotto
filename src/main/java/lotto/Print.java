package lotto;

import constant.Prize;

import java.util.List;
import java.util.Map;

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

        for (Map.Entry<Prize, Integer> prizeAndCount : lottoStatics.entrySet()) {
            out(String.format("%s - %d개", prizeAndCount.getKey().getDescription(), prizeAndCount.getValue()));
        }
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
