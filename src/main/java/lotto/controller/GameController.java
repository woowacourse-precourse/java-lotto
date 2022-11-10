package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Computer;
import lotto.Lotto;
import lotto.common.Msg;
import lotto.service.LottoService;
import lotto.validator.Validator;

public class GameController {

    private final LottoService service = new LottoService(new Validator(), new Computer());
    private List<Lotto> lottos = new ArrayList<>();
    private String input = "";
    private List<Integer> winns = new ArrayList<>();
    private int bonus;

    public void start() {
        welcome();
        input();
        buyLottos();
        if (isEmptyLottos()) {
            return;
        }

        printNumberOfLotto();
        printLottos();

        inputWinnings();

        inputBonus();

        printResult();
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

    private void printLn() {
        System.out.println();
    }

    private void printNumberOfLotto() {
        printLn();
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

    private void inputWinnings() {
        printLn();
        System.out.println(Msg.WINNING.getMsg());
        String s = Console.readLine();
        String[] split = s.split(",");
        winns = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void inputBonus() {
        printLn();
        System.out.println(Msg.BONUS.getMsg());
        String s = Console.readLine();
        bonus = Integer.parseInt(s);
    }

    private void printResult() {
        printLn();
        System.out.println(Msg.RESULT.getMsg());
    }
}
