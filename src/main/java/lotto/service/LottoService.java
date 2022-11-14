package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.inputLottoNumber;
import static lotto.view.InputView.inputMoney;

public class LottoService {
    public static void lottoService() {
        int money;
        Lotto inputLottoNumber;
        try {
            money = inputMoney();
            inputLottoNumber = inputLottoNumber();

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
    }

    public static List<Integer> stringToIntList(String input) {
        String[] splitInput = input.split(",");
        List<Integer> output = new ArrayList<>();

        for (String e : splitInput) {
            output.add(Integer.parseInt(e));
        }
        return output;
    }
}
