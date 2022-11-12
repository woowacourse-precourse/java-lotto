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
        String count = Console.readLine();
        int countNumber = Integer.parseInt(count);
        Lotto[] lottos = new Lotto[countNumber];
        for (int i = 0; i < countNumber; i++) {
            lottos[i] = new Lotto(numberGenerator.createLottoNumbers());
        }
        lottoManager.printLottoNumbers(lottos);

    }
}
