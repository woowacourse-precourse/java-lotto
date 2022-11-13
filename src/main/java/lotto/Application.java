package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private int moneyToBuy;
    private final List<Lotto> purchasedLottoTickets = new ArrayList<>();
    private Lotto winningNumber;
    private Integer bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application newRound = new Application();
        newRound.askForMoney();
        newRound.buyLotto();
        newRound.printLottoList();
        newRound.setLottoWinningNumber();
    }

    public void askForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
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

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void printLottoList() {
        printNumberOfLotto();
        for (Lotto ticket : purchasedLottoTickets) {
            printLottoNumbers(ticket);
        }
    }

    private void printNumberOfLotto() {
        System.out.println(this.purchasedLottoTickets.size() + "개를 구매했습니다.");
    }

    private void printLottoNumbers(Lotto ticket) {
        System.out.println(ticket.getLottoNumbers());
    }

    public void setLottoWinningNumber() {
        this.winningNumber = askWinningNumber();
        this.bonusNumber = askBonusNumber();
    }

    private Lotto askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] answer = readLine().split(",");
        checkArrayOnlyNumber(answer);
        return makeWinningLotto(answer);
    }

    private void checkArrayOnlyNumber(String[] answer) {
        for (String number : answer) {
            if (checkOnlyNumber(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private Lotto makeWinningLotto(String[] answer) {
        List<Integer> answerNumber = new ArrayList<>();
        for (String number : answer) {
            answerNumber.add(Integer.parseInt(number));
        }
        return new Lotto(answerNumber);
    }

    private Integer askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String answerBonusNumber = readLine().replace(" ", "");
        validateBonusNumber(answerBonusNumber);
        return Integer.parseInt(answerBonusNumber);
    }

    private void validateBonusNumber(String answerBonusNumber) {
        if (checkOnlyNumber(answerBonusNumber)
                || checkOutOfRange(answerBonusNumber)
                || checkOverlapWinningNumber(answerBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkOutOfRange(String answerBonusNumber) {
        return (Integer.parseInt(answerBonusNumber) > 45 || Integer.parseInt(answerBonusNumber) < 1);
    }

    private boolean checkOverlapWinningNumber(String answerBonusNumber) {
        Integer bonusNumber = Integer.parseInt(answerBonusNumber);
        for(Integer lottoNumber: this.winningNumber.getLottoNumbers()){
            if(lottoNumber.equals(bonusNumber)){
                return true;
            }
        }
        return false;
    }
}
