package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Computer;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.common.Msg;
import lotto.service.LottoService;
import lotto.validator.Validator;

public class GameController {

    private final LottoService service = new LottoService(new Validator(), new Computer());

    public void start() {
        try {
            welcome();
            String money = inputMoney();
            List<Lotto> lottos = buyLottos(money);
            printNumberOfLotto(lottos);
            printLottos(lottos);
            String wins = inputWinnings();
            String bonus = inputBonus();
            printResult(lottos, wins, bonus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void welcome() {
        System.out.println(Msg.WELCOME.getMsg());
    }

    private String inputMoney() {
        return Console.readLine();
    }

    private List<Lotto> buyLottos(String money) {
        return service.buy(money);
    }

    private void printLn() {
        System.out.println();
    }

    private void printNumberOfLotto(List<Lotto> lottos) {
        printLn();
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.forEach(i -> {
            List<Integer> numbers = i.getNumbers().stream().sorted().collect(Collectors.toList());
            System.out.print("[");
            printNumberList(numbers);
            System.out.print(numbers.get(numbers.size() - 1));
            System.out.println("]");
        });
    }

    private void printNumberList(List<Integer> numbers) {
        for (int j = 0; j < numbers.size() - 1; j++) {
            System.out.print(numbers.get(j) + ", ");
        }
    }

    private String  inputWinnings() {
        printLn();
        System.out.println(Msg.WINNING.getMsg());
        return Console.readLine();
    }

    private String inputBonus() {
        printLn();
        System.out.println(Msg.BONUS.getMsg());
        return Console.readLine();
    }

    private void printResult(List<Lotto> lottos, String wins, String bonus) {
        printLn();
        System.out.print(Msg.RESULT.getMsg());
        LottoResult lottoResult = service.getResult(lottos, wins, bonus);
        String result = lottoResult.getResult();
        System.out.println(result);
    }
}
