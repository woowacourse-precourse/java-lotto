package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private List<Integer> normalNumbers;
    private int bonusNumber;

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

    public void setNormalNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] tokenized = input.split(",");

        this.normalNumbers = new ArrayList<>();
        for(String token: tokenized) {
            normalNumbers.add(Integer.parseInt(token));
        }
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        this.bonusNumber = Integer.parseInt(input);
    }

}
