package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ShowErrorMessage.showLottoNumberCount();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public long lottoCount(long amount) {
        exceptionHandling.notDivide(amount); // 예외 검사
        return amount / 1000;
    }

    public List<Lotto> createLotto(long numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(createLottoList());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> createLottoList() {
        List<Integer> lotto = createLottoNumber();
        sortLottoNumberAscending(lotto);
        return lotto;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Integer> sortLottoNumberAscending(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }

    public List<WinLottoNumber> compareLottos(List<Lotto> lottoNumber, List<Integer> winNumber) {
        List<WinLottoNumber> compareNumber = new ArrayList<>();
        for (int i = 0; i < lottoNumber.size(); i++) {
            WinLottoNumber winLottoNumber = compareLotto(lottoNumber.get(i), winNumber);
            compareNumber.add(winLottoNumber);
            System.out.println("당첨 번호:" + compareNumber.get(i).getWinLottoNumber() + ":");
        }
        return compareNumber;
    }

    // 로또 번호와 당첨 번호를 비교하여 같은 번호인 것을 WinLottoNumber에 저장하여 반환
    public WinLottoNumber compareLotto(Lotto lottoNumber, List<Integer> winNumber){
        WinLottoNumber winLottoNumber = new WinLottoNumber(lottoNumber.getLottoNumbers().stream()
                .filter(number -> winNumber.stream().anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList()));
        return winLottoNumber;
    }

}
