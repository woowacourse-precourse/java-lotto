package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.common.Msg;
import lotto.service.LottoService;

public class Gamecontroller {

    private final LottoService service = new LottoService();

    public void start() {
        welcome();
        String in = input();
        List<Lotto> lottos = buyLottos(in);
        if (isEmpty(lottos)) {
            return;
        }
        printNumberOfLotto(lottos.size());
        printLottos(lottos);
    }

    private void welcome() {
        System.out.println(Msg.WELCOME.getMsg());
    }

    private String input() {
        return Console.readLine();
    }

    private List<Lotto> buyLottos(String in) {
        try {
            List<Lotto> lottos = service.buy(in);
            return lottos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    private boolean isEmpty(List<Lotto> lottos) {
        return lottos.isEmpty();
    }

    private void printNumberOfLotto(int i) {
        System.out.println(i + "개를 구매했습니다.");
    }

    private void printLottos(List<Lotto> lottos) {
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
