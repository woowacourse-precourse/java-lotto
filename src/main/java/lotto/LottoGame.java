package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int PERCENTAGE = 100;

    public void start() {
        int lottoAmount = getLottoAmount();
        
        List<Lotto> lottos;
        lottos = createLottos(lottoAmount);

        WinningLotto winningLotto = createWinningLotto();

        lottoResultStatistics(lottos, winningLotto);
    }

    private int getLottoAmount(){
        int payment = getPayment();

        return (payment / TICKET_PRICE);
    }

    private int getPayment(){
        System.out.println("구입 금액을 입력해 주세요.");
        String payment = readLine();

        if(!isValidPayment(payment)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(payment);
    }

    private boolean isValidPayment(String payment){
        if(!isValidPaymentCharacter(payment) || !isValidPaymentScope(payment) || !isValidPaymentUnit(payment)) {
            return false;
        }

        return true;
    }

    private boolean isValidPaymentCharacter(String payment) {
        try{
            Integer.parseInt(payment);
        } catch(IllegalArgumentException illegalArgumentException){
            return false;
        }

        return true;
    }

    private boolean isValidPaymentScope(String payment) {
        return Integer.parseInt(payment) > 0;
    }

    private boolean isValidPaymentUnit(String payment) {
        return Integer.parseInt(payment) % TICKET_PRICE == 0;
    }

    private List<Lotto> createLottos(int lottoAmount) {
        System.out.println(lottoAmount +"개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();

        for(int idx = 0; idx < lottoAmount; idx++){
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_SIZE);

        printLottoNumbers(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print("[");
        for(int idx = 0; idx < lottoNumbers.size() - 1; idx++){
            System.out.print(lottoNumbers.get(idx) + ", ");
        }
        System.out.println(lottoNumbers.get(lottoNumbers.size() - 1) + "]");
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = new Lotto(getWinningNumbers());
        int bonusNumber = getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");

        List<Integer> winningNumbers = new ArrayList<>();
        String winningNumbersWithComma = readLine();
        List<String> numbers = List.of(winningNumbersWithComma.split(","));
        if(!isValidWinningNumbers(numbers))
            throw new IllegalArgumentException();

        for(String number : numbers){
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private boolean isValidWinningNumbers(List<String> numbers) {
        if(!isValidWinningNumbersSize(numbers) || !isValidWinningNumbersScope(numbers))
            return false;
        return true;
    }

    private boolean isValidWinningNumbersSize(List<String> numbers) {
        return numbers.size() == 6;
    }

    private boolean isValidWinningNumbersScope(List<String> numbers) {
        for(String number : numbers){
            if(!(Integer.parseInt(number) >= LOTTO_MIN_NUMBER && Integer.parseInt(number) <= LOTTO_MAX_NUMBER))
                return false;
        }
        return true;
    }

    private int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        
        String bonusNumber = readLine();
        if(!isValidBonusNumber(bonusNumber))
            throw new IllegalArgumentException();

        return Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        if(!(Integer.parseInt(bonusNumber) >= LOTTO_MIN_NUMBER && Integer.parseInt(bonusNumber) <= LOTTO_MAX_NUMBER))
            return false;
        return true;
    }

    private void lottoResultStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = setResult();
        Rank rank;

        System.out.println("당첨 통계");
        System.out.println("===");
        for(int idx = 0; idx < lottos.size(); idx++){
            rank = winningLotto.match(lottos.get(idx));
            result.put(rank, result.get(rank) + 1);
        }

        printResult(result);

        int lottoAmount = lottos.size();
        printYieldRate(result, lottoAmount);
    }

    private Map<Rank, Integer> setResult(){
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for(Rank rank : Rank.values()){
            result.put(rank, 0);
        }
        return result;
    }

    private void printResult(Map<Rank, Integer> result) {
        for(int i = Rank.values().length - 1; i >= 0; i--){
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private void printYieldRate(Map<Rank, Integer> result, int lottoAmount) {
        double yieldRate = 0;

        for(Rank rank : result.keySet()){
            yieldRate += (double)((rank.getWinningMoney()) / (lottoAmount * TICKET_PRICE)) * result.get(rank) * PERCENTAGE;
        }
        System.out.println("총 수익률은 " + String.format("%.1f", yieldRate) + "%입니다.");
    }
}
