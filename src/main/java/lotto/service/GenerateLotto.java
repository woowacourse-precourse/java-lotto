package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenerateLotto {

    private final OutputService outputService = new OutputService();

    public List<Lotto> generateLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        outputService.printAmount(amount);
        for(int i=0;i<amount;i++) {
            Lotto lotto = new Lotto(generateNumbers());
            outputService.printLotto(lotto.getNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private List<Integer> generateNumbers() {
        List<Integer> random = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(random);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
