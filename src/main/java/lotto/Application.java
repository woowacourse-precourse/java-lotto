package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.*;

public class Application {
    public static String checkBonus(List<Integer> wnum){
        if(getBonus(bonusNum(),wnum)){
            return("5b");
        }
        return("5");
    }

    public static void main(String[] args) {
        List<List<Integer>> lotto = new ArrayList<>();
        List<String> winCheck = new ArrayList<>();
        int i = 0;
        int buy = buyLotto();
        for(i = 0; i < buy; i++){
            lotto.add(generateLotto());
        }
        System.out.println("");
        System.out.println((i)+"개를 구매했습니다.");
        for(List<Integer> number : lotto){
            printLotto(number);
        }
        List<Integer> winNum = winner();
        for(List<Integer> wnum : lotto){
            winCheck.add(String.valueOf(getWin(wnum,winNum)));
        }
        if(winCheck.contains("5")){
            winCheck.set(winCheck.indexOf("5"), checkBonus(lotto.get(winCheck.indexOf("5"))));
        }
        calculate(winCheck);
        calculateEarn(winCheck);
    }
}
