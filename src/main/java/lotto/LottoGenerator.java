package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class LottoGenerator {

    private static Lotto winNumbers;
    private static int bonusNumber;
    private Judge judge;

    public LottoGenerator() {
        this.judge = new Judge();
    }

    public List<Lotto> createLottoNumbers(String amount) {
        if(!judge.correctAmount(amount)) {
            throw new IllegalArgumentException(Errors.NOT_CORRECT_AMOUNT.getName());
        }
        Notice.BUY_MESSAGE.buy(Integer.parseInt(amount) / 1000);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(amount) / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        showAllLottos(lottos);
        return lottos;
    }

    public Lotto changeToNumber(String numbers) {
        judge.isAllNumber(numbers);
        String[] num = numbers.split(",");
        List<Integer> revertNumbers = new ArrayList<>();
        for(String n : num) {
            revertNumbers.add(Integer.parseInt(n));
        }
        return new Lotto(revertNumbers);
    }

    private void showAllLottos(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            lotto.printSortedNumbers();
        }
    }
}
