package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class LottoService {

    private final int lottoPrice = 1000;

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);
        int amount = calculateAmount(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    public WinningResult makeWinningResult(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Rank> ranks = lottos.stream().map(
                (lotto) -> Rank.valueOf(winningLotto.match(lotto), winningLotto.checkBonus(lotto)))
                .collect(Collectors.toList());
        return new WinningResult(ranks, lottoPrice);
    }

    private int calculateAmount(int money) {
        return money / lottoPrice;
    }

    private Lotto makeLotto() {
        List<Integer> lottoNumbers = LottoNumbersGenerator.generate();
        return new Lotto(lottoNumbers);
    }

    private void validateMoney(int money) {
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] %d원 단위의 금액을 입력해주세요.", lottoPrice));
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수만 입력해주세요.");
        }
    }

}
