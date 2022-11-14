package lotto.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.IntConstant;
import lotto.constant.LottoResultConstant;
import lotto.constant.StringConstant;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoResultService;
import lotto.service.UserLottoService;
import lotto.service.YieldService;
import lotto.view.View;

public class LottoController {

    /**
     * 사용자에게 money 를 입력받고 validation 후 돈을 기억해둔다. 사용자에게 LotteryWinningNumber 를 입력받고 validation 후 기억해둔다. 사용자에게
     * BonusLottoNumber 를 입력받고 validation 후 기억해둔다.
     */
    public void lottoProcedure() {
        Money money = getUserMoneyWithValidation();
        int lottoCount = calculateLottoCountWithOutputView(money);

        List<Lotto> userLotto = createUserLottoWithOutputView(lottoCount);
        Lotto winningLotto = getWinningLottoWithValidation();

        WinningLotto lotteryWinningNumber = getBonusLottoWithValidationAndCreateWinningLotto(
                winningLotto);

        printResult(money, userLotto, lotteryWinningNumber);
    }

    private Money getUserMoneyWithValidation() {
        String userMoneyInput = View.printViewWithUserInput(StringConstant.MONEY_INPUT_MESSAGE.getMessage());
        return new Money(userMoneyInput);
    }

    private int calculateLottoCountWithOutputView(Money userMoney) {
        int lottoCount = userMoney.moneyDivideBy(IntConstant.LOTTO_MONEY_PER_ONE.getValue());
        View.printView(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private List<Lotto> createUserLottoWithOutputView(int lottoCount) {
        List<Lotto> userLotto = UserLottoService.createLottoNumber(lottoCount);
        List<String> userLottoResult = userLotto.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        View.printView(userLottoResult);
        return userLotto;
    }

    private Lotto getWinningLottoWithValidation() {
        String userLottoWinningInput = View.printViewWithUserInput(
                StringConstant.WINNING_LOTTERY_NUMBER_INPUT_MESSAGE.getMessage());
        return new Lotto(ifNumericThenReturnDesirableForm(userLottoWinningInput));


    }

    private List<Integer> ifNumericThenReturnDesirableForm(String userInput) {
        try {
            return Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private WinningLotto getBonusLottoWithValidationAndCreateWinningLotto(Lotto winningLotto) {
        String userInput = View.printViewWithUserInput(StringConstant.BONUS_LOTTO_INPUT_MESSAGE.getMessage());
        return new WinningLotto(winningLotto, getBonusLotto(userInput));
    }

    private int getBonusLotto(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    StringConstant.BONUS_LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void printResult(Money money, List<Lotto> userLotto, WinningLotto lotteryWinningNumber) {
        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(userLotto,
                lotteryWinningNumber);
        printUserLottoAndUserYield(result, money);
    }

    private void printUserLottoAndUserYield(Map<LottoResultConstant, Integer> result, Money userMoney) {
        double yieldPercent = YieldService.calculateYield(result, userMoney);
        DecimalFormat format = new DecimalFormat("###,###.#");
        String percentString = format.format(yieldPercent);
        List<String> viewResult = createResult(result);
        viewResult.add("총 수익률은 " + percentString + "%입니다.");
        View.printView(viewResult);
    }

    private List<String> createResult(Map<LottoResultConstant, Integer> result) {
        List<String> resultView = new ArrayList<>();
        createResultView(resultView, LottoResultConstant.CORRECT_THREE, result);
        createResultView(resultView, LottoResultConstant.CORRECT_FOUR, result);
        createResultView(resultView, LottoResultConstant.CORRECT_FIVE, result);
        createResultView(resultView, LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS, result);
        createResultView(resultView, LottoResultConstant.CORRECT_SIX, result);
        return resultView;
    }

    private static void createResultView(List<String> resultView, LottoResultConstant lottoResultConstant,
                                  Map<LottoResultConstant, Integer> result) {
        resultView.add(
                lottoResultConstant.getResultString() + result.get(lottoResultConstant)+"개");
    }

}
