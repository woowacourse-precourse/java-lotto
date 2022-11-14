package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.vo.LottoNumber;
import lotto.vo.PurchaseMoney;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    private static final String WINNING_NUMBERS_SPLIT_DELIMITER = ",";

    public static PurchaseMoney inputPurchaseMoney() {
        String input = Console.readLine();
        return convertInputPurchaseMoney(input);
    }

    private static PurchaseMoney convertInputPurchaseMoney(String input) {
        int money = Integer.parseInt(input);
        return new PurchaseMoney(money);
    }

    public static Set<LottoNumber> inputWinningNumbers() {
        String input = Console.readLine();
        return convertInputWinningNumbers(input);
    }

    private static Set<LottoNumber> convertInputWinningNumbers(String input) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        String[] numbers = input.split(WINNING_NUMBERS_SPLIT_DELIMITER);

        Arrays.stream(numbers)
                    .forEach(s -> {
                        int number = Integer.parseInt(s);
                        lottoNumbers.add(new LottoNumber(number));
                    });

        return lottoNumbers;
    }

    public static LottoNumber inputBonusNumber() {
        String input = Console.readLine();
        return convertInputBonusNumber(input);
    }

    public static LottoNumber convertInputBonusNumber(String input) {
        int number = Integer.parseInt(input);
        return new LottoNumber(number);
    }
}
