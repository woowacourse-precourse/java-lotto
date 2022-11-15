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

        int pay = askPay();
        generator.createLottoByPay(pay); //로또n개 생성
        output.outputLotteries(pay, generator.lotteries); //로또 목록 출력
    }
    public static int askPay() {
        Input input = new Input();
        String payment = input.payForLotto();
        Pay pay = new Pay(payment);
        int payNum = Integer.parseInt(payment) / 1000;
        return payNum;
    }
}
