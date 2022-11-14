package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Ui {

    public int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        ChangeNumberType changeNumberType = new ChangeNumberType(moneyInput);

        return changeNumberType.getNumber();
    }

    public List<Integer> lottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        ChangeNumberType changeNumberType = new ChangeNumberType(lottoInput);

        return changeNumberType.getNumbers();
    }

    public int bonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        ChangeNumberType changeNumberType = new ChangeNumberType(bonusInput);

        return changeNumberType.getNumber();
    }
}
