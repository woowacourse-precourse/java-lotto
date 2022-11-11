package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoSystem;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoSystemService {
    private User user;
    private Lotto lotto;

    private List<Integer> numbers = new ArrayList<>();
    private List<String> total = Arrays.asList("3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - ");

    public void setRandomLottoNumbers(User user) {
        int lottoCount;
        List<List<Integer>> numbers = new ArrayList<>();

        LottoSystem lottoSystem = new LottoSystem(user);
        lottoSystem.setUserLottoCount();
        lottoCount = lottoSystem.getUserLottoCount();

        numbers = getRandomLottoNumbers(lottoCount);

        user.setUserLottoNumber(numbers);
        this.user = user;
    }

    private List<List<Integer>> getRandomLottoNumbers(int lottoCount) {
        List<List<Integer>> numbers = new ArrayList<>();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(number);
            numbers.add(number);
        }

        return numbers;
    }

    public void setAnswerLottoNumbers() {
        String inputNumbers = Console.readLine();

        for (int i = 0; i < inputNumbers.length(); i++) {
            if (i % 2 == 0) {
                numbers.add((int) inputNumbers.charAt(i));
            }
        }
    }

    public void setBonusLottoNumbers() {
        String inputNumber = Console.readLine();
        numbers.add((int) inputNumber.charAt(0));
    }

    public void saveLottoNumbers() {
        lotto = new Lotto(numbers);
    }

    public void setTotal() {
        List<List<Integer>> userLottoNumbers = user.getUserLottoNumber();
        List<Integer> hit = Arrays.asList(0, 0, 0, 0, 0);
        int hitIndex;

        for (int i = 0; i < userLottoNumbers.size(); i++) {
            hitIndex = hitIndex(userLottoNumbers.get(i));
            if (hitIndex != -1) {
                hit.set(hitIndex, hit.get(hitIndex) + 1);
            }
        }

        makeHit(hit);
    }

    private void makeHit(List<Integer> hit) {
        String nowMessage;
        String resultMessage;

        for (int i = 0; i < total.size(); i++) {
            nowMessage = total.get(i);
            resultMessage = nowMessage + hit.get(i) + " 개";
            total.set(i, resultMessage);
        }
    }

    private Integer hitIndex(List<Integer> userLottoNumber) {
        int count = 0;
        int bonusHit = 0;

        for (int i = 0; i < userLottoNumber.size(); i++) {
            if (checkSameNumber(userLottoNumber.get(i))) {
                count += 1;
            }
            if (bonusHit(userLottoNumber.get(i))) {
                bonusHit = 1;
            }
        }

        return resultIndex(count, bonusHit);

    }

    private boolean checkSameNumber(int userNumber) {
        List<Integer> lottoNumber = lotto.getLottoNumber();

        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            if (lottoNumber.get(i) == userNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean bonusHit(int userNumber) {
        List<Integer> lottoNumber = lotto.getLottoNumber();
        return lottoNumber.get(lottoNumber.size() - 1) == userNumber;
    }

    private Integer resultIndex(int count, int bonusHit) {
        int returnIndex = -1;

        if (count == 3) {
            returnIndex = 0;
        } else if (count == 4) {
            returnIndex = 1;
        } else if (count == 5) {
            if (bonusHit == 0) {
                returnIndex = 2;
            } else if (bonusHit == 1) {
                returnIndex = 3;
            }
        } else if (count == 6) {
            returnIndex = 4;
        }

        return returnIndex;
    }
}
