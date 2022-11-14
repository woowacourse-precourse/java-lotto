package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCountWin {
    List<Integer> numberOfWin = new ArrayList<>();
    private int count1Win;
    private int count2Win;
    private int count3Win;
    private int count4Win;
    private int count5Win;

    public LottoCountWin(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> lottoRandom, long userTicket) {
        getLottoWin(lottoNumbers, bonusNumber, lottoRandom, userTicket);
        getBonusWin(lottoNumbers, bonusNumber, lottoRandom, userTicket);
        getCountWin();
    }

    public int getCount1Win() {
        return count1Win;


    }

    public int getCount2Win() {
        return count2Win;
    }

    public int getCount3Win() {
        return count3Win;
    }

    public int getCount4Win() {
        return count4Win;
    }

    public int getCount5Win() {
        return count5Win;
    }

    private void getLottoWin(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> lottoRandom, long userTicket) {
        for (int i = 0; i < userTicket; i++) {
            List<Integer> createLottoNumbers = new ArrayList<>(lottoNumbers);
            List<Integer> createRandomNumbers = new ArrayList<>(lottoRandom.get(i));
            if (lottoRandom.get(i).contains(bonusNumber)) {
                continue;
            }
            createRandomNumbers.retainAll(createLottoNumbers);
            int winNumber = createRandomNumbers.size();
            if (winNumber >= 3) {
                numberOfWin.add(winNumber);
            }
        }
    }

    private void getBonusWin(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> lottoRandom, long userTicket) {
        for (int i = 0; i < userTicket; i++) {
            List<Integer> retainLottoNumbers = new ArrayList<>(lottoNumbers);
            List<Integer> retainRandomNumbers = new ArrayList<>(lottoRandom.get(i));
            if (!(lottoRandom.get(i).contains(bonusNumber))) {
                continue;
            }
            retainRandomNumbers.retainAll(retainLottoNumbers);
            int winNumber = retainRandomNumbers.size();
            if (winNumber == 5) {
                count2Win++;
            }
        }
    }

    private void getCountWin() {
        for (int i = 0; i < numberOfWin.size(); i++) {
            if (numberOfWin.get(i) == 3) {
                count5Win++;
            }
            if (numberOfWin.get(i) == 4) {
                count4Win++;
            }
            if (numberOfWin.get(i) == 5) {
                count3Win++;
            }
            if (numberOfWin.get(i) == 6) {
                count1Win++;
            }
        }
    }

}
