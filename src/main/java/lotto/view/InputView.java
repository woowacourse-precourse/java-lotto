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

    List<Integer> totalRank = Arrays.asList(0, 0, 0, 0, 0);

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

        if(lottoNumbers.contains(bonusNumber)){ // 일단 여기에 걸리면 1등은 불가능
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());

            System.out.println("여기 보너스 넘버 걸린 리스트임" +result);
        }
        // 여기에 걸리면 5,4,3,1등을 할 수 있다
        if(!lottoNumbers.contains(bonusNumber)){
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());

            System.out.println("여기 보너스 넘버 안 걸린 리스트임" +result);
        }



    }

    // 당첨 번호를 입력하는 메소드

}
