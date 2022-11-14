package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<List<Integer>> createLottos(int money) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            numbers.add(lottoRepository.save(lotto));
        }
        return numbers;
    }

}
