package lotto;

import java.util.List;

public class SystemMessage {
    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
        System.out.println();
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}