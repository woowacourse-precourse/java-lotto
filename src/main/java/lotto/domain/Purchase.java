package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Print.*;
import static lotto.domain.Input.*;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static int amount;
    private static List<Lotto> lottos;
    private static WinningNumber winningNumber;

    public static void buyLotto() {
        inputAmount();

        createLottos();
        printLottos(lottos);

        inputNumbers();
        inputBonusNumber();
    }

    /**
     * 로또 구입 금액을 입력받는 메서드
     */
    private static void inputAmount() {
        printInputPurchaseAmount();
        amount = inputPurchaseAmount();
    }

    /**
     * 입력 받은 금액 만큼의 로또를 생성하는 메서드
     */
    private static void createLottos() {
        int numberOfLotto = amount / LOTTO_PRICE;
        lottos = new ArrayList<>();

        while (numberOfLotto-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }
    }

    /**
     * 당첨 번호를 입력받는 메서드
     */
    private static void inputNumbers() {
        printInputWinningNumber();
        winningNumber = new WinningNumber(inputWinningNumbers());
    }

    /**
     * 보너스 번호를 입력받는 메서드
     */
    private static void inputBonusNumber() {
        printInputBonusNumber();
        System.out.println(Input.inputBonusNumber());
    }
}
