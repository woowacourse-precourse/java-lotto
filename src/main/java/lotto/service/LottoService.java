package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.issueLotto;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoNumber;

public class LottoService {
    static final int LOTTO_SIZE = 6;
    public static void lottoService() {
        int count, bonus;
        Lotto inputLottoNumber;
        try {
            count = inputMoney() / 1000;
            inputLottoNumber = inputLottoNumber();
            bonus = inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
        List<Lotto> issuedLotteries = issueLotto(count);
        printLottoNumber(count, issuedLotteries);

    }

    public static List<Integer> stringToIntList(String input) {
        String[] splitInput = input.split(",");
        List<Integer> output = new ArrayList<>();

        for (String e : splitInput) {
            output.add(Integer.parseInt(e));
        }
        return output;
    }

    public static Integer countMatchingNumber(Lotto issuedLotto, Lotto inputLotto) {
        int cnt = 0;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (issuedLotto.getNumbers().contains(inputLotto.getNumbers().get(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
