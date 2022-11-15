package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoUser;
import lotto.util.converter.LottoInputConverter;

import java.util.List;

import static lotto.domain.Lotto.LottoNumberValidator.isLottoNumberOutOfRange;
import static lotto.exception.ExceptionType.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.ExceptionType.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.util.ConstValue.LottoConst.*;

public class LottoObjectManager {

    private final LottoInputConverter inputConverter;

    public LottoObjectManager() {
        inputConverter = new LottoInputConverter();
    }

    public LottoUser createLottoUser() {
        System.out.println(USER_LOTTO_PURCHASE_INPUT_MESSAGE);
        final String input = Console.readLine();
        final int purchaseCost = inputConverter.userLottoPurchaseCostToInt(input);

        final LottoUser lottoUser = new LottoUser(purchaseCost);
        showPurchaseLottoMessage(purchaseCost);

        return lottoUser;
    }

    private void showPurchaseLottoMessage(final int purchaseCost) {
        System.out.println(purchaseCost / LOTTO_BASIC_COST + USER_LOTTO_PURCHASE_TAIL_MESSAGE);
    }

    public Lotto createWinningLotto() {
        System.out.println(LOTTO_MAIN_NUMBER_INPUT_MESSAGE);
        final String input = Console.readLine();
        final List<Integer> winningLottoNumbers = inputConverter.winningLottoNumberToList(input);
        return new Lotto(winningLottoNumbers);
    }

    public int createBonusNumber(final Lotto winningLotto) {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        final String input = Console.readLine();
        final int bonusNumber = inputConverter.bonusLottoNumberToInt(input);
        validateBonusNumberOutOfRange(bonusNumber);
        validateBonusNumberExistsWinningLotto(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumberOutOfRange(final int bonusNumber) {
        if (isLottoNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusNumberExistsWinningLotto(final Lotto winningLotto, final int bonusNumber) {
        if (winningLotto.existsMatchingNumber(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }
}
