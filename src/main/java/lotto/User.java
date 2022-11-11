package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static int lottoMoney = 0;
    public static int lottoChance = 0;
    public final int PRICE_PER_LOTTO = 1000;
    Validator validator = new Validator();

    // 로또 구매 금액을 천원 단위로 입력해 게임 횟수를 출력하게 하는 함수
    public int inputLottoPurchaseMoney() {
        lottoMoney = Integer.parseInt(Console.readLine());
        validator.validateMoneyInput(lottoMoney);
        return lottoMoney;
    }

    // 금액에 따른 로또 총 로또 게임 횟수를 반환한
    public void getLottoChance(int money) {
        lottoChance = lottoMoney / PRICE_PER_LOTTO;
    }

    // 한 게임의 로또 번호를 List 형태로 만들어줌
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
        System.out.println(allLottoNumber);
        return allLottoNumber;
    }


}