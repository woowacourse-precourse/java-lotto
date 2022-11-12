package lotto;

import java.util.List;

public class Application {
    public static <Ineger> void main(String[] args) {
        // TODO: 프로그램 구현


        Lotto.inputBuyPirce1();

        int input = User.inputBuyPrice();

        int input2 = Lotto.buyScuessCount(input);

        User user = new User();
        Lotto.buySucess(input2);
        user.lottoRandomNumber(input2);

        Lotto.sayLottoNumber();
        String lottoListSix = user.lottoListSix();


        Lotto.bonusSay();
        int bonusNumber = User.bonusNumber();




    }
}
