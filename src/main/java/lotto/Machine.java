package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Machine {
    private final List<Lotto> lottoList = new ArrayList<>();

    public List<Lotto> buy(int amount) {
        int lottoCount = getCount(amount);
        for (int count = 0; count < lottoCount; count++) {
            lottoList.add(createLotto());
        }
        print(lottoList);

        return lottoList;
    }

    public int getCount(int amount) {
        return amount / 1000;
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    private void print(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(lotto -> System.out.println(sortNumber(lotto.getNumbers())));
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
