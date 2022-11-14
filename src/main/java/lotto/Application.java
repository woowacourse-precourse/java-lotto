package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final int GAME_MONEY = 1000;
        ArrayList<Lotto> lottos = new ArrayList<>();

        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());

        if (buyMoney % GAME_MONEY != 0) {
            throw new IllegalArgumentException("1000 단위가 아닐때 예외처리");
        }

        for (int i = 0; i < buyMoney / GAME_MONEY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(i,lotto);
        }
        System.out.println(buyMoney / GAME_MONEY + "개를 구매했습니다.");
        for(int i=0; i<lottos.toArray().length; i++){
            System.out.println(lottos.get(i).getNumbers());
        }




    }
}
