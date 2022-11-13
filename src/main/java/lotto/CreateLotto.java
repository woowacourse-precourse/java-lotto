package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class CreateLotto {
    final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    public List<Integer> createRandomBall() {
        return numbers;
    }

    public List<Integer> winningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String a : inputWinningNumber.split(",")) {
            winningNumber.add(Integer.parseInt(a));
        }
        return winningNumber;
    }

    public String inputWinningNumber() {
        return Console.readLine();
    }

    public Integer bonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }

    public Integer Money(String Money) {
        return Integer.parseInt(Money);
    }

    public String inputMoney() {
        return Console.readLine();
    }

    public void textWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public void textBounsNumber() {
        System.out.println("보너스 번호를 입력해주세요");
    }

}
