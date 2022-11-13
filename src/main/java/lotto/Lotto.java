package lotto;

import lotto.Machine.MatchMachine;
import lotto.Machine.PrintMachine;
import lotto.Number.BonusNumber;
import lotto.Number.WinningNumber;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private enum lottoGrade {
        LOTTO_Three_MATCHES(3),
        LOTTO_FOUR_MATCHES(4),
        LOTTO_FIVE_MATCHES(5),
        LOTTO_FIVE_BONUS_MATCHES(50),
        LOTTO_SIX_MATCHES(6);

        final private int match;
        public int getMatches(){
            return match;
        }
        private lottoGrade(int match){
            this.match = match;
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            PrintMachine.errorMessage("당첨번호의 길이가 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void startLotto() {
        Price price = new Price();
        WinningNumber winningNumber = new WinningNumber();
        Lotto lotto = new Lotto(winningNumber.getWinningNumberList());

        BonusNumber bonus = new BonusNumber();
        int bonusNumber = bonus.getBonusNumber();

        Generator lottoGenerator = new Generator(price.getLottoTickets());

        MatchMachine machine = new MatchMachine(lotto.getLottoNumbers(), lottoGenerator.getlottoNumbers());
        List<Integer> results = machine.getResults();


    }

    public void getLottoResults(List<Integer> results) {

    }


}
