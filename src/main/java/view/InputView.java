package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String SPLIT_REGEX = ",";





    public static String inputMoneyView() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return inputMoney(Console.readLine());
    }
    public static List<Integer> inputWinningNumberView(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return inputLottoNumbers();
    }
    public static int inputBonusNumberView(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputBonusNumber();
    }

    private static String inputMoney(String input) {
        return input;
    }

    private static List<Integer> inputLottoNumbers(){
        String[] split = Console.readLine().split(SPLIT_REGEX);
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int inputBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
