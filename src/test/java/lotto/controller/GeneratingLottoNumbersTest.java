package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class GeneratingLottoNumbersTest {

    GeneratingLottoNumbers generatingLottoPaper = new GeneratingLottoNumbers();

    boolean isLottoNumberDuplicate(Lotto lottoPaper){
        List<Integer> lottoNumbers = lottoPaper.getNumbers();
        Collections.sort(lottoNumbers);
        for(int lottoIndex = 1; lottoIndex < lottoNumbers.size(); lottoIndex++){
            if(lottoNumbers.get(lottoIndex).equals(lottoNumbers.get(lottoIndex - 1))){
                return true;
            }
        }
        return false;
    }

    boolean isLottoNumbersNotInRange(Lotto lottoPaper){
        List<Integer> lottoNumbers = lottoPaper.getNumbers();
        for (int lottoNumber : lottoNumbers) {
            if (!(1 <= lottoNumber && lottoNumber <= 45)) {
                return true;
            }
        }
        return false;
    }

    @DisplayName("하나의 로또종이를 뽑을 때의 테스트, 1000번 시행해서 다 만족해야 함.")
    @Test
    void generateOneLottoPaperTest() {
        AtomicBoolean alwaysBeValid = new AtomicBoolean(true);
        final int howMuchToPlay = 1000;
        assertSimpleTest(() -> {
            for(int playingCount = 0; playingCount < howMuchToPlay; playingCount++){
                Lotto lottoPaper = generatingLottoPaper.generateOneLottoPaper();
                if(isLottoNumberDuplicate(lottoPaper) || isLottoNumbersNotInRange(lottoPaper)){
                    alwaysBeValid.set(false);
                    break;
                }
            }
            assertThat(alwaysBeValid).isTrue();
        });

    }

    @DisplayName("로또를 주어진 수만큼 뽑을 수 있는지 보기. 예외는 한개뽑을 때 이미 처리함.")
    @Test
    void generatingAllLottoPapers_case1() {
        int input = 8;
        List<Lotto> allLottoPapers = generatingLottoPaper.generatingAllLottoPapers(input);
        assertThat(allLottoPapers.size()).isEqualTo(input);
    }

    @DisplayName("로또를 주어진 수만큼 뽑을 수 있는지 보기. 예외는 한개뽑을 때 이미 처리함.")
    @Test
    void generatingAllLottoPapers_case2() {
        int input = 1000;
        List<Lotto> allLottoPapers = generatingLottoPaper.generatingAllLottoPapers(input);
        assertThat(allLottoPapers.size()).isEqualTo(input);
    }
}