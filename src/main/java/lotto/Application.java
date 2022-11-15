package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.CheckInput;
import lotto.domain.GenerateLotto;
import lotto.domain.Lotto;
import lotto.domain.MatchLotto;

public class Application {
    public static void main(String[] args) {
        try {
            CheckInput checkInput = new CheckInput();
            int purchaseAmount = checkInput.readPurchaseAmount();

            List<Lotto> lottos = new GenerateLotto().buyLotto(purchaseAmount);

            List<Integer> winningNumbers = checkInput.readWinningNumber();

            int bonusNumber = checkInput.readBonusNumber();

            new MatchLotto().matchLottos(lottos, winningNumbers, bonusNumber, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
