package lotto.View;

import lotto.Domain.Message;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(Message.INPUT_LOTTO_PURCHASE_AMOUNT);
        String ans = Console.readLine();
        return checkIsDigit(ans);
    }

    public static int checkIsDigit(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_IS_NOT_INT);
        }

    }

    public static List<Integer> getWinningNums() {
        System.out.println(Message.INPUT_LOTTO_WNNING_NUM_MESSAGE);
        String winningNumsInput = Console.readLine();

        List<Integer> winningNums = makeWinningNumsToList(winningNumsInput);
        Validator.checkIsValidWinningNums(winningNums);
        return winningNums;
    }

    private static List<Integer> makeWinningNumsToList(String winningNumsInput) {
        try {
            return Arrays.stream(winningNumsInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_VALID_WINNING_NUMS_INPUT);
        }
    }

    public static int getBonusNum() {
        try{
            System.out.println(Message.INPUT_LOTTO_BONUS_NUMS);
            return Integer.parseInt(Console.readLine());

        }catch(Exception e){
            throw new IllegalArgumentException(Message.ERROR_BONUS_NUM_TYPE);
        }
    }
}
