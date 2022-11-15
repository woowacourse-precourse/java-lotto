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
    List<Integer> hit;
    private int bonusNumber;

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

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> dynamicNumber = new ArrayList<>(number);
            Collections.sort(dynamicNumber);
            numbers.add(dynamicNumber);
        }

        return numbers;
    }

    public void setAnswerLottoNumbers() {
        String inputNumbers = Console.readLine();
        String number = "";
        for (int i = 0; i < inputNumbers.length(); i++) {
            if (inputNumbers.charAt(i) == ',') {
                numbers.add(Integer.parseInt(number));
                number = "";
                continue;
            }
            number += inputNumbers.charAt(i);
        }
        numbers.add(Integer.parseInt(number));
    }

    public void setBonusLottoNumbers() {
        String inputNumber = Console.readLine();
        bonusNumber = Integer.parseInt(inputNumber);
        saveBonusLottoNumbers();
    }

    private void saveBonusLottoNumbers() {
        lotto.setBonusNumber(bonusNumber);
    }

    public void saveLottoNumbers() {
        lotto = new Lotto(numbers);
    }

    public List<String> getTotal() {
        return total;
    }

    public List<Integer> getHitCount() {
        return hit;
    }

    public void setTotal() {
        List<List<Integer>> userLottoNumbers = user.getUserLottoNumber();
        int hitIndex;
        hit = Arrays.asList(0, 0, 0, 0, 0);

        for (int i = 0; i < userLottoNumbers.size(); i++) {
            hitIndex = hitIndex(userLottoNumbers.get(i));
            if (hitIndex != -1) {
                hit.set(hitIndex, hit.get(hitIndex) + 1);
            }
        }

        makeHit();
    }

    private void makeHit() {
        String nowMessage;
        String resultMessage;

        for (int i = 0; i < total.size(); i++) {
            nowMessage = total.get(i);
            resultMessage = nowMessage + hit.get(i) + "개";
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

        if (count == 3 || count == 4 || (count == 5 && bonusHit == 0)) {
            returnIndex = count - 3;
        } else if ((count == 5 && bonusHit == 1)) {
            returnIndex = 3;
        } else if (count == 6) {
            returnIndex = 4;
        }

        return returnIndex;
    }
}
