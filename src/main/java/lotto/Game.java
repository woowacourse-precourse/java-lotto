package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    static UI ui = new UI();
    static Validation validation = new Validation();
    static int purchase;
    static Lotto winningNumber;
    static List<Lotto> lottos;
    static int bonusNumber;
    static final int LOTTO_PRICE = 1000;

    static void setPurchase(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        purchase = Integer.parseInt(input);
        validation.checkDividable(purchase);
    }

    static int getLottoCount() {
        return (purchase / LOTTO_PRICE);
    }

    static void generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < getLottoCount(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    static void setWinningNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkWinningFormat(input);
        List<Integer> number = new ArrayList<>();
        for (String token : input.split(",")) {
            number.add(Integer.parseInt(token));
        }
        winningNumber = new Lotto(number);
    }

    static void setBonusNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        bonusNumber = Integer.parseInt(input);
        validation.checkNumberInRange(bonusNumber);
        validation.checkBonusDuplicate(winningNumber, bonusNumber);
    }

}
