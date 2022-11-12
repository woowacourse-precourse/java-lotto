package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InputView {
    public static int lottoMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;
    public final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> lottoResult = Arrays.asList(0,0,0,0,0);
    public List<List<Integer>> allLottoNumber = new ArrayList<>();


    public void validateMoneyInput(int money) {
        if (money % 1000 != 0) {

            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int inputLottoPurchaseMoney() {
        lottoMoney = Integer.parseInt(Console.readLine());
        validateMoneyInput(lottoMoney);
        return lottoMoney;
    }

    public int getLottoChance(int money) {
        return lottoMoney / PRICE_PER_LOTTO;
    }

    public List<Integer> createWinningNumber() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String value : inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(value));
        }
        return winningNumbers;
    }

    // 보너스 숫자를 입력해 int 형으로 반환함
    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    // 한 게임의 로또 번호를 자동으로 생성해서 Integer List를 반환
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


    public void compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        /*
        1. count 1 일때, 2등 // 보너스 포함 6개 맞춘거
        2. count 2 일때, 4등 // 보너스 포함 5개 맞춘거
        3. count 3 일때, 5등 // 보너스 포함 4개 맞춘거
         */
        if(lottoNumbers.contains(bonusNumber)){ // 일단 여기에 걸리면 1등은 불가능
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());
            judgeLottoRank(result, bonusNumber);
        }
        /*
        1. 1등, 3등, 4등, 5등 가능
        2. count 0 일떄, 1등
        3. count 1 일떄, 3등
        4. count 2 일떄, 4등
        5. count 3 일떄, 5등
         */
        if(!lottoNumbers.contains(bonusNumber)){
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());
            judgeLottoRank(result, bonusNumber);
        }
    }
    private void judgeLottoRank(List<Integer> result, int bonusNumber) {
        if (result.size() == 0) {
            lottoResult.set(0, lottoResult.get(0)+1);
        }
        if (result.size() == 1 && result.contains(bonusNumber)) {
            lottoResult.set(1, lottoResult.get(1)+1);
        }
        if (result.size() == 1 && !result.contains(bonusNumber)) {
            lottoResult.set(2, lottoResult.get(2)+1);
        }
        if (result.size() == 2) {
            lottoResult.set(3, lottoResult.get(3)+1);
        }
        if (result.size() == 3) {
            lottoResult.set(4, lottoResult.get(4)+1);
        }
    }

}
