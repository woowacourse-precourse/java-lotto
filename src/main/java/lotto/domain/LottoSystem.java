package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoSystem {
    LottoMachine lottoMachine;

    public LottoSystem() {
        lottoMachine = new LottoMachine();
    }

    public List<Lotto> buy() throws IllegalArgumentException {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine().trim();
        return lottoMachine.printLottoBundle(input);
    }
}
