package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.resource.ErrorResource;
import lotto.resource.Resource;

import java.util.*;

import static lotto.resource.ErrorResource.charIsNotNumber;

public class Game {

    private static final String notThousand = " 구입금액은 천원 단위여야합니다.";
    private static final String notNumber = " 구입금액은 숫자여야합니다.";
    private static final char zero = '0';
    private static final char nine = '9';
    private static final int unit = 1000;
    public void gameStart() {
        System.out.println(Resource.greetings);
        String purchase = Console.readLine();
        List<Lotto> lottoNumbers = showBoughtNumbers(purchase);
        WinningNumber winningNumber = makeWinningNumber();
        int totalBill=getResult(lottoNumbers, winningNumber);
        float revenuePercent = getRevenuePercent(purchase,totalBill);
        System.out.print(Resource.revenuePercentFront+revenuePercent);
        System.out.println(Resource.revenuePercentBack);
    }

    private int getResult(List<Lotto> lottoNumbers, WinningNumber winningNumber) {
        int totalBill =0;
        JudgeMent judgeMent = new JudgeMent();
        judgeMent.setCorrectResult(lottoNumbers, winningNumber);
        System.out.println(Resource.resultOfWinning);
        totalBill = getTotalBill(totalBill, judgeMent);
        return totalBill;
    }

    private int getTotalBill(int totalBill, JudgeMent judgeMent) {
        Map<Reward,Integer> result = judgeMent.getCorrectResult();
        Iterator<Reward> keys = result.keySet().iterator();
        while(keys.hasNext()){
            Reward key = keys.next();
            showResult(result,key);
            if(result.get(key)!=0){
                String bill = key.getBIll().replaceAll(",","");
                totalBill +=(Integer.parseInt(bill));
            }
        }
        return totalBill;
    }

    private void showResult(Map<Reward, Integer> result, Reward key) {
        if(key.getNumber()==0){
            return;
        }
        System.out.print(key.getNumber()+Resource.countOfCorrectNumberFront);
        if(key.getBIll() == Reward.FIVE_BONUS.getBIll()){
            System.out.print(Resource.bonusCorrect);
        }
        System.out.print(Resource.afterBonus);
        System.out.print(key.getBIll()+Resource.countOfCorrectNumberMiddle);
        System.out.println(result.get(key)+Resource.countOfCorrectNumberBack);
    }

    public float getRevenuePercent(String purchase,int bill){
        float originalPurchase = Float.parseFloat(purchase);
        float totalBill = (float)bill/originalPurchase;
        totalBill *=1000.0;
        totalBill = Math.round(totalBill);
        totalBill /=10.0;
        return totalBill;
    }

    private WinningNumber makeWinningNumber() {
        System.out.println(Resource.inputOfWinningNumber);
        String winNumber = Console.readLine();
        System.out.println(Resource.inputOfBonusNumber);
        String bonusNumber = Console.readLine();
        for(int i=0;i<bonusNumber.length();i++) {
            checkIfCharIsNumber(bonusNumber.charAt(i));
        }
        return new WinningNumber(winNumber, Integer.parseInt(bonusNumber));
    }

    private List<Lotto> showBoughtNumbers(String purchase) {

        int lottoUnit = checkIfDivideWithThousand(purchase);
        System.out.println(lottoUnit + Resource.countOfBuying);
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoUnit; i++) {
            Lotto lotto = getLotto(lottoNumbers);
            System.out.println(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    private Lotto getLotto(List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
        return lotto;
    }

    public int checkIfDivideWithThousand(String purchase) {
        try {
            int purchaseBill = Integer.parseInt(purchase);
            if (purchaseBill % unit != 0) {
                throw new IllegalArgumentException(ErrorResource.errorStart + notThousand);
            }
            return purchaseBill / unit;
        } catch (NumberFormatException e) {
            System.out.println(ErrorResource.errorStart+notNumber);
            throw new IllegalArgumentException(ErrorResource.errorStart + notNumber);
        }
    }

    private void checkIfCharIsNumber(char c){
        if(c<zero || c>nine){
            throw new IllegalArgumentException(ErrorResource.errorStart+ charIsNotNumber);
        }
    }


}
