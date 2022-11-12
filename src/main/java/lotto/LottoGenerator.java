package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            throw new IllegalArgumentException("1000으로 나누어 떨어지도록 해주세요.");
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(amount) / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        showAllLottos(lottos);
        return lottos;
    }

    public void changeToNumber(String numbers, String bonus) {
        String[] num = numbers.split(",");
        List<Integer> revertNumbers = new ArrayList<>();
        for(String n : num) {
            revertNumbers.add(Integer.parseInt(n));
        }
        winNumbers = new Lotto(revertNumbers);
        bonusNumber = Integer.parseInt(bonus);
    }

    private void showAllLottos(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            lotto.printSortedNumbers();
        }
    }
}
