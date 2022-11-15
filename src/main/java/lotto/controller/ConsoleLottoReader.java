package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.info.Price;

import java.util.List;

public class ConsoleLottoReader implements LottoReader {
    @Override
    public int readAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    @Override
    public List<Integer> readLottoNumber() {
        return null;
    }

    @Override
    public int readBonus() {
        return 0;
    }

    private void validateAmount(int amount) {
        if (amount % Price.SINGLE_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 원 단위여야 합니다.");
        }
    }
}
