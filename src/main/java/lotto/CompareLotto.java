package lotto;

import static lotto.Lotto.bonusNumberList;
import static lotto.Lotto.getMyLottoList;
import static lotto.Lotto.myLottoList;
import static lotto.Lotto.theNumberOfLotto;
import static lotto.Lotto.winnerNumberList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompareLotto {

    private static int first, second, third, fourth, fifth;

    public static void compareLotto() throws IOException {
        for (int i = 0; i < theNumberOfLotto(); i++) {
            if(getMyLottoList().contains(bonusNumberList)){
                getMyLottoList().get(i).retainAll(winnerNumberList);
                int checkLotto = getMyLottoList().get(i).size();
                if(checkLotto == 3){
                    fifth++;
                }
                if(checkLotto == 4){
                    fourth++;
                }
                if(checkLotto == 5){
                    second++;
                }
                if(checkLotto == 6){
                    first++;
                }
            }
            if(!getMyLottoList().contains(bonusNumberList)){
                getMyLottoList().get(i).retainAll(winnerNumberList);
                int checkLotto = getMyLottoList().get(i).size();
                if(checkLotto == 3){
                    fifth++;
                }
                if(checkLotto == 4){
                    fourth++;
                }
                if(checkLotto == 5){
                    third++;
                }
                if(checkLotto == 6){
                    first++;
                }
            }

        }
    }

    public static void printCompareLotto(){ // 구입한 로또와 1등 로또와 숫자 비교

        System.out.println("3개 일치 (5,000원) - " + fifth);
        System.out.println("4개 일치 (50,000원) - " + fourth);
        System.out.println("5개 일치 (1,500,000원) - " + third);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + second);
        System.out.println("6개 일치 (2,000,000,000) - " + first);
    }



//    public double rateOfReturn(UserInputMoney, int earnedMoney){ // 소숫점 둘째자리에서 반올림 Math.floor Math.ceil 사용해야하나?
//
//        return inputMoney / earnedMoney;
//    }

}

// myLottoList -> n개의 로또 번호 생성 myLotooList.get(i).get(j) 와 winnerNumberList.get(i)랑 비교
// myLottoList -> n개의 로또 번호 생성 myLotooList.get(i).get(j) 와 bonusNumberList.get(i)랑 비교

// winnerNumberList -> 입력한 6개의 로또 값
// bonusNumberList -> 보너스넘버 1개 ArrayList
