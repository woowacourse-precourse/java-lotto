package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int LOTTO_MINIMUN_NUM_SIZE = 1;
    private static final int LOTTO_MAXIMUN_NUM_SIZE = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    Money money = new Money();

    public int insertMoney() {
        int inputMoney = Input.inputMoney();
        return money.insertMoney(inputMoney);
    }

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUN_NUM_SIZE, LOTTO_MAXIMUN_NUM_SIZE, LOTTO_NUMBER_SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public List<Lotto> purchaseLottos(Integer ticket) {
        Output.purchaseLotto(ticket);
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < ticket; count++) {
            lottos.add((createLotto()));
        }
        Output.printPurchaseLottos(lottos);
        return lottos;
    }

    public Lotto getWinningLotto(){
        String inputWinningNumber = Input.inputWinningNumber();
        Lotto winningLotto = WinningNumber.getWinningLotto(inputWinningNumber);
        return winningLotto;
    }
}
