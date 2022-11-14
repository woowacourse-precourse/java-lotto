package lotto;

import java.util.ArrayList;
import java.util.List;

public interface BuyLotto {
    public int getLottoCount();
    public void validate();
    public ArrayList<Lotto> buyLotto();

    public List<Integer> getLottoNumber();
}
