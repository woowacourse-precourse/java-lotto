package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static UserInput userInput = new UserInput();
    static Generator generator = new Generator();

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int money;
    private int amount;

    public void start() {
        money = userInput.getMoney();
        amount = userInput.getAmount(money);

        lottos = generateLottos();
        printLottos();
    }

    private List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(generator.generateLotto());
        }
        return lottos;
    }

    private void printLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
        System.out.println();
    }
}
