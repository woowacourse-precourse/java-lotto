package lotto.view;

import lotto.model.Lotto;

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
}
