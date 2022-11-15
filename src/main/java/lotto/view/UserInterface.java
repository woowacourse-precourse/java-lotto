package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Computer;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {

    public String getUserInput(String changeWord) {
        System.out.println(changeWord);
        return Console.readLine();
    }

    public void showAutoLottos(List<List<Integer>> autoLottos, long lottoCount) {
        System.out.println(lottoCount + Message.BUY);
        for (List<Integer> autoLotto : autoLottos) {
            StringBuilder sb = new StringBuilder();
            sb.append(Message.LOTTO_PRINT_START);
            sb.append(autoLotto.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(Message.JOIN_SEPARATOR)));
            sb.append(Message.LOTTO_PRINT_END);
            System.out.println(sb);
        }
    }

    public void printResult() {
        System.out.println(Message.RESULT);
    }
}
