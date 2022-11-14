package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;
    private int paid;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    public LottoMachine() {

    }
    public void getInputMoney() {
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        validateMoney(money);
        this.paid = Integer.parseInt(input);
    }
    public void validateMoney(int money) {
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }


}
