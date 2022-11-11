package models;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class BoughtLottos {
    private List<Lotto> lottosData;

    public BoughtLottos(int amount) {
        lottosData = createLottos(amount);
    }

    private List<Lotto> createLottos(int amount) {

        List<Lotto> lottos = new ArrayList<>();

        for (; lottos.size() < amount; ) {
            lottos.add(createLottoNumbers());
        }

        return lottos;
    }

    private Lotto createLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstant.NUMBER_START, LottoConstant.NUMBER_END
                , LottoConstant.NUMBERS_SIZE));
    }

    public List<Lotto> getLottosData() {
        return lottosData;
    }

    public int getAmount() {
        return lottosData.size();
    }

    public void printLottoList() {
        System.out.println(String.format("%d개를 구매했습니다.", lottosData.size()));
        lottosData.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }
}
