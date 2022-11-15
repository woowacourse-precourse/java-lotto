package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {
    private List<Lotto> randomLottos = new ArrayList<>();

    public List<Lotto> getRandomLottos(int count) {
        setRandomLottos(count);
        printRandomLottos();
        return randomLottos;
    }

    private void setRandomLottos(int count) {
        for(int i = 0; i < count; i++) {
            List<Integer> integers = new ArrayList<Integer>(setRandomLotto());
            sortNumbers(integers);
            randomLottos.add(new Lotto(integers));
        }
    }

    //6개의 1부터 45까지 서로 다른 수로 이루어진 랜덤 숫자를 생성하는 메소드
    private List<Integer> setRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private void printRandomLottos() {
        for (Lotto randomLotto : randomLottos) {
            System.out.println(randomLotto.getNumbers());
        }
    }
}
