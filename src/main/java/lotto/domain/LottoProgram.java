package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants.LOTTO;
import lotto.Display;


public class LottoProgram {

    private static final Buyer buyer = new Buyer();

    public static void init() throws IllegalArgumentException {
        inputPayment();
        inputWinningNumbers();
        inputBonusNumber();
        Generator.calculateRank(buyer);
        Display.winningResults(buyer);
        Display.profitResult(buyer);
    }

    private static void inputPayment() {
        Display.inputPayment();
        String paymentInput = Console.readLine();
        Validator.payment(paymentInput);

        int payment = Integer.parseInt(paymentInput);
        buyer.setTotalPurchaseAmout(payment);

        Display.lineChange();

        int numbersOfLotto = payment / LOTTO.PRICE;
        buyer.setLottoPurchasedCount(numbersOfLotto);
        Display.paidAmout(numbersOfLotto);

        purchasedLottoSave();
    }

    private static void inputWinningNumbers() {
        Display.inputWinningNumbers();
        String winningNumbers = Console.readLine();
        Validator.winningNumberFormat(winningNumbers);

        Integer[] numberArray = convertToInteger(winningNumbers);
        Validator.winningNumberDuplicate(numberArray);

        Lotto.setWinningNumbers(Arrays.asList(numberArray));

    }

    private static void inputBonusNumber() {
        Display.inputBonusNumber();
        String bonusNumber = Console.readLine();
        Validator.bonusNumber(bonusNumber);

        Lotto.setBonusNumber(Integer.parseInt(bonusNumber));
    }

    private static void purchasedLottoSave() {
        int count = buyer.getLottoPurchasedCount();

        for (int lottoCount = 0; lottoCount < count; lottoCount++) {
            List<Integer> purchasedLottoNumber = new ArrayList<Integer>(
                    Randoms.pickUniqueNumbersInRange(LOTTO.START, LOTTO.END, LOTTO.SIZE)
            );
            purchasedLottoNumber.sort(Comparator.naturalOrder());
            Display.lottoNumbers(purchasedLottoNumber);
            buyer.setLottoPurchased(new Lotto(purchasedLottoNumber));
        }
    }

    private static Integer[] convertToInteger(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
    }
}
