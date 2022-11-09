package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        List<List<Integer>> purchasedLotto = purchase.lottoPurchase();
        Lotto lotto = new Lotto(getWinningNumber());
    }

    private static List<Integer> getWinningNumber() {
        List<Integer> result = new ArrayList<>();
        // 당첨번호 입력
        // 보너스 번호 입력
        return result;
    }
}
