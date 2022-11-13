package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private int moneyToBuy;
    private List<Lotto> purchasedLottoTickets;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application newRound = new Application();
        newRound.askForMoney();
        newRound.buyLotto();
    }

    public void askForMoney() {
        String answer = readLine().replace(" ", "");
        validateMoney(answer);
        this.moneyToBuy = Integer.parseInt(answer);
    }

    private void validateMoney(String answer) {
        if (checkOnlyNumber(answer) || checkDivisibleNumber(answer)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkOnlyNumber(String answer) {
        return (answer.matches("[^0-9]"));
    }

    private boolean checkDivisibleNumber(String answer) {
        return (Integer.parseInt(answer) % 1000 != 0);
    }

    public void buyLotto() {
        for (int count = 0; count < this.moneyToBuy; count += 1000) {
            this.purchasedLottoTickets.add(createLotto());
        }
    }
    private Lotto createLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
