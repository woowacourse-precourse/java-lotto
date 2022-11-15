package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoInputFilter {

    private static LottoValidator validator = LottoValidator.getInstance();

    public static List<Integer> readLottoNumber() {
        System.out.println("로또 번호를 입력해 주세요.");
        List<Integer> lottoNumber = new ArrayList<>();
        String input = Console.readLine();
        String[] inputSplit = input.split(",");

        for (String numberString : inputSplit) {
            if (!validator.isPositiveInteger(numberString)) {
                System.out.println(ErrorMessage.NON_POSITIVE_INTEGER_VALUE.getMessage());
                throw new IllegalArgumentException();
            }
            int number = Integer.valueOf(numberString);
            if (!validator.isValidRange(number)){
                System.out.println(ErrorMessage.INVALID_RANGE.getMessage());
                throw new IllegalArgumentException();
            }
            lottoNumber.add(number);
        }

        if (!validator.isValidSize(lottoNumber)) {
            System.out.println(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
            throw new IllegalArgumentException();
        }
        if (validator.isDuplicated(lottoNumber)) {
            System.out.println(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
        return lottoNumber;
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        if (!validator.isPositiveInteger(input)) {
            System.out.println(ErrorMessage.NON_POSITIVE_INTEGER_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        int bonusNumber = Integer.valueOf(input);
        if (!validator.isValidRange(bonusNumber)) {
            System.out.println(ErrorMessage.INVALID_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!validator.isPositiveInteger(input)) {
            System.out.println(ErrorMessage.NON_POSITIVE_INTEGER_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        int money = Integer.valueOf(input);
        if (!validator.isPositiveInteger(money)) {
            System.out.println(ErrorMessage.NON_POSITIVE_AMOUNT.getMessage());
            throw new IllegalArgumentException();
        }
        return money;
    }
}
