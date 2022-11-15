package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer COUNT = 6;

    private static final Integer purchaseMoney = 1000;

    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoGenerator(){
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);

        return lottoNumbers;
    }

    public String inputMoney(){
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public int howManyLotto(int money){
        int totalCount = money / purchaseMoney;
        return totalCount;
    }

    public ArrayList<Integer> inputNumber(){
        ArrayList<Integer> winningNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        String[] arr = Console.readLine().split(", ");
        for (String num : arr){
            winningNumber.add(Integer.parseInt(num));
        }
        return winningNumber;
    }

    public Integer bonusNumber(){
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }





}
