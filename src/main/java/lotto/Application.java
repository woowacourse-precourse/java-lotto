package lotto;

import java.util.List;

public class Application {
    public static <Ineger> void main(String[] args) {
        // TODO: 프로그램 구현


        Lotto.inputBuyPirce1(); //메세지

        int input = User.inputBuyPrice(); //입력칸

        int input2 = Lotto.buyScuessCount(input); //8개를 구입하셨습니다

        User user = new User();
        Lotto.buySucess(input2);
        User.lottoRandomNumber(input2);


        Lotto.sayLottoNumber();
        String lottoListSix = user.lottoListSix();


        Lotto.bonusSay();
        int bonusNumber = User.bonusNumber();

        Lotto.LottoResultMessage();




    }
}
