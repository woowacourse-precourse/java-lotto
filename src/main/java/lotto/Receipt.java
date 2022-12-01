package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import java.util.LinkedList;
import java.util.List;

import static lotto.LottoConfiguration.START_NUMBER;
import static lotto.LottoConfiguration.END_NUMBER;
import static lotto.LottoConfiguration.PRICE;
import static lotto.LottoConfiguration.SIZE;

public class Receipt {
    private final int money;
    private final int amount;

    public Receipt(int money) {
        validate(money);
        this.money = money;
        amount = money / 1000;
    }

    private void validate(int money) {
        if (money <= 0 || money % PRICE != 0) {
            throw new MyIllegalArgumentException(ErrorCode.MONEY_ERROR);
        }
    }

    public List<Lotto> buy() {
        List<Lotto> lottos = new LinkedList<Lotto>();
        List<Integer> numbers;
        for (int i = 0; i < amount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public void printReceipt() {
        System.out.println(amount + "개를 구매했습니다.");
    }
}
