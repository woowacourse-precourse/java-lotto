package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoSystem;
import lotto.domain.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private User user;

    public void setPayMent() {
        int payMent;

        try {
            payMent = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 됩니다.");
        }

        user = new User(payMent);
    }

    public void setRandomLottoNumbers(){
        int lottoCount;
        List<List<Integer>> numbers = new ArrayList<>();

        LottoSystem lottoSystem =  new LottoSystem(user);
        lottoSystem.setUserLottoCount();
        lottoCount = lottoSystem.getUserLottoCount();

        numbers = getRandomLottoNumbers(lottoCount);

        user.setUserLottoNumber(numbers);
    }

    private List<List<Integer>> getRandomLottoNumbers(int lottoCount) {
        List<List<Integer>> numbers = new ArrayList<>();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(number);
            numbers.add(number);
        }

        return numbers;
    }

}
