package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLottoInfo {

    private int lottoPrice;
    private List<Lotto> userLotto;

    public UserLottoInfo() { }

    public void setLottoPrice(int lottoPrice){
        this.lottoPrice = lottoPrice;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public void initLottoList(int lottoCount){
        userLotto = new ArrayList<>(lottoCount);
    }

    public void addSingleLotto(Lotto singleLotto){
        userLotto.add(singleLotto);
    }

    public Lotto getSingleLotto(int index){
        return userLotto.get(index);
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public int getUserLottoSize(){
        return userLotto.size();
    }
}
