package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 클래스 선언
        Store store = new Store();
        Admin admin = new Admin(store);
        Buyer buyer = new Buyer(store);

        // 로또 구매 입력
        List<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,8,9,10,11,12)));
        lottos.add(new Lotto(List.of(19,17,16,15,14,13)));

        // 당첨 번호 설정
        admin.inputGameNumbers();

        // 당첨 내역 확인
        LottoResult lr = store.checkPrize(lottos);
        System.out.println("1등 " + lr.countPrize(Prize.PRIZE1));
        System.out.println("2등 " + lr.countPrize(Prize.PRIZE2));
        System.out.println("3등 " + lr.countPrize(Prize.PRIZE3));
        System.out.println("4등 " + lr.countPrize(Prize.PRIZE4));
        System.out.println("5등 " + lr.countPrize(Prize.PRIZE5));
    }
}
