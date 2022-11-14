package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumbers;
    private Rank[] ranks;

    public void Controller() {
        view = new View();
        lottoNumbers = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        ranks = Rank.values();
    }

    public void makeLottoNumbers(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
    }

    public void makeWinningNumbers() {
        winningNumbers = view.inputLottoNumber();
        view.printLine("");
        winningNumbers.add(view.inputBonusNumber());
    }

    public void checkLottoNumbers() {
        for (Lotto l : lottoNumbers) {
            compareTwoNumbers(l.getNumbers());
        }
    }

    public void compareTwoNumbers(List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (i == winningNumbers.size() - 1 && count == 5 && lottoNumbers.contains(winningNumbers.get(i))) {
                ranks[ranks.length - 1].increaseCount();
            } else if (lottoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        for (int i = 0; i <= count - 3 && i != ranks.length - 1; i++) {
            ranks[i].increaseCount();
        }
    }

    public String calculateYield(int price) {
        int sum = 0;
        for (Rank rank : ranks) {
            sum += rank.getCount() * rank.getPrizeMoney();
        }
        float yield = sum / price;
        return String.format("%.2f", yield);
    }

    public void run() {
        view.printLine("구입금액을 입력해 주세요.");
        int priceNumber = view.inputPrice();
        view.printLine("");

        view.printLine(priceNumber + "개를 구매했습니다.");
        makeLottoNumbers(priceNumber);
        view.printListOfBuyLotto(lottoNumbers);
        view.printLine("");

        makeWinningNumbers();
        view.printLine("");

        view.printResult(ranks, calculateYield(priceNumber*1000));
    }
}
