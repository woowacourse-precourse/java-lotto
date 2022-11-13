package lotto;

import java.util.ArrayList;

public interface BuyLotto {
    public int getLottoCount(int money, int lottoPrice);
    public void validate(int money, int lottoPrice);
    public ArrayList<Lotto> buyLotto();
    public int getLottoCount();
}
