package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;

public class Player {

    int lottoCount;
    List<Lotto> lottoSet = new ArrayList<>();

    public Player() {
        inputCostForLotto();
        buyLotto();
        printLottoNumber();
    }

    private void inputCostForLotto() {
        System.out.println(PURCHASE_MESSAGE);
        String input = Console.readLine();
        Validator.validateForIllegalInput(input);

        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        lottoCount = cost / LOTTO_PRICE;
    }

    private void buyLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoSet.add(new Lotto(Lotto.createLottoNumber()));
        }
        System.out.println();
        System.out.println(lottoCount + PURCHASE_CONFIRM_MESSAGE);
    }

    private void printLottoNumber() {
        for (int i = 0; i < lottoSet.size(); i++) {
            System.out.println(lottoSet.get(i));
        }
        System.out.println();
    }
}
