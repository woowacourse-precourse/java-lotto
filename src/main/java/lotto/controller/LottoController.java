package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.BonusLottoValidation;
import lotto.validation.LotteryWinningNumberValidation;
import lotto.validation.LottoMoneyValidation;
import lotto.validation.Validation;
import lotto.view.BonusLottoView;
import lotto.view.LotteryWinningNumberView;
import lotto.view.LottoBuyView;
import lotto.view.View;

public class LottoController {


    /**
     * 사용자에게 money 를 입력받고 validation 후 돈을 기억해둔다.
     * 사용자에게 LotteryWinningNumber 를 입력받고 validation 후 기억해둔다.
     * 사용자에게 BonusLottoNumber 를 입력받고 validation 후 기억해둔다.
     */
    public void lottoProcedure() {
        String userMoneyInput = lottoMoneyInputView();
        lottoMoneyInputValidation(userMoneyInput);
        int userMoney = Integer.parseInt(userMoneyInput);

        String userLottoWinningInput = lottoWinningNumberView();
        winningLottoInputValidation(userLottoWinningInput);
        List<Integer> lotteryWinningNumber = createLottoNumber(userLottoWinningInput);

        String userBonusLottoInput = bonusLottoView();
        bonusLottoInputValidation(userBonusLottoInput, lotteryWinningNumber);
        int bonusLotto = Integer.parseInt(userBonusLottoInput);
    }

    private String bonusLottoView() {
        View bonusLottoView = createBonusLottoView();
        return printViewAndReturnInput(bonusLottoView);
    }

    private View createBonusLottoView() {
        return new BonusLottoView();
    }

    private void bonusLottoInputValidation(String userBonusLottoInput, List<Integer> lotteryWinningNumber) {
        Validation bonusLottoInputValidation = createBonusLottoInputValidation();
        bonusLottoInputValidation.isValidate(userBonusLottoInput, lotteryWinningNumber);
    }

    private Validation createBonusLottoInputValidation() {
        return new BonusLottoValidation();
    }

    private String lottoMoneyInputView() {
        View lottoMoneyView = createLottoMoneyView();
        return printViewAndReturnInput(lottoMoneyView);
    }

    private View createLottoMoneyView() {
        return new LottoBuyView();
    }

    private String printViewAndReturnInput(View view) {
        view.show();
        return view.getResponse();
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

    private static List<Integer> createLottoNumber(String userInput) {
        String[] userWinningLottoInput = userInput.split(",");
        return Arrays.stream(userWinningLottoInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
