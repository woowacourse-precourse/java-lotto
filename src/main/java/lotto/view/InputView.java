package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int moneyAmount(){
        System.out.println(INPUT_MONEY_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> lottoNumbers(){
        System.out.println(INPUT_LOTTO_NUMBERS);
        return splitLottoNumbers(Console.readLine());
    }

    public static int bonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> splitLottoNumbers(String lotto){
        return Arrays.stream(lotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
