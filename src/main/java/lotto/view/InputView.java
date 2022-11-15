package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.exception.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String REGEX = ",";
    private static final String LINE = System.lineSeparator();
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = LINE + "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = LINE + "보너스 번호를 입력해 주세요.";

    public int inputPrice(){
        System.out.println(INPUT_PRICE);
        int price = Validator.validateInt(Console.readLine());
        Validator.validatePrice(price);
        return price;
    }

    public List<Integer> inputLottoNumbers(){
        System.out.println(INPUT_LOTTO_NUMBERS);
        String lottoNumbers = Console.readLine();
        Validator.validateLottoNumbers(lottoNumbers);
        Validator.validateDifferentLottoNumbers(splitNumbers(lottoNumbers));
        return splitNumbers(lottoNumbers);
    }

    public int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    private List<Integer> splitNumbers(final String numbersText) {
        return Arrays.stream(numbersText.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
