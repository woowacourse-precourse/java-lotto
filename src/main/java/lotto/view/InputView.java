package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import static lotto.exception.InputException.bonusException;
import static lotto.exception.InputException.inputMoneyException;
import static lotto.service.LottoService.stringToIntList;

public class InputView {
    public static int inputMoney() throws IllegalArgumentException {
        System.out.print("로또 구입 금액을 입력하시오 : ");
        return inputMoneyException(Console.readLine());
    }

    public static Lotto inputLottoNumber() throws IllegalArgumentException {
        System.out.print("당첨 번호를 입력하시오 : ");
        Lotto lotto;
        lotto = new Lotto(stringToIntList(Console.readLine()));
        return lotto;
    }

    public static int inputBonusNumber() throws IllegalArgumentException {
        System.out.print("보너스 번호를 입력하시오 : ");
        return bonusException(Console.readLine());
    }
}

