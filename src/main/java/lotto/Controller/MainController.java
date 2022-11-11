package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Bonus;
import lotto.Cash;
import lotto.Lotto;
import lotto.Model.Calculator;
import lotto.Model.LottoGenerator;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private Cash cash;
    private List<Lotto> myLottos = new ArrayList<>();
    public void inputCash() throws IllegalArgumentException{
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        int integer;
        try{
            integer = Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        cash = new Cash(integer);
        countLottoNumber(cash);
        LottoGenerator lottoGenerator = new LottoGenerator();
        myLottos = lottoGenerator.createMyLottos(lottoNumber);
        OutputView outputView = new OutputView();
        outputView.printMyLottoInfo(myLottos);
    }

    private int lottoNumber;
    private void countLottoNumber(Cash cash) throws IllegalArgumentException{
        Calculator calculator = new Calculator();
        lottoNumber = calculator.countLottoNumber(cash);
    }

    private Lotto winningLotto;
    public void inputWinningNumber() throws IllegalArgumentException{
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            try {
                winningNumber.add(Integer.parseInt(number));
            } catch(NumberFormatException exception){
                throw new IllegalArgumentException("[ERROR] 입력 값이 올바르지 않습니다.");
            }
        }

        winningLotto = new Lotto(winningNumber);
    }

    private Bonus bonus;
    public void inputBonusNumber() throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch(NumberFormatException exception){
            throw new IllegalArgumentException("[ERROR] 입력 값이 올바르지 않습니다.");
        }

        bonus = new Bonus(bonusNumber);
    }
}
