package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private final int tickets;
    private final List<List<Integer>> lottoTickets = new ArrayList<>();

    public LottoTicket(int tickets){
        this.tickets = tickets;
        buyLottoTickets(tickets);
    }

    public int getTickets(){
        return tickets;
    }

    public List<Integer> countSameLottoNumbers(Lotto lottoNumbers){
        List<Integer> count = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoTickets) {
            List<Integer> result = lottoTicket.stream()
                    .filter(tmp -> lottoNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(tmp)))
                    .collect(Collectors.toList());
            count.add(result.size());
        }

        return count;
    }

    public List<Boolean> checkSameLottoBonus(int bonus){
        List<Boolean> result = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoTickets) {
            result.add(lottoTicket.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonus)));
        }
        return result;
    }

    private void buyLottoTickets(int tickets){
        for (int count = 0; count < tickets; count++){
            lottoTickets.add(getLottoNumbers());
        }
    }

    private List<Integer> getLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT);
        OutputView.printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }
}
