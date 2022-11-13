package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buy {
    private final int price;
    private List<Integer> randomLottos =new ArrayList<>();

    public Buy(int price) {
        this.price = price;
        validata(price);
        pickRandomLotto(price);
    }

    private void validata(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void pickRandomLotto(int price){
        int lottoCount = priceToCount(price);
        for(int i =0;i<lottoCount;i++){
            List<Integer> selectionNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            //System.out.println(selectionNumbers);
            storeNumbers(selectionNumbers);
        }

    }

    private void storeNumbers(List<Integer> selectionNumbers){
        for(int i =0;i<6;i++){
            this.randomLottos.add(selectionNumbers.get(i));
        }
    }

    private int priceToCount(int price){
        int randomLottoCount = price / 1000;

        return randomLottoCount;
    }

    public void printRandomLotto(){
        System.out.println(randomLottos.size()/6+"개룰 구매했습니다.");
        for(int i = 0 ; i< randomLottos.size()/6 ; i++){
            System.out.print("[");
            printSixRange(i);
        }
        System.out.println();
    }

    public void printSixRange(int row){
        for(int j=row*6 ; j<(row+1)*6 ; j++){
            System.out.print(randomLottos.get(j));
            if(j%6 < 5) System.out.print(",");
        }
        System.out.println("]");
    }
}
