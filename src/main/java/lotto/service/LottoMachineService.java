package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.utils.Parser;
import lotto.utils.RandomLottoNumbersGenerator;

import static lotto.enumtype.LottoInterfaceMsg.INSERT_MONEY;

public class LottoMachineService {
    private static final int FIX_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private LottoMachine lottoMachine;
    private Money money;

    public LottoMachine setLottoMachine() {
        System.out.println(INSERT_MONEY.getMessage());
        String input = Console.readLine();
        money = new Money(Parser.parseInt(input));
        return lottoMachine = new LottoMachine(RandomLottoNumbersGenerator.generateLottoMachine(money.getCountByPrice(LOTTO_PRICE), FIX_SIZE));
    }

    public Money getMoney() {
        return money;
    }
}
