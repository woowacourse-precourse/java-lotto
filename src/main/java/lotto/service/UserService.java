package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private User user;
    private LottoSystemService lottoSystemService;
    private float revenue;


    public void setPayMent() {
        int payMent;

        try {
            payMent = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 됩니다.");
        }

        user = new User(payMent);
    }

    public LottoSystemService buyLotto(){
        lottoSystemService = new LottoSystemService();
        lottoSystemService.setRandomLottoNumbers(user);
        return lottoSystemService;
    }

    public List<List<Integer>> getUserLottoNumber(){
        return user.getUserLottoNumber();
    }

    public void setRevenue(){
        int payAmount = user.getUserPayAmount();
        List<Integer> hit = lottoSystemService.getHitCount();
        List<Integer> hitValue = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);
        int hitValueSum = 0;

        for(int i=0; i<hitValue.size(); i++){
            hitValueSum += hit.get(i) * hitValue.get(i);
        }

        revenue = (float) (Math.round((((hitValueSum * 100.0) / payAmount) * 100)) / 100.0);
    }

    public float getRevenue(){
        return revenue;
    }
}
