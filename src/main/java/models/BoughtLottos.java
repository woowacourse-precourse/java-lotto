package models;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class BoughtLottos {
    private List<Lotto> lottos;

    public BoughtLottos(int amount) {
        lottos = createLottos(amount);
    }

    private List<Lotto> createLottos(int amount) {

        List<Lotto> lottos = new ArrayList<>();

        for (; lottos.size() < amount; ) {
            lottos.add(createLottoNumbers());
        }

        return lottos;
    }

    private Lotto createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoConstant.NUMBER_START, LottoConstant.NUMBER_END, LottoConstant.NUMBERS_SIZE));
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAmount() {
        return lottos.size();
    }

    public void printLottoList() {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        lottos.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }
}
