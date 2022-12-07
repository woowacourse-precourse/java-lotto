package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.message.OutputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.util.message.OutputMessage.INPUT_WINNING_LOTTO;

public class InputView {
    public static int purchaseMoney(){
        System.out.println(INPUT_PURCHASE_AMOUNT.get());
        String purchaseMoney = Console.readLine();
        return numberCheck(purchaseMoney);
    }

    public static List<Integer> winningLotto() {
        System.out.println(INPUT_WINNING_LOTTO.get());
        String[] input = Console.readLine().split(",");
        List<Integer> winningLotto = listNumbersCheck(input);
        return winningLotto;
    }
    public static int numberCheck(String number){
        return InputValidator.validate(number);
    }

    public static List<Integer> listNumbersCheck(String[] arr){
        List<Integer> list = new ArrayList<>();
        for (String s : arr) {
            int number =  numberCheck(s);
            list.add(number);
        }
        return list;
    }
}
