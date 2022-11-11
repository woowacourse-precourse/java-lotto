package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.global.ExceptionConstants.CANNOT_DUPLICATED_NUMBER;
import static lotto.global.ExceptionConstants.CANNOT_SATISFY_NUMBER_RANGE;
import static lotto.global.ExceptionConstants.CAN_ONLY_INPUT_NUMBER;
import static lotto.global.LottoConstants.LOTTO_PRICE;

public class InputUtil {

    public static final String WINNING_NUMBER_DELIM = ",";

    private static List<Integer> winningNumbers;

    public static long inputLottoPurchaseAmount() {

        PrintUtil.printInsertMoney();

        long purchasePrice = Long.parseLong(Console.readLine());

        InputValidator.isAllNumber(purchasePrice);

        InputValidator.isZero(purchasePrice);

        InputValidator.restEqualZero(purchasePrice, LOTTO_PRICE);

        return purchasePrice;
    }

    public static Lotto inputWinningLottoNumber() {

        PrintUtil.printInsertLottoNumber();

        winningNumbers = Stream.of(Console.readLine().split(WINNING_NUMBER_DELIM))
                               .map(Integer::parseInt)
                               .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public static Integer inputBounsLottoNumber() {

        PrintUtil.printInsertBounsNumber();

        int bounsNumber = Integer.parseInt(Console.readLine());

        InputValidator.isAllNumber(bounsNumber);

        if (winningNumbers.contains(bounsNumber)) {
            throw new IllegalArgumentException(CANNOT_DUPLICATED_NUMBER);
        }

        InputValidator.isRangeTrue(bounsNumber);

        return bounsNumber;
    }
}
