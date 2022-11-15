package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final List<Lotto> lottoes;

    public Purchase(int money) {
        this.lottoes = buyLottoes(money);
    }

    private List<Lotto> buyLottoes(int money) {
        List<Lotto> lottoes = new ArrayList<>();
        int lottoAmount = getLottoAmount(money);

        //TODO: 메서드 이름 추후에 한번 더 고민해보자.
        createLottoes(lottoes, lottoAmount);

        return lottoes;
    }

    private void createLottoes(List<Lotto> lottoes, int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
    }

    private int getLottoAmount(int money) {
        return money / 1000;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
