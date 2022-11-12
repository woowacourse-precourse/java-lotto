package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Bonus;
import lotto.Cash;
import lotto.Lotto;
import lotto.Model.Calculator;
import lotto.Model.Judgment;
import lotto.Model.LottoGenerator;
import lotto.Prize;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    public MainController() {
        point = new HashMap<Prize, Integer>();
        point.put(Prize.FIRST, 0);
        point.put(Prize.SECOND, 0);
        point.put(Prize.THIRD, 0);
        point.put(Prize.FOURTH, 0);
        point.put(Prize.FIFTH, 0);
        point.put(Prize.LAST, 0);
    }

    private Cash cash;

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
        lottoNumber = countLottoNumber(cash);
    }

    private int lottoNumber;

    private int countLottoNumber(Cash cash) throws IllegalArgumentException {
        Calculator calculator = new Calculator();
        return calculator.countLottoNumber(cash);
    }

    private List<Lotto> myLottos;

    public void createMyLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        myLottos = lottoGenerator.createMyLottos(lottoNumber);
        OutputView outputView = new OutputView();
        outputView.printMyLottoInfo(myLottos);
    }

    private Lotto winningLotto;

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

    private Bonus bonus;

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

    HashMap<Prize, Integer> point;

    public void calculateWinning() {
        Judgment judgment = new Judgment();
        Calculator calculator = new Calculator();
        int total = 0;
        for (Lotto myLotto : myLottos) {
            int match = judgment.compare(winningLotto, myLotto);
            boolean hasBonus = judgment.hasBonusNumber(myLotto, bonus);
            Prize prize = calculator.givePrize(match, hasBonus);
            total += prize.getPrize();
            int p = point.get(prize);
            point.replace(prize, p + 1);
        }
        double profit = calculator.getProfit(total, cash.getCash());
        OutputView outputView = new OutputView();
        outputView.printResult(point, profit);
    }
}
