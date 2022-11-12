package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buy {
    private final int price;
    private List<Integer> numbers =new ArrayList<>();

    public Buy(int price) {
        this.price = price;
        validata(price);
        randomNumbers(price);
    }

    private void validata(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void randomNumbers(int price){
        int lottoCount = priceToCount(price);
        for(int i =0;i<lottoCount;i++){
            List<Integer> addNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
        }
        //메소드를 분리하여 구현한다.
        // 자바컨벤션을 지키기 위해.
        for(int i =0;i<6;i++){
            this.numbers.add(addNumber.get(i));
            printRandomLotto(numbers,i,lottoCount);
        }
    }

    private int priceToCount(int price){
        int randomLottoCount = price / 1000;

        return randomLottoCount;
    }



    private void printRandomLotto(List<Integer> numbers,int count,int totalCount){
        if(count == 1 ) System.out.println(totalCount+"개를 구매했습니다.");
        System.out.println(numbers);
    }

}
