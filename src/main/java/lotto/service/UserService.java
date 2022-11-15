package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.Constant;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private User user;
    private LottoSystemService lottoSystemService;
    private float revenue;


    public void setPayMent() {
        String payMent;

        payMent = Console.readLine();

        user = new User(payMent);
    }

    public LottoSystemService buyLotto() {
        lottoSystemService = new LottoSystemService();
        lottoSystemService.setRandomLottoNumbers(user);
        return lottoSystemService;
    }

    public List<List<Integer>> getUserLottoNumber() {
        return user.getUserLottoNumber();
    }

    public void setRevenue() {
        int payAmount = user.getUserPayAmount();
        List<Integer> hit = lottoSystemService.getHitCount();
        int hitValueSum = 0;
        List<Integer> hitValue = Arrays.asList(Constant.LOTTO_VALUE_5000.getNum(),
                Constant.LOTTO_VALUE_50000.getNum(),
                Constant.LOTTO_VALUE_1500000.getNum(),
                Constant.LOTTO_VALUE_30000000.getNum(),
                Constant.LOTTO_VALUE_2000000000.getNum());

        for (int i = 0; i < hitValue.size(); i++) {
            hitValueSum += hit.get(i) * hitValue.get(i);
        }

        revenue = (float) (Math.round((((hitValueSum * 100.0) / payAmount) * 100)) / 100.0);
    }

    public float getRevenue() {
        return revenue;
    }
}
