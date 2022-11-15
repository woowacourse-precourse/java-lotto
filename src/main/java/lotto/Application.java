package lotto;

import lotto.domain.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Generator generator = new Generator();
        Judgement judgement = new Judgement();
        Calculator calculator = new Calculator();
        Output output = new Output();
        try {
            int pay = askPay();
            List<List<Integer>> lotteries = generator.createLottoByPay(pay); //로또 구입
            output.outputLotteries(pay, generator.lotteries);

            List<Integer> firstPrize = input.winningNumber(); //당첨 로또
            Lotto lotto = new Lotto(firstPrize);

            String bonusNumber = input.bonusNumber(); //보너스 번호
            Bonus bonus = new Bonus(firstPrize, bonusNumber);
            int bonusNum = Integer.parseInt(bonusNumber);

            List<Integer> winningTable = judgement.makeWinningTable(lotteries, firstPrize, bonusNum); //당첨 갯수
            double earningRate = calculator.calculateEarningRate(winningTable, pay); //수익률

            output.writeDown(winningTable, earningRate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static int askPay() {
        Input input = new Input(); //구입 금액
        String payment = input.payForLotto();
        Pay pay = new Pay(payment);
        int payNum = Integer.parseInt(payment) / 1000;
        return payNum;
    }
}
