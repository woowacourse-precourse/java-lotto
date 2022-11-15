package lotto;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int userPrice = InputUser.inputUserPrice();
        System.out.println();
        List<List<Integer>> lottoLists = InputUser.lottoNumber(userPrice);
        System.out.println();
        List<Integer> lottoNumber = InputUser.inputLottoNumber();
        System.out.println();
        int bonus = InputUser.inputBonusNumber(lottoNumber);
        System.out.println();
        Lotto lotto = new Lotto(lottoNumber);
        lotto.calcLotto(lottoLists,bonus,userPrice);
    }
}