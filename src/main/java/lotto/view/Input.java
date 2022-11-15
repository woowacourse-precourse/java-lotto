package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String AMOUNT_ERROR = "[ERROR] 구입금액은 양의 정수여야 합니다.";
    private final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String LOTTO_ERROR = "[ERROR] 로또 번호는 정수여야 합니다.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String BONUS_ERROR = "[ERROR] 보너스 번호는 정수여야 합니다.";

    private Input() {
    }

    private int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        return convertToNumber(purchaseAmount);
    }

    private int convertToNumber(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR);
        }
    }

    private Lotto inputLottoNumbers(String numbers) {
        System.out.println(INPUT_LOTTO_NUMBERS);
        numbers = Console.readLine();
        return replaceSeparator(numbers);
    }

    private Lotto replaceSeparator(String numbers) {
        String[] eachNumbers = numbers.split(",");
        return collectLottoNumbers(eachNumbers);
    }

    private Lotto collectLottoNumbers(String[] eachNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String eachNumber : eachNumbers) {
            lottoNumbers.add(convertEachNumbers(eachNumber));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    private int convertEachNumbers(String eachNumber) {
        try {
            return Integer.parseInt(eachNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_ERROR);
        }
    }

    private int inputBonusNumber(String number) {
        System.out.println(INPUT_BONUS_NUMBER);
        number = Console.readLine();
        return convertBonusNumber(number);
    }

    private int convertBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_ERROR);
        }
    }
}
