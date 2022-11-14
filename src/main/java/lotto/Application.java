package lotto;

import lotto.userinterface.UserInterface;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer money = UserInterface.getMoney();

        List<Lotto> randomLottos = LottoMachine.getRandomLottos(money);

        UserInterface.printLottos(randomLottos);

        List<Integer> answerNumbers = UserInterface.getLottoNumbers();

        Integer bonusNumber = UserInterface.getBonusNumber(answerNumbers);
/*

        Lotto answerLotto = Lotto.numberOf(answerNumbers);

        UserInterface.printResult(randomLottos, answerLotto, bonusNumber);
        UserInterface.printEarningRate();*/

        // TODO: 프로그램 구현
    }
}
