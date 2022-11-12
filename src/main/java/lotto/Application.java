package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.LottoManager;

public class Application {
    public static void main(String[] args) {
        // 로또개수 입력
        final LottoManager lottoManager = new LottoManager();
        int lottoCount = lottoManager.inputLottoCount();

        // 개수에 맞게 로또번호 생성 및 출력
        final NumberGenerator numberGenerator = new NumberGenerator();
        Lotto[] lottos = new Lotto[lottoCount];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto(numberGenerator.createLottoNumbers());
        }
        lottoManager.printLottoNumbers(lottos);

        // 당첨번호 입력
        String winningNumbers = lottoManager.inputWinningNumbers();
        List<Integer> numbers = numberGenerator.createWinningNumbers(winningNumbers);
        WinningNumbers w = new WinningNumbers(numbers);

        int bonusNumber = lottoManager.inputBonusNumber();

    }
}
