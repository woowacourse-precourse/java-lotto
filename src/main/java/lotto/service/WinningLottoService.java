package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class WinningLottoService {
    private static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();

        OutputView.messageWinningInput();
        String[] input = Console.readLine().split(",");
        for (String number : input) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
}
