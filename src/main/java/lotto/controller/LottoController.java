package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistic;
import lotto.service.LottoService;
import lotto.type.LottoInformation;
import lotto.validator.integrated.BonusNumberInputValidator;
import lotto.validator.integrated.PurchaseAmountInputValidator;
import lotto.validator.integrated.WinningNumberInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public final class LottoController {

    private final LottoService lottoService;
    private final BonusNumberInputValidator bonusNumberInputValidator;
    private final PurchaseAmountInputValidator purchaseAmountInputValidator;
    private final WinningNumberInputValidator winningNumberInputValidator;

    public LottoController(LottoService lottoService,
        BonusNumberInputValidator bonusNumberInputValidator,
        PurchaseAmountInputValidator purchaseAmountInputValidator,
        WinningNumberInputValidator winningNumberInputValidator) {
        this.lottoService = lottoService;
        this.bonusNumberInputValidator = bonusNumberInputValidator;
        this.purchaseAmountInputValidator = purchaseAmountInputValidator;
        this.winningNumberInputValidator = winningNumberInputValidator;
    }

    public void play() {
        long purchaseAmount = getPurchaseAmount();

        List<Lotto> lottos = getLottos(purchaseAmount);
        LottoOutputView.outputLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        LottoStatistic statistic = lottoService.makeStatistic(lottos, purchaseAmount,
            winningNumbers, bonusNumber);
        LottoOutputView.outputLottoStatistic(statistic);
    }

    private long getPurchaseAmount() {
        String purchaseAmountInput = LottoInputView.inputPurchaseAmount();
        purchaseAmountInputValidator.validate(purchaseAmountInput);
        return Long.parseLong(purchaseAmountInput);
    }

    private List<Lotto> getLottos(final long purchaseAmount) {
        int size = (int) (purchaseAmount / LottoInformation.SMALLEST_UNIT.value());
        return lottoService.createLottos(size);
    }

    private List<Integer> getWinningNumbers() {
        String winningNumbersInput = LottoInputView.inputWinningNumbers();
        List<String> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
            .collect(Collectors.toList());
        winningNumberInputValidator.validate(winningNumbers);
        return winningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private int getBonusNumber() {
        String bonusNumberInput = LottoInputView.inputBonusNumber();
        bonusNumberInputValidator.validate(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

}
