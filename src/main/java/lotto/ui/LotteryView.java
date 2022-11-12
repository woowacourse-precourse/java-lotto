package lotto.ui;

import java.util.List;

public class LotteryView {

    public void makeLotteryView(int lottoNumber, List<List<Integer>> lotteries){
        printNumberOfLotteries(lottoNumber);
        printAllLotteries(lotteries);
    }

    private void printNumberOfLotteries(int lottoNumber){
        System.out.println(lottoNumber + "개를 구매했습니다.");
    }

    private void printAllLotteries(List<List<Integer>> lotteries){
        for(List<Integer> lottoNumbers: lotteries){
            System.out.println(lottoNumbers);
        }
    }

}

