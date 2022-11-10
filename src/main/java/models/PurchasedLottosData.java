package models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchasedLottosData {

    private List<Lotto> purchasedLottosData;
    private int amount;


    public PurchasedLottosData(int amount) {
        purchasedLottosData = createLottos(amount);
        this.amount = amount;
    }

    private List<Lotto> createLottos(int amount) {

        List<Lotto> lottos = new ArrayList<>();

        for (; lottos.size() < amount; ) {
            lottos.add(createLottoNumbers());
        }
        return lottos;

    }

    private Lotto createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;

    }

    public void printLottoList() {
        System.out.println(String.format("%d개를 구매했습니다.", purchasedLottosData.size()));
        //purchasedLottosData.forEach((lotto) -> System.out.println(Arrays.asList(lotto.getNumbers())));
        purchasedLottosData.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottosData;
    }

    public int getAmount() {
        return amount;
    }
}
