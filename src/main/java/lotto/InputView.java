package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_PURCHASE_PRICE_COMMENT = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_COMMENT = "당첨번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_BONUS_NUMBER_COMMENT = "보너스 번호를 입력해 주세요.";

    public static int getLottoPrice() {
        System.out.println(LOTTO_PURCHASE_PRICE_COMMENT);
        String lottoPrice = Console.readLine();

        NumberValidator.isValidPurchasePrice(lottoPrice);

        return Integer.parseInt(lottoPrice);
    }

    public static String getWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_NUMBER_COMMENT);
        String winningLottoNumbers = Console.readLine();

        NumberValidator.isValidLottoNumbers(winningLottoNumbers);

        return winningLottoNumbers;
    }

    public static String getWinningBonusNumber(String winningLottoNumber) {
        System.out.println();
        System.out.println(WINNING_LOTTO_BONUS_NUMBER_COMMENT);
        String bonusNumber = Console.readLine();

        NumberValidator.isValidBonusNumber(bonusNumber, winningLottoNumber);

        return bonusNumber;
    }
}
