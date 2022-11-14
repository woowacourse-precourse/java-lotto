package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private final List<Integer> normalNumbers;
    private final int bonusNumber;

    public LottoMachine(List<Integer> normalNumbers, int bonusNumber) {
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getMoney() {
        System.out.println("구매금액을 입력해주세요.");
        String input = Console.readLine();
        return input;
    }

    public void validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위가 아닙니다.");
        }
    }

    public int getLottoCount(String input) {
        int money = Integer.parseInt(input);
        return money / 1000;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 6);
        Collections.sort(numbers, Collections.reverseOrder());
        return numbers;
    }

    public LottoContainer buy() {
        String input = getMoney();
        validate(input);
        int lottoCount = getLottoCount(input);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = getLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        LottoContainer lottoContainer = new LottoContainer(lottos);

        return lottoContainer;
    }

}
