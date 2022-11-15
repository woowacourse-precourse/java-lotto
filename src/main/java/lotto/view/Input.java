package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.CheckInput;

public class Input {
    public static String getYourMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        // 예외처리 필요. 1000 단위로 나눠떨어지는지, 음수는 아닌지
        return Console.readLine();
    }

    public static List<Integer> getAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // 예외처리 필요 1~45숫자의 사이가 맞는지, 6개가 맞는지.
        String inputValue = Console.readLine();

        List<String> inputValues = Stream.of(inputValue.split(","))
            .collect(Collectors.toList());

        for (String value : inputValues) {
            CheckInput.checkInputLotto(value);
        }

        List<Integer> numbers = inputValues.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        CheckInput.checkInputLottoLength(numbers);
        CheckInput.checkInputLottoDuplicate(numbers);
        return numbers;
    }

    public static int getBonusNumber(List<Integer> LottoNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String value = Console.readLine();
        CheckInput.checkInputLotto(value);
        CheckInput.checkInputBonusDuplicate(LottoNumber, Integer.parseInt(value));
        return Integer.parseInt(value);
    }

}
