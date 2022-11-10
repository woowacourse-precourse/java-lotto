package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageConstant.INPUT_LOTTO_NUMBERS;
import static constant.MessageConstant.INPUT_PRICE;
import static constant.MessageConstant.INPUT_BONUS_NUMBER;

public enum InputView {
    INSTANCE;

    public int inputPrice(){
        System.out.println(INPUT_PRICE);
        int price = InputValidator.validateInt(Console.readLine());
        InputValidator.validatePrice(price);
        return price;
    }

    public List<Integer> inputLottoNumbers(){
        System.out.println(INPUT_LOTTO_NUMBERS);
        String lottoNumbers = Console.readLine();
        InputValidator.validateLottoNumbers(lottoNumbers);
        InputValidator.validateDifferentLottoNumbers(splitNumbers(lottoNumbers));
        return splitNumbers(lottoNumbers);
    }

    public int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    private List<Integer> splitNumbers(final String numbersText) {
        return Arrays.stream(numbersText.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
