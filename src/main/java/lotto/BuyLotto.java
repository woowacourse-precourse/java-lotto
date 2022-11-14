package lotto;

import java.util.ArrayList;

public interface BuyLotto {
    public int getLottoCount();
    public void validate();
    public ArrayList<Lotto> buyLotto();
}
