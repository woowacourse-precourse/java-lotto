package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Manager {
    private List<List<Integer>> purchasedLottos;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int TOTAL_NUM = 6;

    public Manager() {
        purchasedLottos = new ArrayList<>();
    }

    private int purchase() throws IllegalArgumentException {
        System.out.println("구입 금액을 입력해주세요.");
        String amountInput = Console.readLine().trim();
        validateAmountInput(amountInput);
        return Integer.parseInt(amountInput) / 1000;
    }

    public void validateAmountInput(String amountInput) throws IllegalArgumentException {

        int amount;

        try {
            amount = Integer.parseInt(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 금액은 숫자여야 합니다.");
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 로또 한 장은 1000원 입니다. 1000원 단위의 숫자를 입력해주세요.");
        }
    }
}
