package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.LottoMachine;
import lotto.domain.Referee;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        Referee.Compare(LottoMachine.pickLottoNumbers(inputCash()), inputWinningNumbers());
    }

    public static int inputCash() {
        int countLotto;

        System.out.println("구입금액을 입력해 주세요.");
        countLotto = Cash.countPurchaseQuantity(Console.readLine());
        System.out.println(countLotto + "개를 구매했습니다.");
        return countLotto;
    }

    public static List<List<String>> inputWinningNumbers() {
        List<List<String>> winningNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers.add(LottoMachine.getWinningNumbers(Console.readLine()));
        System.out.println("보너스 번호를 입력해 주세요.");
        winningNumbers.add(LottoMachine.getBonusNumber(Console.readLine()));
        Exceptions.compareWinningNumbersWithBonusNumbers(winningNumbers);
        return winningNumbers;
    }

}


















