package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {


    private static final String LOTTO_NUMBER_MUST_SIX = "번호는 6개여야 합니다.";
    private static final String LOTTO_NUMBER_NOT_DUPLICATE = "번호는 중복되면 안됩니다.";
    private static final String NUMBER_RANGE_ONE_TO_FOUR_FIVE = "번호는 1~45사이의 숫자여야 합니다.";

    private static final int LOTTO_MINIMUN_NUM_SIZE = 1;
    private static final int LOTTO_MAXIMUN_NUM_SIZE = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Money insertMoney() {
        String inputMoney = Input.inputMoney();
        Money money = new Money(inputMoney);
        return money;
    }

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUN_NUM_SIZE, LOTTO_MAXIMUN_NUM_SIZE, LOTTO_NUMBER_SIZE);
        //따로 numbers.sort or Collections.sort를 할 경우 Test에서 에러 출력, 따라서 TreeSet로 구현
        Set<Integer> lottoNumbers = new TreeSet<>(numbers);
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public List<Lotto> purchaseLottos(Integer ticket) {
        Output.purchaseLotto(ticket);
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < ticket; count++) {
            lottos.add(createLotto());
        }
        Output.printPurchaseLottos(lottos);
        return lottos;
    }

    public List<Integer> inputWinningLottoNumber() {
        String winningNumber = Input.inputWinningNumber();
        List<Integer> numbers = stringToList(winningNumber);
        validateLottoNumber(numbers);
        validateBonusLottoNumberRange(numbers);
        validateLottoNumberDuplicate(numbers);
        return numbers;
    }

    public WinningLotto makeWinningLotto(List<Integer> winningLottoNumber) {
        Integer bonusNumber = Input.inputBonusNumber();
        validateBonusNumberRange(bonusNumber);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        return winningLotto;
    }

    private void validateBonusLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LOTTO_MINIMUN_NUM_SIZE > number || number > LOTTO_MAXIMUN_NUM_SIZE) {
                throw new IllegalArgumentException(NUMBER_RANGE_ONE_TO_FOUR_FIVE);
            }
        }
    }

    public void validateBonusNumberRange(Integer bonusNumber) {
        if (LOTTO_MINIMUN_NUM_SIZE > bonusNumber || bonusNumber > LOTTO_MAXIMUN_NUM_SIZE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ONE_TO_FOUR_FIVE);
        }
    }

    private static List<Integer> stringToList(String number) {
        List<Integer> numbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    private void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_SIX);
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_DUPLICATE);
        }
    }

    public LottoResult lottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getNumbers();
            Integer count = winningLotto.checkMatchNumber(lottoNumber);
            boolean thereBonusNumber = winningLotto.isThereBonusNumber(lottoNumber);
            Rank rank = Rank.valueOf(count, thereBonusNumber);
            lottoResult.addRankCount(rank);
        }
        return lottoResult;
    }

    public void printLottoResult(LottoResult lottoResult, Money money) {
        Output.printLottoResult(lottoResult, money);
    }
}
