package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int NumberOfLotto = getNumberOfLotto();

        List<Lotto> lottoList = makeBunchOfLotto(NumberOfLotto);
    }

    public static int getNumberOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = 0;
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 금액을 제대로 입력해주세요.");
        }
        money = Integer.parseInt(input);
        return money / 1000;
    }

    public static Lotto makeLottoNumbers() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));

        return lotto;
    }

    public static List<Lotto> makeBunchOfLotto(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(makeLottoNumbers());
        }
        return lottos;
    }
}
