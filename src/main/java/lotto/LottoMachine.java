package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos = new ArrayList<>();

    public void buyLottos(int count) {
        for (int idx = 0; idx < count; idx++) {
            lottos.add(new Lotto(Utils.pickUnique6Numbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoBuyCount(int paidMoney) {
        return paidMoney / LottoInfo.PRICE.getValue();
    }

    public List<Integer> getWinningNumbers(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        return numbers;
    }

    public int getBonusNumber(int number) {
        if (number < LottoInfo.START_NUMBER.getValue() || number > LottoInfo.END_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
