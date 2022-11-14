package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.user.User;

public class Store {
    public String sellingLotto(){
        return Message.SELLING_MSG.toString();
    }

    public String buyingLotto(User user){
        StringBuilder boughtMsg = new StringBuilder(String.valueOf(user.getLotto().size()));
        boughtMsg.append(Message.BUYING_MSG.toString());
        for (Lotto lotto : user.getLotto()) {
            boughtMsg.append("\n");
            boughtMsg.append(lotto.toString());
        }
        return boughtMsg.toString();
    }

}
