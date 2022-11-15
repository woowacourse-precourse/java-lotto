package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.InputMessage;

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
            generator.createLottoByPay(pay); //로또n개 생성
            output.outputLotteries(pay, generator.lotteries); //로또 목록 출력

            List<Integer> firstPrize = input.winningNumber(); // 당첨 로또 입력받기
            Lotto lotto = new Lotto(firstPrize); //로또 검사

            int bonusNumber = input.bonusNumber(); // 보너스 번호 입력받기
            Bonus bonus = new Bonus(firstPrize, bonusNumber); //보너스 번호 검사

            judgement.makeWinningTable(generator.lotteries, input.numbers, input.bonus); //당첨 갯수 저장
            calculator.sumJackpot(judgement.winningTable); //당첨 금액 저장
            calculator.calculateEarningRate(pay); //수익률저장

            output.createMakeOfPrize(judgement.winningTable); //당첨 등수 저장
            output.writeDown(calculator.earningRate); //당첨 결과 출력
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static int askPay() {
        Input input = new Input();
        String payment = input.payForLotto();
        Pay pay = new Pay(payment);
        int payNum = Integer.parseInt(payment) / 1000;
        return payNum;
    }
}
