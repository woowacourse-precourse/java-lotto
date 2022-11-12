package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GenerateNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.service.UserService;

import java.util.List;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private UserService userService = new UserService();
    private List<GenerateNumbers> generateNumbers;
    private int money;

    public void printBuyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        String inputMoney = Console.readLine();

        generateNumbers = lottoService.generateLotteries(userService.buyLotto(inputMoney));
        money = Integer.valueOf(inputMoney);

        lottoService.printLotteries(generateNumbers);
    }

    public void printUserInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNum = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();

        Player player = (Player) userService.createPlayerNumbers(inputNum,Integer.valueOf(inputBonus));
        List<LottoRanking> lottoRankings = lottoService.ranking(generateNumbers, player.getNumbers(), player.getBonusNumber());
        lottoService.printPlace(lottoRankings);
        printProfit(lottoService.calculatorProfit(lottoRankings),money);
    }

    private void printProfit(int profit, int money) {
        double profitPercent = 0;

        profitPercent = profit * 100.0 / money;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitPercent);
    }
}
