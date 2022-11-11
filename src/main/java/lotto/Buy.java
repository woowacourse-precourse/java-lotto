package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Buy {
    private final int price;
    
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
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            printNumbers(numbers,i,lottoCount);
        }
    }

    private int priceToCount(int price){
        int randomLottoCount = price / 1000;

        return randomLottoCount;
    }



    private void printNumbers(List<Integer> numbers,int count,int totalCount){
        if(count == 1 ) System.out.println(totalCount+"개를 구매했습니다.");
        System.out.println(numbers);
    }

}
