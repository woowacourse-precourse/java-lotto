package lotto.View;

import lotto.domain.*;

public class Application {
    public static void main(String[] args) {

        try {
            // TODO: 프로그램 구현
            Screen screen = new Screen();

            // User Part
            User user = new User(screen.readMoney());
            user.makeLottos();

            // Computer Part
            LottoAnswer lottoAnswer = new LottoAnswer(screen.readLotto(), screen.readBonus());

            screen.printLottoCount(user.getNumOfLotto());
            screen.printLottos(user.getLottos());

            // Calculate Part
            Result result = new Result(user.getUserMoney());
            Calculator calculator = new Calculator();
            for (Lotto lotto : user.getLottos()) {
                calculator.clearCount();
                calculator.checkCount(lotto, lottoAnswer);
                result.checkRanks(calculator);
            }
            result.calcAllResult();

            // Result Part ( print )
            screen.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
