package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");

        String str = Console.readLine();
        Util.isValidInput(str);
        int count = Integer.parseInt(str);
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            lottos.add(lotto);
            lotto.printNumbers();
        }


    }
}
