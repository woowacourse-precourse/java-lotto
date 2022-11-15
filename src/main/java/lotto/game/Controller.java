package lotto.game;

import lotto.game.view.View;
import lotto.user.Lotto;

import java.util.List;
import java.util.Map;

public class Controller {
    private final View view;
    private final Service service;

    public Controller() {
        this.view = new View();
        this.service = new Service();
    }

    public void run() {
        try {
            // 1. 입력 - 로또 구입 금액
            String purchaseAmount = view.inputPurchaseAmount();

            // 2. 로또 번호 발행
            int quantity = service.generateQuantity(purchaseAmount);
            List<Lotto> lottos = service.generateLottos(quantity);

            // 3. 출력 - 발행한 로또 수량
            view.outputQuantity(quantity);

            // 4. 출력 - 발행한 로또 번호
            lottos.forEach(
                    lotto -> view.outputLottoNumbers(lotto.toString()));

            // 5. 입력 - 당첨 번호
            Lotto draw = service.generateDraw(view.inputDrawNumbers());

            // 6. 입력 - 보너스 번호
            int bonus = service.generateBonus(view.inputBonusNumber());

            // 7. 당첨 계산
            Map<Integer, Integer> drawScore = service.calculateDrawScore(lottos, draw);
            int bonusScore = service.calculateBonusScore(drawScore, lottos, draw, bonus);
            double earningsRate = service.calculateEarningsRate(drawScore, bonusScore, quantity);

            // 8. 당첨 통계 출력
            view.outputResult(drawScore, bonusScore);
            view.outputEarningRate(earningsRate);
        } catch (IllegalArgumentException ignored) {
        }
    }
}
