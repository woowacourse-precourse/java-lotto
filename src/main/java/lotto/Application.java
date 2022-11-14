package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Lotto> lotto_list = new ArrayList<>(); //전체 로또 담을 리스트

    public static List<Integer> makeRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
