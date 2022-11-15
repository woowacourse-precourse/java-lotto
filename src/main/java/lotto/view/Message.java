package lotto.view;

import lotto.model.Grade;
import lotto.model.Lotto;

import java.text.NumberFormat;
import java.util.Map;

public class Message {

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void countLotto(int countLotto) {
        System.out.printf("%n%d개를 구매했습니다.%n", countLotto);
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }

    public void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void startResult() {
        System.out.println("\n당첨 결과\n---");
    }

    public void printResult(Map<Grade, Integer> lottoResult) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.printf("3개 일치 (%s원) - %d개%n", numberFormat.format(Grade.FIFTH_PRIZE.getReward()), lottoResult.getOrDefault(Grade.FIFTH_PRIZE, 0));
        System.out.printf("4개 일치 (%s원) - %d개%n", numberFormat.format(Grade.FORTH_PRIZE.getReward()), lottoResult.getOrDefault(Grade.FORTH_PRIZE, 0));
        System.out.printf("5개 일치 (%s원) - %d개%n", numberFormat.format(Grade.THIRD_PRIZE.getReward()), lottoResult.getOrDefault(Grade.THIRD_PRIZE, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", numberFormat.format(Grade.SECOND_PRIZE.getReward()), lottoResult.getOrDefault(Grade.SECOND_PRIZE, 0));
        System.out.printf("6개 일치 (%s원) - %d개%n", numberFormat.format(Grade.FIRST_PRIZE.getReward()), lottoResult.getOrDefault(Grade.FIRST_PRIZE, 0));
    }
}
