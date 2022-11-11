package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;


import java.util.List;

public class UserService {
    private User user;
    private LottoSystemService lottoSystemService;

    public void setPayMent() {
        int payMent;

        try {
            payMent = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 됩니다.");
        }

        user = new User(payMent);
    }

    public void buyLotto(){
        lottoSystemService = new LottoSystemService();
        lottoSystemService.setRandomLottoNumbers(user);
    }

    public List<List<Integer>> getUserLottoNumber(){
        return user.getUserLottoNumber();
    }

}
