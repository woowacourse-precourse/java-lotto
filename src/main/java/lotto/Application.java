package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CommonContent.PrintError.*;
import static lotto.CommonContent.PrintLottoContent.*;

public class Application {

    private static List<Lotto> buyLottos;
    private static Lotto winningLotto;
    private static Integer bonusNumber;

    public static void main(String[] args) {
        byeLotto();
        createWinningNumbers();
        createBonusNumber();

        winningStatistics();
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
        buyLottos = new ArrayList<Lotto>();
        for(int i=0; i<purchaseNumbers; i++){
            buyLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(buyLottos.get(i).getNumbers());
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

    public static void winningStatistics(){
        System.out.println("\n" + WINNINGSTATISTICS.getPrintStatement());

        Map<Integer, Integer> correspondCounts = new HashMap<Integer, Integer>();
        for(int i=3; i<=6; i++){
            correspondCounts.put(i, 0);
        }

        for(Lotto lotto: buyLottos){
            Integer correspondCount = CalculationRank(lotto);
            if(correspondCount > 2){
                correspondCounts.put(correspondCount , correspondCounts.get(correspondCount) + 1);
            }
        }

    }

    public static Integer CalculationRank(Lotto lotto){

        Integer correspondCount = 0;

        for(Integer number : lotto.getNumbers()){
            if(winningLotto.contains(number)){
                correspondCount ++;
            }
        }

        return correspondCount;
    }

}
