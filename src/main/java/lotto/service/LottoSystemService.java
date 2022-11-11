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
    private List<String> total = Arrays.asList( "3개 일치 (5,000원) - ",
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

    public void setAnswerLottoNumbers(){
         String inputNumbers = Console.readLine();

         for(int i=0; i<inputNumbers.length(); i++){
             if (i % 2 == 0) {
                 numbers.add((int) inputNumbers.charAt(i));
             }
         }
    }

}
