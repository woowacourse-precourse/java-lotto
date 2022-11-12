package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Bonus;
import lotto.Cash;
import lotto.Lotto;
import lotto.Model.CalculatorModel;
import lotto.Model.LottoGeneratorModel;
import lotto.Rank;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    private Cash cash;
    private List<Lotto> myLottos;
    private int lottoNumber;
    private Lotto winningLotto;
    private Bonus bonus;
    HashMap<Rank, Integer> point;
    double profit;

    public MainController() {
        point = new HashMap<Rank, Integer>();
        point.put(Rank.FIRST, 0);
        point.put(Rank.SECOND, 0);
        point.put(Rank.THIRD, 0);
        point.put(Rank.FOURTH, 0);
        point.put(Rank.FIFTH, 0);
        point.put(Rank.LAST, 0);
    }

    public void inputCash() throws IllegalArgumentException {
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        cash = new Cash(integer);
    }

    public void createMyLottos() {
        LottoGeneratorModel lottoGenerator = new LottoGeneratorModel();
        lottoNumber = countLottoNumber(cash);
        myLottos = lottoGenerator.createMyLottos(lottoNumber);
    }

    private int countLottoNumber(Cash cash) throws IllegalArgumentException {
        CalculatorModel calculator = new CalculatorModel();
        return calculator.countLottoNumber(cash);
    }

    public void printMyLottos(){
        OutputView outputView = new OutputView();
        outputView.printMyLottoInfo(myLottos);
    }

    public void inputWinningNumber() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            try {
                winningNumber.add(Integer.parseInt(number));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }

        winningLotto = new Lotto(winningNumber);
    }

    public void inputBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        bonus = new Bonus(bonusNumber, winningLotto);
    }

    public void calculateWinning() {
        CalculatorModel calculator = new CalculatorModel();
        int total = 0;
        for (Lotto myLotto : myLottos) {
            int match = myLotto.countMatch(winningLotto);
            boolean hasBonus = myLotto.hasBonusNumber(bonus);
            Rank prize = calculator.getRank(match, hasBonus);
            total += prize.getPrize();
            int p = point.get(prize);
            point.replace(prize, p + 1);
        }

        profit = calculator.getProfit(total, cash.getCash());
    }

    public void printResult(){
        OutputView outputView = new OutputView();
        outputView.printResult(point, profit);
    }
}
