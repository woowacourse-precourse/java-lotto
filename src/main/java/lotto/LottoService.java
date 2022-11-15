package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    public WinningResult makeWinningResult(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Rank> ranks = lottos.stream().map(
                (lotto) -> Rank.valueOf(winningLotto.match(lotto), winningLotto.checkBonus(lotto)))
                .collect(Collectors.toList());
        return new WinningResult(ranks, lottoPrice);
    }
}
