package lotto.ui;

import java.util.List;

public class LotteryView implements View {
    private int lottoNumber;
    private List<List<Integer>> lotteries;

    public LotteryView(int lottoNumber, List<List<Integer>> lotteries){
        this.lottoNumber = lottoNumber;
        this.lotteries = lotteries;
    }
    @Override
    public void makeView(){
        printNumberOfLotteries();
        printAllLotteries();
    }

    private void printNumberOfLotteries(){
        System.out.println(lottoNumber + "개를 구매했습니다.");
    }

    private void printAllLotteries(){
        for(List<Integer> lottoNumbers: lotteries){
            System.out.println(lottoNumbers);
        }
    }

}

