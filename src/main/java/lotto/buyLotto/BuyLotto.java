package lotto.buyLotto;

import java.util.List;

public class BuyLotto {
    public int buyLotto(List<Lotto> lottoNumbers) {
        GetMoney getMoney = new GetMoney();
        GetLottoNumber getLottoNumber = new GetLottoNumber();

        System.out.println("구입 금액을 입력해주세요.");
        int money = getMoney.getMoneyFromUser();

        System.out.println(money + "개를 구매했습니다.");
        getLottoNumber.printLottoNumbers(lottoNumbers, money);

        return money;
    }
}
