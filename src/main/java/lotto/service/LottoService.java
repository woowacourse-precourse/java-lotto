package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

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

    public LottoResult lottoResult(WinningLotto winningLotto, List<Lotto> lottos, Money money){
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
        System.out.println("당첨 통계");
        System.out.println("---");
        HashMap<Rank, Integer> result = lottoResult.getResult();
        Long amount = 0L;
        for (int ranking = 4; ranking >= 0; ranking--) {
            Rank rank = Rank.values()[ranking];
            System.out.printf(rank.toString() + "%d개\n", result.get(rank));
            amount += result.get(rank) * rank.getPrize();
        }
        Output.printYield(amount, money);
    }
}
