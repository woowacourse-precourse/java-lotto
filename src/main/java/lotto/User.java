package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

enum Score{
    zero(0,0), six(6,2_000_000_000), fifth(5,30_000_000), fifthBonus(55,1_500_000), fourth(4,50_000), third(3,5_000);

    int value;
    int money;
    Score(int value,int money){
        this.value = value;
        this.money = money;
    }

    public static Score getWinValue(int num) {
        for (Score winValue : Score.values()) {
            if (winValue.value == num) {
                return winValue;
            }
        }
        return null;
    }
    public int getMoney() {
        return money;
    }
}

public class User {
    public List<Lotto> userLotto = new ArrayList<>();
    public int correctLottoNum;
    public void getUserLotto(int price){
        int lottoCount = price/1000;
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());

            userLotto.add(new Lotto(sortedList));
        }

    }
    public void printUserLotto(int price){
        int lottoCount = price/1000;
        Message.printLottoCountMessage(lottoCount);

        for(int i=0; i<lottoCount; i++){
            List<Integer> printList = userLotto.get(i).printLottoNumber();
            System.out.println(printList);
        }
    }

    public void printWinningResult(List<Integer> lottoAnswer,String bonusNumber){
        HashMap<Score,Integer> hm = new HashMap<>();
        hm.put(Score.third,0);
        hm.put(Score.fourth,0);
        hm.put(Score.fifth,0);
        hm.put(Score.fifthBonus,0);
        hm.put(Score.six,0);

        for(int i=0; i<userLotto.size();i++){
            Lotto userLottoCase = userLotto.get(i);
            Score score = calculatorResult(userLottoCase.printLottoNumber(),lottoAnswer,bonusNumber);
            if(hm.containsKey(score)) {
                hm.put(score, hm.get(score) + 1);
                correctLottoNum += score.getMoney();
            }
        }
        Message.printResultMessage(hm);
    }

    public Score calculatorResult(List<Integer> userLottoCase,List<Integer> lottoAnswer,String bonusNumber){
        int bonusNum = Integer.parseInt(bonusNumber);
        int count=0;
        for(Integer a : userLottoCase) {
            if(lottoAnswer.contains(a)) {
                count++;
            }
        }
        if(count == 5 && lottoAnswer.contains(bonusNum)){
            count=55;
        }

        return Score.getWinValue(count);
    }
    public void printWinningRatio(int correctLottoNum,int purchasePrice){
        Message.printWinningRatioMessage(((double)correctLottoNum/purchasePrice*100));
    }
}
