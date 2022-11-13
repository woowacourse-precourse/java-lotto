package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getLottoCount(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다.");
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위로 입력해야 합니다.");
        }

        return money / 1000;
    }

    public static List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}