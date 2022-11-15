package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buy {
    private final int price;
    private static List<Integer> randomLottos =new ArrayList<>();

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

    public void printRandomLottos() {
        System.out.println(randomLottos.size()/6+"개를 구매했습니다.");
        for (int i = 0; i < randomLottos.size() / 6; i++) {
            result.printSixRange(randomLottos,i);
        }
    }
    public static List<Integer> compareRandomLottos(){
        return randomLottos;
    }
        // 6번 반복, result class로 옮기기.
    }
