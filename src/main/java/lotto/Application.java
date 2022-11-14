package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CommonContent.PrintError.*;
import static lotto.CommonContent.PrintLottoContent.*;

public class Application {

    private static List<Lotto> buyLottoList;
    private static Lotto winningLotto;
    private static Integer bonusNumber;

    public static void main(String[] args) {
        byeLotto();
        createWinningNumbers();
        createBonusNumber();
    }

    public static void byeLotto(){

        System.out.println(PURCHASEAMOUNT.getPrintStatement());
        Integer byeMoney = Integer.parseInt(readLine());
        Integer purchaseNumbers = byeMoney/1000;

        if(purchaseNumbers == 0){
            throw new IllegalArgumentException(NOBYELOTTOERROR.getPrintStatement());
        }else if(byeMoney%1000 != 0){
            throw new IllegalArgumentException(PURCHASEAMOUNTERROR.getPrintStatement());
        }
        System.out.println("\n" + CommonContent.PrintLottoContent.purchaseNumbers(purchaseNumbers));
        createLotto(purchaseNumbers);
    }

    public static void createLotto(Integer purchaseNumbers){
        buyLottoList = new ArrayList<Lotto>();
        for(int i=0; i<purchaseNumbers; i++){
            buyLottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(buyLottoList.get(i).getNumbers());
        }
    }

    public static void createWinningNumbers(){
        System.out.println("\n" + WINNINGNUMBER.getPrintStatement());

        try {
            List<Integer> winsNumber = Arrays.stream(readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            winningLotto = new Lotto(winsNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(WINNUMBERSERROR.getPrintStatement());
        }
    }

    public static void createBonusNumber(){
        System.out.println("\n" + BONUSNUMBER.getPrintStatement());
        try {
            bonusNumber = Integer.parseInt(readLine());
            if(bonusNumber > 46 && bonusNumber < 0){
                throw new IllegalArgumentException(BONUSNUMBERERROR.getPrintStatement());
            }
        }catch (Exception e){
            throw new IllegalArgumentException(BONUSNUMBERERROR.getPrintStatement());
        }
    }

}
