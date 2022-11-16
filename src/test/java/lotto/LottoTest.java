package lotto;

import domain.Lotto;
import domain.Lottos;

import domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;
import view.Input;
import view.Output;
import view.Valid;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Nested
    class InputNumber {
        //given
        view.Input input = new Input();
        @DisplayName("입력받은 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void isNotMultipleOf_1000() {
            //when
            String price = "6430";
            // then
            assertThatThrownBy(() -> input.savePrice(price))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }

        @DisplayName("입력받은 금액이 1000원으로 나누어지면 로또 개수가 출력된다.")
        @Test
        void isMultipleOf_1000() {
            //when
            String price = "6000";
            // then
            input.savePrice(price);
            assertThat(input.getNumber()).isEqualTo(6);
        }
    }

    @Nested
    class GenerateLotto {
        //given
        int numberOfLotto = 6;
        domain.Lottos lottos = new Lottos(numberOfLotto);
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumber = numberGenerator.getLotto().getNumbers();
        @DisplayName("로또 안의 숫자가 6개인지 확인")
        @Test
        void checkLottoNumber() {
            //then
            assertThat(lottoNumber.size())
                    .isEqualTo(6);
        }

        @DisplayName("로또에 중복된 숫자가 들어가진 않았는지 확인")
        @Test
        void checkLottoRepeatNumber() {
            //when
            Set<Integer> LottoSet = new HashSet<>(lottoNumber);
            //then
            assertThat(LottoSet.size()).isEqualTo(lottoNumber.size());
        }

        @DisplayName("저장된 로또의 개수가 주어진 값과 맞는지 확인")
        @Test
        void checkNumberOfLotto() {
            //then
            assertThat(lottos.getLottos().size()).isEqualTo(numberOfLotto);
        }
    }

    @Nested
    class CheckInputAnswerValid {
        //given
        Input input = new Input();
        @DisplayName("로또 번호에 숫자가 아닌 문자가 들어가면 예외가 발생한다")
        @Test
        void notNumber() {
            //when
            String[] answer = {"j","2","3","3","5","6"};
            //then
            assertThatThrownBy(() -> input.saveAnswer(answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요.");
        }

        @DisplayName("로또 번호의 개수가 중복되면 예외가 발생한다")
        @Test
        void repeatNumberInAnswer() {
            //when
            String[] answer = {"1","2","3","3","5","6"};
            //then
            assertThatThrownBy(() -> input.saveAnswer(answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요.");
        }

        @DisplayName("로또 번호의 개수가 6개 이상이면 예외가 발생한다")
        @Test
        void isNumberOverLength() {
            //when
            String[] answer = {"1","2","9","3","4","5","6"};
            //then
            assertThatThrownBy(() -> input.saveAnswer(answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요.");
        }

        @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다")
        @Test
        void isNumberNotInRange() {
            //when
            String[] answer = {"100","2","1","4","5","6"};
            //then
            assertThatThrownBy(() -> input.saveAnswer(answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요.");
        }
    }

    @Nested
    class CheckInputBonusValid {
        //given
        Input input = new Input();
        @DisplayName("보너스 숫자가 입력 숫자들과 중복될 때")
        @Test
        void repeatBonusNumber() {
            //when
            String[] answer = {"1", "2", "3", "4", "5", "6"};
            String bonus = "3";
            //then
            assertThatThrownBy(() -> input.saveBonus(bonus, answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요.");
        }

        @DisplayName("보너스 숫자가 두 개 이상 입력될 때")
        @Test
        void enterBonusNumberOverOne() {
            //when
            String[] answer = {"1","2","3","3","5","6"};
            String bonus = "4,6";
            //then
            assertThatThrownBy(() -> input.saveBonus(bonus, answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요.");
        }

        @DisplayName("보너스 숫자가 1~46 사이의 수가 아닐 때")
        @Test
        void isNumberNotInRange() {
            //when
            String[] answer = {"1","2","3","3","5","6"};
            String bonus = "50";
            //then
            assertThatThrownBy(() -> input.saveBonus(bonus, answer))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요.");
        }
    }

    @Nested
    class CheckOutputValueCorrect {
        //given
        Output output = new Output();
        List<List<Integer>> lottos = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int bonus = 0;
        @DisplayName("수익률이 정상적으로 출력되는지 확인_소수점_X")
        @Test
        void isProfitCorrectWorking() {
            //given
            lottos.add(Arrays.asList(1,2,3,4,5,6));
            lottos.add(Arrays.asList(7,8,9,10,11,12));
            answer = Arrays.asList(1,3,5,7,9,11);
            bonus = 19;
            //when
            output.setRankList(lottos, answer, bonus);
            int lottoPieces = 2;
            //then
            assertThat(output.calcProfitRate(lottoPieces)).isEqualTo(500.0);
        }

        @DisplayName("수익률이 정상적으로 출력되는지 확인_소수점_O")
        @Test
        void isProfitCorrectWorking_double() {
            //given
            for(int i = 1; i <= 9; i++) {
                lottos.add(Arrays.asList(i, 2*i, 3*i, 4*i, 5*i, 4*i+3));
            }
            answer = Arrays.asList(1,2,3,18,39,37);
            bonus = 45;
            //when
            output.setRankList(lottos, answer, bonus);
            int lottoPieces = 9;
            //then
            assertThat(output.calcProfitRate(lottoPieces)).isEqualTo(55.6);
        }
    }

    @Nested
    class LottoItselfValidate {
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
