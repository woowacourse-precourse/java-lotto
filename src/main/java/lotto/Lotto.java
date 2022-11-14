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

    public void startLotto() {
        InputLotto inputLotto = new InputLotto();

        ShowMessage.showInputAmountBuy(); // "구입 금액을 입력해 주세요"를 출력
        long numberOfLotto = inputLotto.inputValueToints(); // 구입 금액 입력
        numberOfLotto = lottoCount(numberOfLotto); // 로또의 개수
        ShowMessage.showHowManyBuy(numberOfLotto); // "n개를 구매했습니다."를 출력

        List<Lotto> lottoList = createLotto(numberOfLotto); // 로또 생성
        ShowMessage.showLottoNumber(lottoList); // 로또 리스트 출력

        ShowMessage.showInputLottoNumber(); // "당첨 번호를 입력해 주세요."를 출력
        List<Integer> winNumbers = inputLotto.inputValueSplitCommas(); // 당첨 번호 입력

        ShowMessage.showInputBonusNumber(); // "보너스 번호를 입력해 주세요."를 출력
        int bonusNumber = inputLotto.inputBonusNumber(winNumbers); // 보너스 번호 입력

        WinLotto winLotto = new WinLotto();
        winLotto.setBonusNumber(bonusNumber); // 보너스 번호를 객체에 저장
        List<WinLotto> compareNumber = compareLottos(lottoList, winNumbers); // 당첨 번호 개수와 보너스 번호 포함 여부를 저장

        for (WinLotto number : compareNumber) {
            System.out.println("보너스 번호:" + number.getBonusNumber() + ":");
            System.out.println("당첨 번호 개수" + number.getWinLottoCount() + ":");
            System.out.println("보너스 번호 포함 여부:" + number.getIsBonusNumber() + ":");
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

    public List<WinLotto> compareLottos(List<Lotto> lottoNumber, List<Integer> winNumber) {
        List<WinLotto> compareNumber = new ArrayList<>();
        for (int i = 0; i < lottoNumber.size(); i++) {
            WinLotto winLotto = compareLotto(lottoNumber.get(i), winNumber); // 로또 번호와 당첨 번호를 비교
            compareBonusNumber(winLotto, lottoNumber.get(i)); // 보너스 번호 포함인지 검사
            compareNumber.add(winLotto);
        }
        return compareNumber;
    }

    // 당첨 번호의 개수를 저장
    public WinLotto compareLotto(Lotto lottoNumber, List<Integer> winNumber) {
        WinLotto winLotto = new WinLotto();
        int winNumberCount = lottoNumber.getLottoNumbers().stream()
                .filter(number -> winNumber.stream().anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList()).size();
        winLotto.setWinLottoCount(winNumberCount);
        return winLotto;
    }

    public WinLotto compareBonusNumber(WinLotto winLotto, Lotto lottoNumber) {
        for (int i = 0; i < lottoNumber.getLottoNumbers().size(); i++) {
            if (lottoNumber.getLottoNumbers().contains(winLotto.getBonusNumber())) {
                winLotto.setIsBonusNumber(true);
            }
        }
        return winLotto;
    }

}
