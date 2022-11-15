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
        return money;
    }

    public int howManyLotto(int money){
        int totalCount = money / purchaseMoney;
        return totalCount;
    }

    public List<Integer> LottoGenerator(int count){
        System.out.printf("%d개를 구매하였습니다.\n", count);
        List<Integer> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
            Lotto newLotto = new Lotto(numbers);
            System.out.println(numbers);
            lottoList.add(newLotto);
        }
        return lottoList;
    }

    public List<Integer> inputNumber(){
        ArrayList<Integer> winningNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        String[] arr = Console.readLine().split(", ");
        for (String num : arr){
            winningNumber.add(Integer.parseInt(num));
        }
        Collections.sort(winningNumber);

        return winningNumber;
    }

    public List<Integer> bonusNumber(){
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }


    public int getMatch(List<Integer> lotto, List<Integer> winning){
        int match = 0;
        for(int i=0; i<lotto.size(); i++){
            if(winning.contains(lotto.get(i)))
                match += 1;
        }
        return match;
    }

    public int getMatchBonus(List lotteryList, int bonus){
        int match = 0;
        for(int i=0; i<lotteryList.size(); i++){
            if(lotteryList.contains(lotteryList.get(i)))
                match += 1;
        }
        return match;
    }

    public List<List> compareNumbers(List<List> userList, List<Integer> winList, int bonus){
        List<List> LotteryResult = new ArrayList<>();

        int lottoCount = 0;
        int bonusCount = 0;
        for (int i = 0; i < userList.size(); i++){
            bonusCount = 0;
            lottoCount = getMatch(userList.get(i), winList);
            if (lottoCount != 6){
                bonusCount = getMatchBonus(userList.get(i), bonus);
            }
            LotteryResult.add(comparResultLottery(lottoCount, bonusCount));
        }
        return LotteryResult;
    }

    public List<Integer> comparResultLottery(int lottoCount, int bonusCount){
        Integer[] account = {0,0,0,0,0};

        if(lottoCount == 6){
            account[0] ++; //1등
        }
        if(bonusCount == 1 && lottoCount == 5){
            account[1] ++; //2등
        }
        if(bonusCount == 0 && lottoCount == 5){
            account[2] ++; //3등
        }
        if(lottoCount == 4){
            account[3] ++; //4등
        }
        if(lottoCount == 3){
            account[4] ++; //5등
        }
        List<Integer> accountLoterry = Arrays.asList(account);

        return accountLoterry;
    }

    public List<Integer> getResult(List<List> userResult){

    }
}
