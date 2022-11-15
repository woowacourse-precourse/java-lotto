package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class LottoWin {
    static LottoWin lotto;
    private List<Integer> lottoNum;

    public List<int[]> expenseWithprofit = new ArrayList<int[]>();

    private LottoWin(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        List<Integer> numbers = convertStringToInt(userInput);
        System.out.println("보너스 번호를 입력해 주세요.");
        numbers.add(Integer.valueOf(Console.readLine()));
        this.lottoNum = numbers;
    }

    public static LottoWin getInstance() {
        if(lotto == null){ //최초 한번만 new 연산자를 통하여 메모리에 할당한다.
            lotto = new LottoWin();
        }
        return lotto;
    }

    public static List<Integer> convertStringToInt(String input){
        String[] inputSplit = input.split(",");
        List<Integer> returnData = new ArrayList<Integer>();
        for(int index = 0; index < inputSplit.length; index++){
            returnData.add(Integer.valueOf(inputSplit[index]));
        }
        return returnData;
    }
    public void addExpenseWithprofit(int[] inputData){
        this.expenseWithprofit.add(inputData);
    }
//    수익률은 당첨금액/구입금액*100
    public void profitRateCal(){
        final int expenseIndex = 0;
        final int profitIndex = 1;
        double profitRate;
        int expenseSum = 0;
        int profitSum = 0;
        for(int[] userInfo : this.expenseWithprofit){
            expenseSum += userInfo[expenseIndex];
            profitSum += userInfo[profitIndex];
        }
        profitRate = ((double)profitSum / expenseSum) * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }
    public int[] countWinLotto(){
        List<Integer> profitTable = List.of(0,5000,50000,1500000,30000000,2000000000);
        int[] returnData = new int[profitTable.size()];
        final int profitIndex = 1;
        for(int i = 0; i < this.expenseWithprofit.size(); i++){
            int addIndex = profitTable.indexOf(this.expenseWithprofit.get(i)[profitIndex]);
            returnData[addIndex] += 1;
        }
        return returnData;
    }

    public List<Integer> getLottoNum() {
        return lottoNum;
    }
}
