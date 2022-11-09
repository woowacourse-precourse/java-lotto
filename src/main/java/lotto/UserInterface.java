package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.List;

public class UserInterface {
    int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
