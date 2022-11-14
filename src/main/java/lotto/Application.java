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

        Integer twoPlaceCount = 0; // 2등 처리를 위해 생성
        Map<Integer, Integer> matchingInfo = new HashMap<Integer, Integer>();
        for(int i=0; i<=6; i++){
            matchingInfo.put(i, 0);
        }

        for(Lotto lotto: buyLottos){
            Integer correspondCount = matchingCount(lotto);
            if(correspondCount == 5 && lotto.contains(bonusNumber)){
                twoPlaceCount++;
            }
            if(correspondCount > 2){
                matchingInfo.put(correspondCount , matchingInfo.get(correspondCount) + 1);
            }
        }

        printMatchingInfo(matchingInfo, twoPlaceCount);

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

    public static void printMatchingInfo(Map<Integer, Integer> rankInfo, Integer twoPlaceCount){

        for(Integer key : rankInfo.keySet()){
            switch (key){
                case 3:
                    System.out.println(matchingAmount(key, "5,000원",rankInfo.get(key), 5));
                    break;
                case 4:
                    System.out.println(matchingAmount(key, "50,000원",rankInfo.get(key), 4));
                    break;
                case 5:
                    System.out.println(matchingAmount(key, "1,500,000원",rankInfo.get(key)-twoPlaceCount, 3));
                    System.out.println(matchingAmount(key, "30,000,000원",twoPlaceCount, 2));
                    break;
                case 6:
                    System.out.println(matchingAmount(key, "2,000,000,000원",rankInfo.get(key), 1));
                    break;
            }
        }

    }



}
