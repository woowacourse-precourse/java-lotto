package lotto;

import lotto.domain.Store;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();

        store.getSetMoney();
        store.confirmMoney();
        store.setAvailableLotto();
        System.out.println(store.availableLotto + "개를 구매헸습니다.");
        store.publishLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winnernum = store.getWinnerNum();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = store.getBonusNum();

        Lotto lotto = new Lotto(winnernum,bonus);

    }
}
