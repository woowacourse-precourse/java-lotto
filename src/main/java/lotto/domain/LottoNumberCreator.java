package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 로또 번호 생성에 관한 클래스
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class LottoNumberCreator {
    private static int NUMBER_OF_LOTTERY = 6;
    private static int BONUS_BALL_NUMBER = 0;

    /**
     * 로또 번호 생성 후 Lotto class 에게 로또 발행시키기
     */
    public List<Lotto> createLottoNumber(int lottoQuantity) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; ++i) {
            List<Integer> lottoCreateNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteries.add(new Lotto(lottoCreateNumbers));
        }
        return lotteries;
    }

    /**
     * 로또 당첨 번호 생성
     */
    public Lotto createLottoWinNumber(String lottoWinNumber) {
        String[] lottoWinNumberWords = lottoWinNumber.split(",");
        validateWinNumberAmount(lottoWinNumberWords);

        validateNumber(lottoWinNumberWords);
        List<Integer> lottoWinNumbers = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_LOTTERY; ++i) {
            lottoWinNumbers.add(Integer.valueOf(lottoWinNumberWords[i].trim()));
        }

        validateNumberRange(lottoWinNumbers);
        return new Lotto(lottoWinNumbers);
    }

    /**
     * 로또 보너스 번호 생성
     */
    public LottoBonusBall createLottoBonusBall(String bonusBallWord, Lotto lottoWinNumber) {
        String[] bonusBallWords = bonusBallWord.split("");
        validateNumber(bonusBallWords);
        int bonusBall = Integer.valueOf(bonusBallWords[BONUS_BALL_NUMBER]);
        return new LottoBonusBall(bonusBall, lottoWinNumber);
    }
    
    /**
     * 숫자 개수 검증 로직
     */
    private void validateWinNumberAmount(String[] lottoWinNumberWords) {
        if (lottoWinNumberWords.length != NUMBER_OF_LOTTERY) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 당첨 번호는 쉼표(,)를 기준으로 총 6개의 숫자를 입력하셔야 합니다."
            );
        }
    }

    /**
     * 문자가 숫자인지 검증하는 로직
     */
    private void validateNumber(String[] lottoWinNumberWords) {
        for (int i = 0; i < lottoWinNumberWords.length; ++i) {
            try {
                Integer.valueOf(lottoWinNumberWords[i].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 숫자를 입력하셔야 합니다.", e);
            }
        }
    }

    /**
     * 숫자가 1부터 45사이인지 검증하는 로직
     */
    private void validateNumberRange(List<Integer> lottoWinNumbers) {
        for (int i = 0; i < NUMBER_OF_LOTTERY; ++i) {
            if (lottoWinNumbers.get(i) < 1 || lottoWinNumbers.get(i) > 45) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자를 입력하셔야 합니다."
                );
            }
        }
    }
}
