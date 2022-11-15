package lotto;

import model.Game;
import model.Rank;
import utils.Result;
import utils.UserInput;

import java.util.*;

public class Process {
    static Game game;
    static UserInput userInput;
    static Result result;

    public Process() {
        this.game = new Game();
        this.userInput = new UserInput(game);
        this.result = new Result(game);
        process();
    }

    public static void process() {
        getUserInputMoney();
        getLottoNumbers();
        getInputLottoNumber();
        getInputBonusNumber();
        printResult();
    }

    public static void getUserInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        userInput.inputMoney();
    }

    public static void getLottoNumbers() {
        int purchaseNumber = game.getPurchaseNumber();
        List<List<Integer>> userLottos = game.getUserLottos();

        System.out.println(purchaseNumber + "개를 구매했습니다.");
        printUserLottos(userLottos);
    }

    public static void printUserLottos(List<List<Integer>> userLottos) {
        sortLottoNumbers();

        for (List<Integer> userLotto : userLottos) {
            System.out.println(userLotto.toString());
        }
    }

    public static void sortLottoNumbers() {
        List<List<Integer>> userLottos = game.getUserLottos();

        for (List<Integer> userLotto : userLottos) {
            ArrayList<Integer> userLottoNumbers = new ArrayList<>(userLotto);
            Collections.sort(userLottoNumbers);
        }
    }

    public static void getInputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        userInput.inputLottoNumber();
    }

    public static void getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        userInput.inputBonusNumber();
    }

    public static Map<Rank, Integer> getResultRank() {
        Map<Rank, Integer> allResult = new HashMap<>();
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            allResult.put(rank, 0);
        }

        for (List<Integer> userLottoNumber : game.getUserLottos()) {
            Rank resultRank = result.getResult(userLottoNumber, game.getLotto().getNumbers(), game.getBonusNumber());
            allResult.put(resultRank, allResult.get(resultRank) + 1);
        }

        return allResult;
    }

    public static void printResult() {
        Map<Rank, Integer> allResult = getResultRank();
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계\n");
        sb.append("---\n");
        sb.append("3개 일치 (5,000원) - " + allResult.get(Rank.FIFTH) + "개\n");
        sb.append("4개 일치 (50,000원) - " + allResult.get(Rank.FOURTH) + "개\n");
        sb.append("5개 일치 (1,500,000원) - " + allResult.get(Rank.THIRD) + "개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + allResult.get(Rank.SECOND) + "개\n");
        sb.append("6개 일치 (2,000,000,000원) - " + allResult.get(Rank.FIRST) + "개\n");
        sb.append("총 수익률은 " + getProfit(allResult) + "%입니다.");

        System.out.println(sb);
    }

    public static double getProfit(Map<Rank, Integer> allResult) {
        int profitMoney = 0;
        int purchaseMoney = game.getPurchaseNumber() * 1000;

        for (Rank rank : allResult.keySet()) {
            profitMoney += rank.getPrize() * allResult.get(rank);
        }

        double profit = ((double)profitMoney / (double)purchaseMoney) * 100;

        return profit;
    }
}
