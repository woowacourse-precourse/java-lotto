package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static Lotto winNumber;
    public static int bonusNumber;
    public InputController winNumberInputController = new WinNumberInputController();
    public BonusNumberInputController bonusNumberInputController = new BonusNumberInputController();
    public HashMap<Long, WinPrize> winPrizeRecording;

    public LottoMachine() {

        winPrizeRecording = new HashMap<>();

        winPrizeRecording.put(WinPrize.ONE_GRADE.matchCount, WinPrize.ONE_GRADE);
        winPrizeRecording.put(WinPrize.THREE_GRADE.matchCount, WinPrize.THREE_GRADE);
        winPrizeRecording.put(WinPrize.FOUR_GRADE.matchCount, WinPrize.FOUR_GRADE);
        winPrizeRecording.put(WinPrize.FIVE_GRADE.matchCount, WinPrize.FIVE_GRADE);

    }

    public List<Lotto> issueLottoNumbers(long count) {

        List<Lotto> lottoNumbers = Stream.generate(() -> new Lotto(getLottoNumber()))
                .limit(count)
                .collect(Collectors.toList());

        return lottoNumbers;
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void setWinNumber(List<String> inputLottoNumber) {

        winNumberInputController.validate(inputLottoNumber);

        winNumber = new Lotto(convertInteger(inputLottoNumber));
    }

    public List<Integer> convertInteger(List<String> inputLottoNumber) {

        return inputLottoNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Lotto getWinNumber() {
        return winNumber;
    }

    public void setBonusNumber(String inputBonusNumber) {

        bonusNumberInputController.validate(inputBonusNumber);

        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinPrize getWinPrize(Lotto buyerLotto) {

        long matchingCount = getMatchingCount(buyerLotto);

        boolean isBonusNumberMatching = checkBonusNumberMatching(buyerLotto);

        WinPrize buyerWinPrize = winPrizeRecording.get(matchingCount);

        if(matchingCount == WinPrize.THREE_GRADE.matchCount && isBonusNumberMatching) {
            return WinPrize.TWO_GRADE;
        }

        if(matchingCount >= 3) {
            return buyerWinPrize;
        }

        return WinPrize.NOTHING;
    }

    public long getMatchingCount(Lotto buyerLotto) {

        return buyerLotto.getLotto().stream()
                .filter(
                number -> winNumber.getLotto().contains(number))
                .count();
    }

    public boolean checkBonusNumberMatching(Lotto buyerLotto) {

        return buyerLotto.getLotto().stream()
                .anyMatch(number -> number == getBonusNumber());
    }


}
