package lotto;

import java.util.ArrayList;
import java.util.List;

public interface BuyLotto {
    public int getLottoCount();
    public void validate();
    public ArrayList<Lotto> getLottos();

    public int getMoney();
    public List<Integer> getLottoNumber();
}
