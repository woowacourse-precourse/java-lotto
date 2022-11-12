package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class LottoManager {
    public int inputLottoCount() {
        String number = Console.readLine();
        if (number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    public void printLottoNumbers(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].getNumbers());
        }
    }

    public String inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
