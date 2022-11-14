package lotto.controller;

import lotto.Utils.InputValid;
import lotto.Utils.RandomUtil;
import lotto.model.Computer;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private User user;
    private Lotto lotto;
    private Computer computer;
    private Result result;

    public LottoController() {
        user=new User();
        result=new Result();
    }

    public void startLotto(){
        try {
            inIt();

            OutputView.printGameCount(user.getUserGameCnt());
            randomNumbersController();
            OutputView.printRandomNumbers(computer.getRandomNumbers());

            lotto = new Lotto(InputView.getLottoNumber());
            lotto.setBonusNumber(InputView.getBonusNumber(lotto.getNumbers()));

            result.calculatorResult(computer.getRandomNumbers(), lotto.getNumbers(), lotto.getBonusNumber());
            OutputView.printResult(result.getResultArray());
            OutputView.printRateOfReturn(user.getUserPrice(), result.getPriceSum());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void inIt(){
        user.setUserPrice(InputView.getUserPriceNumber());
    }

    private void randomNumbersController() {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for (int i = 0; i < user.getUserGameCnt(); i++) {
            randomNumbers.add(RandomUtil.makeRandomNumbers());
        }
        computer = new Computer(randomNumbers);
    }
}
