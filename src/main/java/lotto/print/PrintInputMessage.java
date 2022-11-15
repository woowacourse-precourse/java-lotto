package lotto.print;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintInputMessage {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WRONG_DATA_TYPE = "[ERROR] 입력한 값이 숫자가 아닙니다.";
    private static final String PRINT_DUPLICATE_ERROR = "[ERROR] 겹치는 로또 숫자가 있습니다.";




    public static int getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        try {
            String inputMoney = Console.readLine();
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_WRONG_DATA_TYPE);
        }
    }

    public static List<Integer> getWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER);
        String inputTmpNum = Console.readLine();
        List<String> inputWinningNum = Arrays.asList(inputTmpNum.split(","));
        return  inputWinningNum.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static int getBonusLottoNumber(List<Integer> getWinningLottoNum) {
        System.out.println();
        System.out.println(INPUT_BONUS_LOTTO_NUMBER);
        int getBonusNum = Integer.parseInt(Console.readLine());
        if(getWinningLottoNum.contains(getBonusNum)) {
            throw new IllegalArgumentException(PRINT_DUPLICATE_ERROR);
        }
        try {
            return getBonusNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_WRONG_DATA_TYPE);
        }
    }
}
