package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatch;
import lotto.ui.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoGenerator generator;
    private final LottoCalculator calculator;

    public LottoController() {
        this.generator = new LottoGenerator();
        this.calculator = new LottoCalculator();
    }

    public List<Lotto> create(String price) {
        return generator.generate(price);
    }

    public Map<LottoMatch, Integer> calWinningPrize(List<Lotto> lottoPacks, String winingNumber, String bonusNumber) {
        LottoValidator.validateBonusNumberDuplication(winingNumber, bonusNumber);

        List<Integer> winningNumbers = Arrays.stream(winingNumber.split(",")).map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());

        return calculator.calWinningPrize(lottoPacks, winningNumbers, Integer.valueOf(bonusNumber));
    }

    public Double calEarningRate(String price, Map<LottoMatch, Integer> matchedCount) {
        return calculator.calEarningRate(Integer.valueOf(price), matchedCount);
    }
}
