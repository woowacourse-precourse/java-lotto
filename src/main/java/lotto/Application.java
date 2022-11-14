package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CommonContent.PrintLottoContent.PURCHASEAMOUNT;

public class Application {

    private static List<Lotto> lottoList;

    public static void main(String[] args) {
        byeLotto();
    }

    public static void byeLotto(){
        try{
            System.out.println(PURCHASEAMOUNT.getPrintStatement());
            Integer purchaseNumbers = Integer.parseInt(readLine())/1000;

            if(purchaseNumbers == 0){
                throw new IllegalArgumentException();
            }
            System.out.println("\n" + CommonContent.PrintLottoContent.purchaseNumbers(purchaseNumbers));
            createLotto(purchaseNumbers);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public static void createLotto(Integer purchaseNumbers){
        lottoList = new ArrayList<Lotto>();
        for(int i=0; i<purchaseNumbers; i++){
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(lottoList.get(i).getNumbers());
        }
    }

}
