package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer COUNT = 6;

    private static final Integer purchaseMoney = 1000;

    private List<Integer> lottoNumbers = new ArrayList<>();



    public Integer inputMoney(){
        System.out.println("구입금액을 입력해 주세요");
        int money = Integer.parseInt(Console.readLine());
        Check.validateMoney(money);
        Check.validateMoney(money);

        return money;
    }

    public int howManyLotto(int money){
        int totalCount = money / purchaseMoney;
        return totalCount;
    }

    public List<List> makeLottery(int count){
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<List> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
            Check.validateBoundary(numbers);
            Lotto newLotto = new Lotto(numbers);
            System.out.println(numbers);
            lottoList.add(numbers);
        }

        return lottoList;
    }

    public List<Integer> inputNumber(){
        ArrayList<Integer> winningNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        String[] arr = Console.readLine().split(",");
        for (String num : arr){
            winningNumber.add(Integer.parseInt(num));
        }
        Collections.sort(winningNumber);
        Check.validateSixNumber(winningNumber);
        return winningNumber;
    }
    public Integer bonusNumber(){
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        Check.validateBonusBoundary(bonusNumber);
        return bonusNumber;
    }

}
