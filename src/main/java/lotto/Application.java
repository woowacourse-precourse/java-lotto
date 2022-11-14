package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CommonContent.PrintError.*;
import static lotto.CommonContent.PrintLottoContent.*;

public class Application {

    private static Integer buyAmount;
    private static List<Lotto> byeLottos;
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
        Integer purchaseNumbers = 0;
        try{
            buyAmount = Integer.parseInt(readLine());
            purchaseNumbers = buyAmount/1000;
        }catch (Exception e) {
            throw new IllegalArgumentException(BYEMONEYFORMERROR.getPrintStatement());
        }

        if(purchaseNumbers == 0){
            throw new IllegalArgumentException(NOBYELOTTOERROR.getPrintStatement());
        }else if(buyAmount%1000 != 0){
            throw new IllegalArgumentException(PURCHASEAMOUNTERROR.getPrintStatement());
        }
        System.out.println("\n" + CommonContent.PrintLottoContent.purchaseNumbers(purchaseNumbers));
        createLotto(purchaseNumbers);
    }

    public static void createLotto(Integer purchaseNumbers){
        byeLottos = new ArrayList<Lotto>();
        for(int i=0; i<purchaseNumbers; i++){
            byeLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(byeLottos.get(i).getNumbers());
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
            }else if(winningLotto.contains(bonusNumber)){
                throw new IllegalArgumentException(BONUSNUMBEROVERLAPERROR.getPrintStatement());
            }
        }catch (Exception e){
            throw new IllegalArgumentException(BONUSNUMBERERROR.getPrintStatement());
        }
    }

    public static void winningStatistics(){
        System.out.println("\n" + WINNINGSTATISTICS.getPrintStatement());

        Integer twoPlaceCount = 0; // 2등 처리를 위해 생성
        Map<Integer, Integer> matchingInfo = new HashMap<Integer, Integer>();
        for(int i=0; i<=6; i++){
            matchingInfo.put(i, 0);
        }

        for(Lotto lotto: byeLottos){
            Integer correspondCount = matchingCount(lotto);
            if(correspondCount == 5 && lotto.contains(bonusNumber)){
                twoPlaceCount++;
            }
            if(correspondCount > 2){
                matchingInfo.put(correspondCount , matchingInfo.get(correspondCount) + 1);
            }
        }

        printMatchingInfo(matchingInfo, twoPlaceCount);
        calculationProfit(matchingInfo, twoPlaceCount);
    }



    public static Integer matchingCount(Lotto lotto){

        Integer correspondCount = 0;

        for(Integer number : lotto.getNumbers()){
            if(winningLotto.contains(number)){
                correspondCount++;
            }
        }

        return correspondCount;
    }

    public static void printMatchingInfo(Map<Integer, Integer> matchingInfo, Integer twoPlaceCount){

        for(Integer key : matchingInfo.keySet()){
            switch (key){
                case 3:
                    System.out.println(matchingAmount(key, "5,000원",matchingInfo.get(key), 5));
                    break;
                case 4:
                    System.out.println(matchingAmount(key, "50,000원",matchingInfo.get(key), 4));
                    break;
                case 5:
                    System.out.println(matchingAmount(key, "1,500,000원",matchingInfo.get(key)-twoPlaceCount, 3));
                    System.out.println(matchingAmount(key, "30,000,000원",twoPlaceCount, 2));
                    break;
                case 6:
                    System.out.println(matchingAmount(key, "2,000,000,000원",matchingInfo.get(key), 1));
                    break;
            }
        }
    }

    private static void calculationProfit(Map<Integer, Integer> matchingInfo, Integer twoPlaceCount) {

        double frofit = 0;
        for(Integer key : matchingInfo.keySet()){
            switch (key){
                case 3:
                    frofit += matchingInfo.get(key)*5000;
                    break;
                case 4:
                    frofit += matchingInfo.get(key)*50000;
                    break;
                case 5:
                    frofit += matchingInfo.get(key)*1500000;
                    frofit += matchingInfo.get(key)*30000000;
                    break;
                case 6:
                    frofit += matchingInfo.get(key)*2000000000;
                    break;
            }
        }
        System.out.println(profitReturn(frofit/(double)buyAmount*100 * 100 / 100.0));
    }

}
