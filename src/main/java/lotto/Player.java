package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;

public class Player {

    int lottoCount;
    List<Lotto> lottoNumbers = new ArrayList<>();

    public Player() {
        try {
            inputCostForLotto();
            buyLotto();
            printLottoNumber();
        } catch (IllegalArgumentException e) {

        }
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
            lottoNumbers.add(new Lotto(Lotto.createLottoNumber()));
        }
        System.out.println();
        System.out.println(lottoCount + PURCHASE_CONFIRM_MESSAGE);
    }

    private void printLottoNumber() {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottoNumbers.get(i).printSortedLottoNumber();
        }
        System.out.println();
    }
}
