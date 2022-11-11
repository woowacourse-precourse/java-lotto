package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int LOTTO_PRICE = 1000;


    public List<Lotto> buyLotto(int money) {

        int lottoAmount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {

            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);

        }

        return lottos;
    }

    public void printLottosInfo(List<Lotto> lottos) {

        int amount = lottos.size();
        System.out.println(amount+"개를 구매했습니다.");

        for (int i = 0; i < amount; i++) {
            Lotto lotto = lottos.get(i);
            lotto.printNumbers();

        }
    }


}
