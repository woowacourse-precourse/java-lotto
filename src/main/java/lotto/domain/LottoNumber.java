package lotto.domain;

import lotto.console.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private static final List<Integer> lottoNumbers = new ArrayList<>();

    public static List<Integer> getLottoNumber() {
        String[] numbers = Input.inputLottoNumbers();
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        new Lotto(lottoNumbers);
        return lottoNumbers;
    }

    public static int getBonusNumber() {
        int bonusNumber = Input.inputBonusNumber();
        isDuplicatedNumber(bonusNumber);
        isCorrectNumber(bonusNumber);
        return bonusNumber;
    }

    private static void isCorrectNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void isDuplicatedNumber(int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
