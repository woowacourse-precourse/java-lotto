package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    public void start() {
        int lottoAmount = getLottoAmount();
        
        List<Lotto> lottos;
        lottos = createLottos(lottoAmount);
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
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
