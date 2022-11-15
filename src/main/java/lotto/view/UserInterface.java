package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.Messages.Message;

import lotto.utill.Lotto;
import lotto.utill.YieldResult;

import java.util.List;


public class UserInterface {
    public static String purchaseLotto() {
        System.out.println(Message.MoneytoBuy);
        return Console.readLine();
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + Message.BuyCount);
        lottos.forEach(System.out::println);
    }

    public static String inputWinningNumber() {
        System.out.println(Message.InputWinningNumber);
        return Console.readLine();
    }

    public static String inputWinningBonus() {
        System.out.println(Message.InputWinningBonus);
        return Console.readLine();
    }
    public static void printWinningResult(YieldResult lottoResult, int cost) {
        int reward = lottoResult.calcReward();
        double yield = Math.round((float) reward / cost * 1000) / 10.0;
        System.out.println(Message.printresult);
        System.out.println("---");
        System.out.println(lottoResult.getResult());
        System.out.println("총 수익률은 "+ yield + "%입니다.");
    }
}
