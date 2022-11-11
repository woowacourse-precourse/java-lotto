package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.StringConstant;
import lotto.validation.LotteryWinningNumberValidation;
import lotto.validation.LottoMoneyValidation;
import lotto.validation.Validation;
import lotto.view.LotteryWinningNumberView;
import lotto.view.LottoBuyView;
import lotto.view.View;

public class LottoController {

    /**
     * 사용자에게 money 를 입력받고 validation 후 돈을 기억해둔다.
     * 사용자에게 LotteryWinningNumber 를 입력받고 validation 후 기억해둔다.
     */
    public void lottoProcedure() {
        int userMoney = userMoney();
        List<Integer> lotteryWinningNumber = lotteryNumber();
    }


    private static int userMoney() {
        String userLottoBuyMoney = inputUserLottoBuyMoney();
        moneyValidation(userLottoBuyMoney);
        return Integer.parseInt(userLottoBuyMoney);
    }

    private static String inputUserLottoBuyMoney() {
        View lottoBuyView = new LottoBuyView();
        lottoBuyView.show();
        return lottoBuyView.getResponse();
    }

    private static void moneyValidation(String userLottoBuyMoney) {
        Validation lottoMoneyValidation = new LottoMoneyValidation();
        lottoMoneyValidation.isValidate(userLottoBuyMoney);
    }

    private static List<Integer> lotteryNumber() {
        String userInput = inputUserLottoWinningNumbers();
        lotteryNumberValidation(userInput);
        return createLottoNumber(userInput);
    }

    private static String inputUserLottoWinningNumbers() {
        View lotteryWinningNumberView = new LotteryWinningNumberView();
        lotteryWinningNumberView.show();
        return lotteryWinningNumberView.getResponse();
    }

    private static void lotteryNumberValidation(String userInput) {
        Validation validation = new LotteryWinningNumberValidation();
        validation.isValidate(userInput);
    }

    private static List<Integer> createLottoNumber(String userInput) {
        String[] userWinningLottoInput = userInput.split(",");
        return Arrays.stream(userWinningLottoInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
