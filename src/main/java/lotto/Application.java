package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int count = Lotto.amount();
        if(count!=0) {
            List<List<Integer>> ticket = Lotto.publish(count);
            List<Integer> winNum = Lotto.createWinningnum();
            Lotto.createBonusnum(winNum);

            List<Integer> result = Lotto.winResult(winNum, ticket);

        }
    }
}
