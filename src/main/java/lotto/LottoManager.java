package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final int LOTTO_PRICE = 1000;

    public List<Integer> GenerateLottoNumbers() {
        String inputLottoNumbers = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.valueOf(number));
        }
        return lottoNumbers;
    }

    public int GenerateBonusNumber() {
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public List<Integer> GenerateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int getMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    public void sortLottoNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
    }

    public List<Lotto> publishLottoForPrice(int money) {
        List<Lotto> result = new ArrayList<>();
        int numberOfLotto = money/LOTTO_PRICE;

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> newLotto = GenerateRandomNumbers();
            sortLottoNumbers(newLotto);
            Lotto lotto = new Lotto(newLotto);
            result.add(lotto);
        }
        return result;
    }
}
