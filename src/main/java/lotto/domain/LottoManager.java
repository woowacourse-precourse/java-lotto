package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final LottoGenerator lottoGenerator;

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
    }

    public int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Lotto> createLottos(int count) {
        Lotto lotto;
        List<Integer> lottoNumbers;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers = lottoGenerator.createLottoNumbers();
            lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }
}
