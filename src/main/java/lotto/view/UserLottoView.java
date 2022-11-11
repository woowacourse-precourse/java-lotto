package lotto.view;

import java.util.List;

public class UserLottoView extends View{

    private List<String> userLotto;

    @Override
    public void show() {
        for (String lotto : userLotto) {
            System.out.println(lotto);
        }
    }

    @Override
    public void setPrintElement(List<String> userLotto) {
        this.userLotto = userLotto;
    }
}
