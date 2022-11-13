package lotto.domain.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;
import lotto.system.AnswerLottoSystem;
import lotto.system.IoSystem;
import lotto.system.RandomLottoSystem;
import lotto.system.SettlementSystem;

public class LottoGame {
    private final IoSystem io;

    public LottoGame(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    public void execute() {
        var money = new Money(io.input());

        var randomLottoSystem = new RandomLottoSystem(io);
        var answerLottoSystem = new AnswerLottoSystem(io);
        var settlementSystem = new SettlementSystem();

        var result = settlementSystem.result(
                randomLottoSystem.generateLottoBundle(
                        this.generateRandomNumbers(money.calculateAvailablePurchaseCount())),
                answerLottoSystem.generateAnswerLotto()
        );

        var profits = settlementSystem.calculateProfits();
        io.println(result);
        io.print(String.format("총 수익률은 %.1f%%입니다.", money.calculateROI(profits)));
    }

    private List<List<Integer>> generateRandomNumbers(final Long repeatCount) {
        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < repeatCount; i++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return numbers;
    }
}
