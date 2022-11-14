package lotto;

public class LottoResult {

public int sum;

    //수익률 계산
    public double getReturn(){
        int sum = 0;
        PrizeEnum[] values = PrizeEnum.values();
        for (PrizeEnum i : values) {
            sum += i.getCount() * i.getPrize();
        }
        return sum;
    }}