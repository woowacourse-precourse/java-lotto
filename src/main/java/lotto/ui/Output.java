package lotto.ui;

import lotto.domain.Lotto;
import lotto.service.CoincideNumber;

import java.util.List;

public class Output {
    private enum Phrases {
        MONEY("구입금액을 입력해 주세요."),
        AMOUNT("%d개를 구매했습니다."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINSTATISTICS("당첨 통계\n---"),
        NUMBER("%d개"),
        REVENUE("총 수익률은 %.1f%%입니다.");

        private final String msg;

        Phrases(String msg) {
            this.msg = msg;
        }
    }

    public void moneyInform() {
        System.out.println(Phrases.MONEY.msg);
    }

    public void amount(int amount) {
        System.out.println(String.format(Phrases.AMOUNT.msg, amount));
    }

    public void lottoHistory(List<Lotto> history) {
        for (Lotto numbers : history) {
            System.out.println(numbers.getNumbers());
        }
    }

    public void winningNum() {
        System.out.println(Phrases.WINNING_NUMBER.msg);
    }

    public void bonusNum() {
        System.out.println(Phrases.BONUS_NUMBER.msg);
    }


    public void winStatistics() {
        System.out.println(Phrases.WINSTATISTICS.msg);
        for (CoincideNumber coincideNumber : CoincideNumber.values()) {
            System.out.println(coincideNumber.phrase() + String.format(Phrases.NUMBER.msg, coincideNumber.count()));
        }
    }


    public void revenue(double revenue) {
        System.out.println(String.format(Phrases.REVENUE.msg, revenue));
    }
}