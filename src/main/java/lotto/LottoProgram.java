package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.Constants.ERROR;
import lotto.Constants.PRINT;
import lotto.Constants.REGEX;
import lotto.domain.Buyer;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class LottoProgram {

    private static Buyer buyer = new Buyer();
    public static void init() throws IllegalArgumentException {
        Display.inputPayment();
        String paymentInput = Console.readLine();
        Validator.payment(paymentInput);

        int payment = Integer.parseInt(paymentInput);

        buyer.setTotalPurchaseAmout(payment);

        Display.lineChange();

        int numbersOfLotto = payment / 1000;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        Display.paidAmout(numbersOfLotto);

        purchasedLottoSave();
        Display.inputWinningNumbers();
        String winningNumbers = Console.readLine();
        Validator.winningNumberFormat(winningNumbers);


        Integer[] numberArray = convertToInteger(winningNumbers);
        Validator.winningNumberDuplicate(numberArray);

        Lotto.setWinningNumbers(Arrays.asList(numberArray));

        Display.inputBonusNumber();
        String bonusNumber = Console.readLine();
        Validator.bonusNumber(bonusNumber);

        Lotto.setBonusNumber(Integer.parseInt(bonusNumber));

        Generator.calculateRank(buyer);

        Display.winningResults(buyer);
    }

    private static void purchasedLottoSave() {
        int count = buyer.getLottoPurchasedCount();
        for (int lottoCount = 0; lottoCount < count; lottoCount++) {
            List<Integer> purchasedLottoNumber = new ArrayList<Integer>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottoNumber.sort(Comparator.naturalOrder());
            System.out.println(purchasedLottoNumber);
            buyer.setLottoPurchased(new Lotto(purchasedLottoNumber));
        }
    }

    private static Integer[] convertToInteger(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt((number) -> {
                    try {
                        int parsedInt = Integer.parseInt(number);
                        return parsedInt;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                })
                .boxed()
                .toArray(Integer[]::new);
    }
}
