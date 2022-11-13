package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.constant.IntConstant;
import lotto.constant.LottoResultConstant;
import lotto.constant.StringConstant;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoResultService;
import lotto.service.UserLottoService;
import lotto.service.YieldService;
import lotto.validation.BonusLottoValidation;
import lotto.validation.LotteryWinningNumberValidation;
import lotto.validation.Validation;
import lotto.view.View;

public class LottoController {

    private static final LottoResultService lottoResultService= new LottoResultService();
    private static final YieldService yieldService = new YieldService();
    /**
     * 사용자에게 money 를 입력받고 validation 후 돈을 기억해둔다. 사용자에게 LotteryWinningNumber 를 입력받고 validation 후 기억해둔다. 사용자에게
     * BonusLottoNumber 를 입력받고 validation 후 기억해둔다.
     */
    public void lottoProcedure() {
        Optional<Money> money = getUserMoneyWithValidation();
        if (money.isEmpty()) {
            return;
        }
        Money userMoney = money.get();
        int lottoCount = calculateLottoCountWithOutputView(userMoney);
        List<Lotto> userLotto = createUserLottoWithOutputView(lottoCount);

        Optional<Lotto> winningLotto = getWinningLottoWithValidation();
        if (winningLotto.isEmpty()) {
            return;
        }
        Lotto lotteryWinningNumber = winningLotto.get();
//
//        String bonusLotto = getBonusLottoWithValidation(winningLotto);
//
//        Map<LottoResultConstant, Integer> result = lottoResultService.getResult(userLotto,
//                getWinningLotto(winningLotto), getBonusLotto(bonusLotto));
//        printUserLottoAndUserYield(result, Integer.parseInt(userMoneyInput));
    }

    private Optional<Money> getUserMoneyWithValidation() {
        String userMoneyInput = View.printViewWithUserInput(StringConstant.MONEY_INPUT_MESSAGE.getMessage());
        try {
            Money lottoMoney = new Money(userMoneyInput);
            return Optional.of(lottoMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
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

    private Optional<Lotto> getWinningLottoWithValidation() {
        String userLottoWinningInput = View.printViewWithUserInput(
                StringConstant.WINNING_LOTTERY_NUMBER_INPUT_MESSAGE.getMessage());
        try {
            return Optional.of(new Lotto(ifNumericThenReturnDesirableForm(userLottoWinningInput)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private List<Integer> ifNumericThenReturnDesirableForm(String userInput) {
        try {
            return Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void lottoMoneyInputValidation(String userInput) {
        Validation lottoMoneyValidation = createLottoMoneyValidation();
        userInputValidation(lottoMoneyValidation, userInput);
    }

    private Validation createLottoMoneyValidation() {
        return new LottoMoneyValidation();
    }

    private void userInputValidation(Validation validation, String userInput) {
        validation.isValidate(userInput);
    }

    private String lottoWinningNumberView() {
        View lottoWinningNumberView = createLottoWinningNumberView();
        return printViewAndReturnInput(lottoWinningNumberView);
    }

    private View createLottoWinningNumberView() {
        return new LotteryWinningNumberView();
    }

    private void winningLottoInputValidation(String userLottoWinningInput) {
        Validation winningLottoInputValidation = createWinningLottoInputValidation();
        userInputValidation(winningLottoInputValidation, userLottoWinningInput);
    }

    private Validation createWinningLottoInputValidation() {
        return new LotteryWinningNumberValidation();
    }

    private String getBonusLottoWithValidation(String winningLotto) {
        String userBonusLottoInput = bonusLottoView();
        bonusLottoInputValidation(userBonusLottoInput, winningLotto);
        return userBonusLottoInput;
    }

    private String bonusLottoView() {
        View bonusLottoView = createBonusLottoView();
        return printViewAndReturnInput(bonusLottoView);
    }

    private View createBonusLottoView() {
        return new BonusLottoView();
    }

    private void bonusLottoInputValidation(String userBonusLottoInput, String lotteryWinningNumber) {
        Validation bonusLottoInputValidation = createBonusLottoInputValidation();
        List<Integer> lottoNumber = createLottoNumber(lotteryWinningNumber);
        bonusLottoInputValidation.isValidate(userBonusLottoInput, lottoNumber);
    }

    private Validation createBonusLottoInputValidation() {
        return new BonusLottoValidation();
    }

    private static List<Integer> createLottoNumber(String userInput) {
        String[] userWinningLottoInput = userInput.split(",");
        return Arrays.stream(userWinningLottoInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private List<Integer> getWinningLotto(String winningLotto) {
        String[] userWinningLottoInput = winningLotto.split(",");
        return Arrays.stream(userWinningLottoInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusLotto(String bonusLotto) {
        return Integer.parseInt(bonusLotto);
    }

    private void printUserLottoAndUserYield(Map<LottoResultConstant, Integer> result, int userMoney) {
        double yieldPercent = yieldService.calculateYield(result, userMoney);
        String yieldPercentOneDot = String.format("%.1f", yieldPercent);
        View userLottoView = new UserLottoView();
        List<String> userResult = createResult(result, yieldPercentOneDot);
        userResult.add("총 수익률은 " + yieldPercentOneDot + "%입니다.");
        userLottoView.setPrintElement(userResult);
        userLottoView.show();
    }

    private List<String> createResult(Map<LottoResultConstant, Integer> result, String yieldPercentOneDot) {
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
