package lotto.model;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.utils.Calculator.calculateLottoRank;
import static lotto.utils.LottoNumberGenerator.generateLottoNumber;
import static lotto.validator.MoneyValidator.hasValidUnit;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int paidMoney;
    private final List<Lotto> lottos;

    public Customer(
            int paidMoney
    ) {
        hasValidUnit(paidMoney);
        this.paidMoney = paidMoney;
        this.lottos = generateLottos(paidMoney);
    }

    private List<Lotto> generateLottos(int paidMoney) {
        List<Lotto> result = new ArrayList<>();
        while (result.size() < (paidMoney / LOTTO_PRICE)) {
            result.add(new Lotto(generateLottoNumber()));
        }
        return result;
    }

    public List<Rank> judgeLottoRanks(List<Integer> winningNumber, int bonusNumber) {
        List<Rank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoRanks.add(calculateLottoRank(lotto, winningNumber, bonusNumber));
        }
        return lottoRanks;
    }

    public String getAllLottoToString() {
        StringBuilder buffer = new StringBuilder("");
        for (Lotto lotto : lottos) {
            buffer.append(lotto.toString()).append("\n");
        }
        return buffer.toString();
    }
}
