package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private static final int LOTTO_MINIMUN_NUM_SIZE = 1;
    private static final int LOTTO_MAXIMUN_NUM_SIZE = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private Money money;

    public int insertMoney() {
        int inputMoney = Input.inputMoney();
        money = new Money(inputMoney);
        return money.getTicket();
    }

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUN_NUM_SIZE, LOTTO_MAXIMUN_NUM_SIZE, LOTTO_NUMBER_SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public List<Lotto> purchaseLottos(Integer ticket) {
        Output.purchaseLotto(ticket);
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < ticket; count++) {
            lottos.add((createLotto()));
        }
        Output.printPurchaseLottos(lottos);
        return lottos;
    }

    public List<Integer> inputWinningLottoNumber(){
        String winningNumber = Input.inputWinningNumber();
        List<Integer> numbers = stringToList(winningNumber);
        validateLottoNumber(numbers);
        validateLottoNumberDuplicate(numbers);
        return numbers;
    }

    public WinningLotto makeWinningLotto(List<Integer> winningLottoNumber){
        Integer bonusNumber = Input.inputBonusNumber();
        validateBonusNumberRange(bonusNumber);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        return winningLotto;
    }

    public void validateBonusNumberRange(Integer bonusNumber){
        if(LOTTO_MINIMUN_NUM_SIZE > bonusNumber || bonusNumber > LOTTO_MAXIMUN_NUM_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> stringToList(String number){
        List<Integer> numbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    private void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }
}
