package lotto.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinnerNumber {

    public LottoWinnerNumber(String winnerLottoNumber) {
        validInputWinNumber(winnerLottoNumber);
    }

    public List<Integer> convertWinnerNumber(String winnerLottoNumber) {
        return Arrays.stream(winnerLottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validInputWinNumber(String winnerLottoNumber) {
        try {
            String replaceNumber = winnerLottoNumber.replace(",", "");
            Integer.parseInt(replaceNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 콤마만 입력 가능합니다.");
        }
    }

}

