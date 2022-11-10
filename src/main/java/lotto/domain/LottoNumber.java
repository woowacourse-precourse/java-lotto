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
}
