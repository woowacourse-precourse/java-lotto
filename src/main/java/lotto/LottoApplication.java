package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        int num = money / 1000;
        System.out.println(num + "개를 구매했습니다.");
        List<List> randomLottoLists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> numbers
                    = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomLottoLists.add(numbers);
            System.out.println(numbers);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLotto = new ArrayList<>();
        String[] split = Console.readLine().split(",");
        for (int i = 0; i < split.length; i++) {
            winningLotto.add(Integer.parseInt(split[i]));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
    }
}
