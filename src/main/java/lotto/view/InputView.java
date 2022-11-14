package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.util.IntConverter;
import lotto.util.MoneyConverter;
import lotto.util.WinningLottoNumberConverter;

import java.util.NoSuchElementException;

public class InputView {
    private static final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "[ERROR] 입력값이 비었습니다.";

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        return MoneyConverter.convert(money);
    }

    public static WinningNumber inputWinningNumber(){
        return new WinningNumber(inputWinningLottoNumber(), inputWinningBonusNumber());
    }

    private static Lotto inputWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningLottoNumber = readLine();
        return WinningLottoNumberConverter.convert(winningLottoNumber);
    }

    private static int inputWinningBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String winningBonusNumber = readLine();
        return IntConverter.convert(winningBonusNumber);
    }

    private static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        }
    }
}
