package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    private List<Integer> lottoNumbers = new ArrayList<>();
    private int bonusNumber;

    public LottoNumber(String lottoNumbers, String bonusNumber) {

    }

    private int validLottoNumber(String num) {
        try {
            return validNumberRange(Integer.parseInt(num));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private int validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 1에서 45사이의 숫자를 입력해주세요.");
        }
        return num;
    }
}
