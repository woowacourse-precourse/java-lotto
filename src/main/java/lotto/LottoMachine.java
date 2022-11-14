package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> lottoList = new ArrayList<>();

    public List<Lotto> buyLotto(int money) {
        int lottoCount = getCount(money);
        for(int i = 0; i < lottoCount; i++) {
            lottoList.add(createLotto());
        }
        print(lottoList);

        return lottoList;
    }

    public int getCount(int money) {
        return money / 1000;
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void print(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(lotto -> System.out.println(sortLotto(lotto.getNumbers())));
    }

    public List<Integer> sortLotto(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList<>();
        sortedLotto.sort(Comparator.naturalOrder());
        return sortedLotto;
    }
}
