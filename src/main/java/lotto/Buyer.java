package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private static final String AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요";
    private static final int LOTTO_PRICE = 1000;

    public void amountInput() {

        System.out.println(AMOUNT_INPUT_MSG);
        UserInput input = new UserInput();
        int amount  = input.amountInput();
    }

    public void buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;

        List<List<Integer>> lottos = new ArrayList<>();

        Generator generator = new Generator();
        for(int i = 0 ; i < count; ++i) {
            lottos.add(generator.createLotto());
        }

        for(int i = 0; i < lottos.size(); ++i) {
            System.out.println(lottos.get(i).toString());
        }
    }

}
