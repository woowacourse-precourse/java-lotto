package lotto.domain;

import lotto.utils.GenerateLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private List<Lotto> userLotto;
    public UserLotto(){
        userLotto = new ArrayList<>();
    }
    public void addUserLotto(){
        userLotto.add(new Lotto(GenerateLottoNumbers.generateLottoNumber()));
    }
    public List<Lotto> getUserLotto(){
        return userLotto;
    }
}
