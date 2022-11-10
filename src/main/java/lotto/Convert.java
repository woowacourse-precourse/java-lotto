package lotto;

import constant.Amount;
import constant.LottoText;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    private final Validate validate = new Validate();

    public int toLottoCount(int purchasePrice) {
        validate.validDivisible(purchasePrice);
        return purchasePrice / Amount.UNIT.getPrice();
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoText.ERROR + "입력값을 정수로 변환할 수 없습니다.");
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
        validate.validBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
