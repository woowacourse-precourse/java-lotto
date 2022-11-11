package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 금액을 1000원 단위로 입력해주세요.";

    private Lotto winningNumbers;

    public Lotto getwinningNumbers(){
        return this.winningNumbers;
    }

    public void setWinningNumbers() {
        this.winningNumbers = new Lotto(translateNumbers(Console.readLine()));
    }

    public List<Integer> translateNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Lotto> buyLotto() {
        int money = inputMoney();
        int lottoNum = countLotto(money);
        return pickLottoList(lottoNum);
    }

    public List<Lotto> pickLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while (count > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            count -= 1;
        }
        return lottoList;
    }

    public int countLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
        }
        return money / 1000;
    }

    public int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }
}
