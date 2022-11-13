package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
            userLotto.add(new Lotto(numbers));
        }
    }
    public void printUserLotto(int price){
        int lottoCount = price/1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
        for(int i=0; i<lottoCount; i++){
            System.out.println(userLotto.get(i).printLottoNumber());
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

        System.out.println("3개 일치 (5,000원) - "+ hm.get(Score.third) +"개");
        System.out.println("4개 일치 (50,000원) - "+ hm.get(Score.fourth) +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ hm.get(Score.fifth) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ hm.get(Score.fifthBonus) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ hm.get(Score.six) +"개");
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
        System.out.println("총 수익률은 "+String.format("%.2f",(double)correctLottoNum/purchasePrice*100)+"%입니다.");
    }
}
