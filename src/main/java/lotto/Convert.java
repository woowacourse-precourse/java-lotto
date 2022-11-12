package lotto;

import constant.Text;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    private static final int UNIT_LOTTO_PRICE = 1_000;

    private final Validate validate = new Validate();

    public int toLottoCount(int purchasePrice) {
        validate.validDivisible(purchasePrice, UNIT_LOTTO_PRICE);
        return purchasePrice / UNIT_LOTTO_PRICE;
    }

    public int toInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Text.ERROR + "입력값을 정수로 변환할 수 없습니다.");
        }
    }

    public List<Integer> toWinLottoNumbers(String input) {
        String[] strNumbers = input.split(",");
        validate.validWinLottoForm(strNumbers);

        List<Integer> winLottoNumbers = new ArrayList<>();

        for (String strNumber : strNumbers) {
            int number = toInt(strNumber);
            validate.validLottoNumber(number);
            winLottoNumbers.add(number);
        }

        validate.validDuplicate(winLottoNumbers);
        return winLottoNumbers;
    }

    public int toWinLottoBonusNumber(String input) {
        int bonusNumber = toInt(input);
        validate.validLottoNumber(bonusNumber);
        return bonusNumber;
    }
}
