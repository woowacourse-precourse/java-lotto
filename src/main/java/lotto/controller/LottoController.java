package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LotteryAnswer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.User;

import java.util.List;

public class LottoController {
    private final LotteryAnswer answer;
    private final User user;

    public LottoController(LotteryAnswer answer, User user) {
        this.answer = answer;
        this.user = user;
    }

    public void purchase() {
        user.inputPurchaseAmount(Console.readLine());
        user.createLottos();
    }

    public void inputAnswer() {
        answer.inputAnswerLotto(Console.readLine());
        answer.inputBonusNumber(Console.readLine());
    }

    public void compareToAnswer() {
        for (Lotto lotto : user.getLottos()) {
            int countAnswer = countAnswer(lotto);
            int countBonus = countBonus(lotto);

            user.addPrize(Prize.getResult(countAnswer, countBonus));
        }
    }

    private int countAnswer(Lotto lotto) {
        List<Integer> answerNumbers = answer.getAnswer().getNumbers();

        return (int) lotto.getNumbers().stream()
                .filter(answerNumbers::contains)
                .count();
    }

    private int countBonus(Lotto lotto) {
        int bonusNumber = answer.getBonusNumber();

        if (lotto.getNumbers().contains(bonusNumber))
            return 1;

        return 0;
    }
}
