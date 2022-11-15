package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

    private Lotto answerLotto;
    private final List<Lotto> myLotto = new ArrayList<>();
    private int bonusNumber;
    private Map<Integer, Integer> score;

    private final LottoManager lottoManager = new LottoManager();

    public Game() {
    }

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");

        int inputCost = 0;
        try {
            inputCost = Integer.parseInt(Console.readLine());
        } catch (Exception e){
            System.out.println("[ERROR] 올바른 숫자를 입력하세요");
        }

        if (inputCost % 1000 != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력하세요");
        }

        int lottoCount = getCountOfLottoByCost(inputCost);
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoCount; i++) {
            myLotto.add(new Lotto(lottoManager.makeRandomLottoNumbers()));
        }

        printMyLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        answerLotto = new Lotto(getAnswerNumberList());

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        score = lottoManager.getScore(myLotto, answerLotto, bonusNumber);

        printResult(inputCost);
    }

    private List<Integer> getAnswerNumberList() {
        String numberLine = Console.readLine();

        List<Integer> numberList = new ArrayList<>();
        String[] numberSplit = numberLine.split(",");
        for (String number : numberSplit) {
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }

    private int getCountOfLottoByCost(int cost) {
        return cost / 1000;
    }

    private void printMyLotto() {
        for (Lotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    private void printResult(int inputCost) {
        double resultMoney = 0;

        for (Map.Entry<Integer, Integer> entry : score.entrySet()) {
            switch (entry.getKey()) {
                case 3:
                    resultMoney += entry.getValue() * 5000;
                    break;
                case 4:
                    resultMoney += entry.getValue() * 50000;
                    break;
                case 5:
                    resultMoney += entry.getValue() * 1500000;
                    break;
                case 15:
                    resultMoney += entry.getValue() * 30000000;
                    break;
                case 16:
                    resultMoney += entry.getValue() * 2000000000;
                    break;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + score.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + score.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + score.getOrDefault(5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + score.getOrDefault(15, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + score.getOrDefault(16, 0) + "개");

        resultMoney = resultMoney / (double) inputCost * 100;

        System.out.println("총 수익률은 " + Math.round(resultMoney * 100) / 100.0 + "%입니다.");

    }
}
