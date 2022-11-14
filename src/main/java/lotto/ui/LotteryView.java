package lotto.ui;

import java.util.List;
import lotto.model.Lotto;

public class LotteryView implements View {

    private final List<Lotto> lotteries;
    private final int lotteriesCount;

    public LotteryView(int lottoNumber, List<Lotto> lotteries){
        this.lotteriesCount = lottoNumber;
        this.lotteries = lotteries;
    }

    @Override
    public void makeView(){
        print();
    }

    private void print(){
        printNumberOfLotteries();
        printAllLotteries();
    }
    private void printNumberOfLotteries(){
        System.out.println(lotteriesCount + "개를 구매했습니다.");
    }

    private void printAllLotteries(){
        for(Lotto lottoNumbers: lotteries){
            System.out.println(lottoNumbers.getNumbers());
        }
    }

}

