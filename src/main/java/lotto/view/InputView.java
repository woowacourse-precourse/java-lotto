package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int lottoMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;

    public List<Integer> result = new ArrayList<>();
    public List<List<Integer>> allLottoNumber = new ArrayList<>();
    public int bonusNumber = 0;


    Validator validator = new Validator();

    public int inputLottoPurchaseMoney() {
        lottoMoney = Integer.parseInt(Console.readLine());
        validator.validateMoneyInput(lottoMoney);
        return lottoMoney;
    }

    public int getLottoChance(int money) {
        return lottoMoney / PRICE_PER_LOTTO;
    }

    public List<Integer> createLottoOneGameNumber() {
        List<Integer> oneGameNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        oneGameNumbers.sort(Integer::compareTo);
        return oneGameNumbers;
    }

    public List<List<Integer>> createAllGameLottoNumber(int chance) {
        List<List<Integer>> allLottoNumber = new ArrayList<>();
        for (int i = 0; i < chance; i++) {
            allLottoNumber.add(createLottoOneGameNumber());
        }
        return allLottoNumber;
    }

    public void compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers.retainAll(winningNumbers);
        lottoNumbers.size();// 몇개 같은 지 출력
        if (lottoNumbers.size() == 3) {
            // 5등
        }
        if (lottoNumbers.size() == 4) {
            // 4등
        }
        if (lottoNumbers.size() == 5) {
            // 3등
        }
        if (lottoNumbers.size() == 5 && ) {
            // 2등
        }
    }

    // 당첨 번호를 입력하는 메소드
    public List<Integer> createWinningNumber() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String value: inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(value));
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
