package lotto.view;

public class LottoView {
    public static int inputMoney() {
        int money = Integer.parseInt(AppView.inputLine());
        if(ValidateView.isPossibleMoney(money)) {
            return money;
        }

        return 0;
    }
}
