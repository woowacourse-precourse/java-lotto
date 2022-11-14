package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.constants.GuideMessage.*;

public class OutputView {

    public static void printUserLotto(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + PURCHASE_MESSAGE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLotto());
        }
    }
}
