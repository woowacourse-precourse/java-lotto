package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final String WINNING_STATISTICS = "당첨 통계\n---";

    private final User user;
    private final LottoResult lottoResult;
    private UserLotto userLotto;
    private List<Lotto> randomLottoNumbers;
    private int[] winningInformation;

    LottoService(){
        user = new User();
        lottoResult = new LottoResult();
        winningInformation = new int[5];
    }

    public void initLottoService(){
        user.setPrice();
        user.setLottoCount();
        user.setRandomLottoNumbers();
        user.setUserLotto();
    }

    public void matchLotto(){
        System.out.println(WINNING_STATISTICS);

        calculateLotto();
        lottoResult.getLottoResult(winningInformation, user.getPrice());
    }

    private void calculateLotto(){
        initInformation();
        for(int i=0;i<randomLottoNumbers.size();i++){
            CountingMatch matchingNumber = findMatchingNumber(randomLottoNumbers.get(i).getNumbers());
            setUpWinning(matchingNumber);
        }
    }

    private CountingMatch findMatchingNumber(List<Integer> numbers){
        CountingMatch countingMatch = new CountingMatch();
        for(int i=0;i<numbers.size();i++){
            compareNumber(numbers, countingMatch, i);
        }
        return countingMatch;
    }

    private void compareNumber(List<Integer> numbers, CountingMatch countingMatch, int i) {
        if(userLotto.getNumbers().contains(numbers.get(i))){
            countingMatch.addSameCnt();
        }
        if(numbers.get(i) == userLotto.getBonusNumber()){
            countingMatch.sameBonus();
        }
    }

    private void setUpWinning(CountingMatch countingMatch){
        if(countingMatch.getSameCnt() < 3) return;
        if(countingMatch.getSameCnt() == 5) {
            isBonusCheck(countingMatch);
            return;
        }
        winningInformation[countingMatch.getSameCnt()-3]++;
    }

    private void isBonusCheck(CountingMatch countingMatch){
        if(countingMatch.isBonusSame()) {
            winningInformation[3]++;
            return;
        }
        winningInformation[2]++;
    }

    private void initInformation() {
        randomLottoNumbers = user.getRandomLottoNumbers();
        userLotto = user.getUserLotto();
    }
}
