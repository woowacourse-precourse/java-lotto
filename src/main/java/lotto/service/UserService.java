package lotto.service;

public class UserService {

    public String calculateTheRateOfReturn(int prizeMoney, int purchaseMoney) {
        float rateOfReturn = ((float) prizeMoney / (float) purchaseMoney) * 100;
        return String.format("%.1f", rateOfReturn);
    }
}
