package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private List<Integer> generateLottoNumbers(int startFrom, int endTo, int size) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startFrom, endTo, size);
        Collections.sort(numbers);
        return numbers;
    }

    private int countPurchaseQuantity(int money) {
        if (Math.floorMod(money, LottoConstant.PRICE.getValue()) != 0) {
            throw new IllegalArgumentException();
        }
        else if (Math.floorDiv(money, LottoConstant.PRICE.getValue()) == 0) {
            throw new IllegalArgumentException();
        }

        return Math.floorDiv(money, LottoConstant.PRICE.getValue());
    }

    private int readPurchaseAmount() {
        try {
            int money = Integer.valueOf(Console.readLine());
            if (money < 0) {
                throw new IllegalArgumentException();
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
