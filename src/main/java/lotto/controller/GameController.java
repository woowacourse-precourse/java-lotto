package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.common.Msg;
import lotto.service.LottoService;

public class GameController {

    private final LottoService service = new LottoService();
    private List<Lotto> lottos = new ArrayList<>();
    private String input = "";

    public void start() {
        welcome();
        input();
        buyLottos();
        if (isEmptyLottos()) {
            return;
        }
        printNumberOfLotto();
        printLottos();
    }

    private void welcome() {
        System.out.println(Msg.WELCOME.getMsg());
    }

    private void input() {
        input = Console.readLine();
    }

    private void buyLottos() {
        try {
            lottos = service.buy(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isEmptyLottos() {
        return lottos.isEmpty();
    }

    private void printNumberOfLotto() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    private void printLottos() {
        lottos.forEach(i -> {
            List<Integer> numbers = i.getNumbers().stream().sorted().collect(Collectors.toList());
            System.out.print("[");
            for (int j = 0; j < numbers.size() - 1; j++) {
                System.out.print(numbers.get(j) + ", ");
            }
            System.out.print(numbers.get(numbers.size() - 1));
            System.out.println("]");
        });
    }
}
