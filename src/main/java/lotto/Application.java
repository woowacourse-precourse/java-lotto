package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.LottoManager;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        LottoManager lottoManager = new LottoManager();
        String winningNumbers = lottoManager.inputWinningNumbers();
        int bonusNumber = lottoManager.inputBonusNumber();
        List<Integer> numbers = numberGenerator.createWinningNumbers(winningNumbers);
        try {
            WinningNumbers w = new WinningNumbers(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

//        Lotto[] lottos = new Lotto[countNumber];
//        for (int i = 0; i < countNumber; i++) {
//            lottos[i] = new Lotto(numberGenerator.createLottoNumbers());
//        }

    }
}
