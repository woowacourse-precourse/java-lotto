package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Function.Checker;
import lotto.Function.Generator;
import lotto.Function.Pay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    User user = new User();
    Generator generator = new Generator();

    public void cashInput() {
        String cash = Console.readLine();
        new Pay(cash);
        user.setUseCash(Integer.parseInt(cash));
    }

    public void winningNumInput() {
        List<Integer> list = changeWinningNumbers(Console.readLine());
        new Lotto(list);
        user.setWinningNumbers(list);
    }

    public void bonusNumInput() {
        user.setBonus_number(Integer.parseInt(Console.readLine()));
    }

    public List<Integer> changeWinningNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        List<String> output = Arrays.asList(input.split(","));

        for (int i = 0; i < output.size(); i++)
            result.add(Integer.parseInt(output.get(i)));

        return result;
    }

    public String showBuy() {
        Pay pay = new Pay(String.valueOf(user.getUseCash()));
        int buyNum = pay.makeBuyNum();
        user.setUserLottoNumber(generator.makeNumbers(buyNum));

        return buyNum + "개를 구매했습니다.\n";
    }
    public void printUserLotto() {
        for (int i = 0; i < user.getUserLottoNumber().size(); i++) {
            System.out.println(user.getUserLottoNumber().get(i));
        }
    }

    public void checking() {
        for (int i = 0; i < user.getUserLottoNumber().size(); i++) {
            Checker checker = new Checker(user.getUserLottoNumber().get(i), user.getWinningNumbers());
            int checkNum = checker.winningNumCheck();
            user.userMatchNumber.add(checkNum);
        }
    }

    public float winningTableCheck(int num) {
        float winning = 0;
        for (int i = 0; i < user.userMatchNumber.size(); i++) {
            if (user.userMatchNumber.get(i) == num)
                winning++;
        }
        return winning;
    }

    public float bonusWinningCheck() {
        float winning = 0;
        for (int i = 0; i < user.userMatchNumber.size(); i++) {
            List<Integer> lottoNum = user.getUserLottoNumber().get(i);
            if (user.userMatchNumber.get(i) == 5 && lottoNum.contains(user.getBonus_number())) {
                winning++;
            }
        }
        return winning;
    }




}
