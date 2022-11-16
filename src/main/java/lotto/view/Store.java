package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.user.User;

import java.util.stream.Collectors;

public class Store extends View {
    public Store(User user){
        initPage(buyingLotto(user));
    }

    public String buyingLotto(User user){
        StringBuilder boughtMsg = new StringBuilder(String.valueOf(user.getLotto().size()));
        boughtMsg.append(Message.BUYING_MSG);
        for (Lotto lotto : user.getLotto()) {
            boughtMsg.append("\n");
            boughtMsg.append(showLotto(lotto));
        }
        return boughtMsg.toString();
    }

    private String showLotto(Lotto lotto){
        StringBuilder msg = new StringBuilder("[");
        String lottoNumbers = lotto.getNumbers()
                .stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        msg.append(lottoNumbers);
        msg.append("]");
        return msg.toString();
    }
}
