package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoUser;
import lotto.util.converter.LottoInputConverter;

import java.util.List;

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
}
