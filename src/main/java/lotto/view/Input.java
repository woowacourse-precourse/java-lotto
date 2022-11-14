package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String userInput = Console.readLine();
        int purchaseAmount = Integer.parseInt(userInput);
        return purchaseAmount;
    }

    public static List<Integer> inputWinLottoNumbers() {
        System.out.println(INPUT_WIN_LOTTO_NUMBERS_MESSAGE);
        String userInput = Console.readLine();
        return stringToIntegerList(userInput);
    }

    public static int inputWinLottoBonusNumber() {
        System.out.println(INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        int bonusNumber = Integer.parseInt(userInput);
        return bonusNumber;
    }

    private static List<Integer> stringToIntegerList(String string) {//문자열 ,기준으로 정수 리스트로 변환
        List<String> stringList = Stream.of(string.split("\\s*,\\s*"))
                .collect(Collectors.toList());
        List<Integer> integerList = stringList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return integerList;
    }
}
