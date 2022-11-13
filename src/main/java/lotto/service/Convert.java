package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoPrice;

public class Convert {

    private final Validate validate = new Validate();

    public int toLottoCount(int purchasePrice) {
        validate.validPurchasePriceAboveThanUnitPrice(purchasePrice);
        validate.validDivisible(purchasePrice);
        return purchasePrice / LottoPrice.UNIT.getPrice();
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 정수로 변환할 수 없습니다.");
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
