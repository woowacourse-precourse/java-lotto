package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Const;
import lotto.validator.BuyerValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Buyer {
    private final int[] collectCounts = {6,5,5,4,3};
    private final String[] bonusStrings = {" ",", 보너스 볼 일치 "," "," "," "};

    public List<Lotto> haveLotto = new ArrayList<>();
    private long haveMoney;
    private int haveCount;

    private int[] winningCounts = new int[5];
    private long totalPrizeMoney;
    private double yield;

    public Buyer(){

    }

    public void buy() throws IllegalArgumentException{
        inputPurchaseMoney();
        afterPurchaseLotto();
    }

    public void inputPurchaseMoney() throws IllegalArgumentException{
        System.out.println(Const.BUY_LOTTO_MESSAGE);
        String inputMoney = Console.readLine();
        inputMoneyToHaveMoney(inputMoney);
        System.out.println();
    }

    public void afterPurchaseLotto(){
        haveLottoCount();
        registMyLotto();
        printHaveCount();
        printHaveLotto();
    }

    public void checkResult(ResultPresenter result){
        confirmMyLotto(result);
        calculateTotalPrizeMoney();
        calculateYield();
    }

    public void printLottoResult(){
        printStatistics();
    }

    public void inputMoneyToHaveMoney(String inputMoney) throws IllegalArgumentException{
        BuyerValidator.checkIsNum(inputMoney);
        haveMoney = Long.valueOf(inputMoney).intValue();
        BuyerValidator.checkIsMultipleThousand(haveMoney);
    }

    public void haveLottoCount(){
        haveCount = (int)haveMoney/Const.LOTTO_COST;
    }

    public void registMyLotto(){
       // need to refactoring
        if(!haveLotto.isEmpty()) haveLotto = Publisher.publishLotto(haveLotto,haveCount);
        else if(haveLotto.isEmpty()) haveLotto = Publisher.publishLotto(haveCount);
    }

    public void confirmMyLotto(ResultPresenter result){
        for(Lotto myLotto : getHaveLotto()){
            int collectCount = 0;
            int bonusCount = 0;

            List<Integer> myLottoNum = myLotto.returnLottoNumbers();
            collectCount = (int)myLottoNum.stream().filter(result.winnerNumbers::contains).count();

            if(myLottoNum.contains(result.bonusNumber)) bonusCount++;

            int winningCountIndex = returnWinningCount(collectCount, bonusCount);
            if(winningCountIndex != -1) winningCounts[winningCountIndex]++;
        }
    }

    public int returnWinningCount(int collectCount, int bonusCount){
        if(collectCount==6) return 0;
        if(collectCount==5 && bonusCount==1) return 1;
        if(collectCount==5) return 2;
        if(collectCount==4) return 3;
        if(collectCount==3) return 4;

        return -1;
    }

    public void calculateTotalPrizeMoney(){
        for(int rank=0; rank<winningCounts.length; rank++)
            totalPrizeMoney += winningCounts[rank] * Long.valueOf(WinningMoney.values()[rank].getValue().replaceAll(",",""));
    }

    public void calculateYield(){
        yield = Math.round(((float)getTotalPrizeMoney()/getHaveMoney()*100)*10)/10.0;
    }

    public void printHaveCount(){
        System.out.println(getHaveCount()+Const.PRINT_PURCHASED_LOTTO);
    }

    public void printHaveLotto(){
        for(Lotto printLotto : getHaveLotto()) {
            // 메서드 분리하기
            List<Integer> lottoNumbers = new ArrayList<>(printLotto.returnLottoNumbers());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void printStatistics(){
        System.out.println(Const.PRINT_STATISTICS);
        System.out.println("---");
        for(int rank=4; rank>=0; rank--){
            System.out.printf("%d개 일치%s(%s원) - %d개%n",collectCounts[rank],bonusStrings[rank],
                    WinningMoney.values()[rank].getValue(),winningCounts[rank]);
        }
        System.out.println("총 수익률은 "+getYield()+"%입니다.");
    }

    public long getHaveMoney(){
        return haveMoney;
    }
    public int getHaveCount(){
        return haveCount;
    }

    public List<Lotto> getHaveLotto(){
        return haveLotto;
    }
    public long getTotalPrizeMoney() { return totalPrizeMoney;}
    public double getYield() { return yield; }

    enum WinningMoney{
        FIRST_WINNINGS("2,000,000,000"), SECOND_WINNINGS("30,000,000"), THIRD_WINNINGS("1,500,000"),
        FOURTH_WINNINGS("50,000"), FIFTH_WINNINGS("5,000");

        public final String value;
        WinningMoney(String value){this.value = value;}
        public String getValue(){ return value; }
    }
}
