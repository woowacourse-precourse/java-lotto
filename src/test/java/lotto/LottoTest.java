package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.application.service.inputvalidator.ValueValidator;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1() {
        List<Integer> inputValue = List.of(1, 2, 0, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 1 ~ 45 사이의 수가 아닌 경우")
    @Test
    void 로또당첨번호입력받기_실패1_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 46, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 하나의 입력값이 아닌 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패() {
        String inputValue = "1,2,3,4,5,6";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 숫자가 아닌경우")
    @Test
    void 보너스로또당첨번호입력받기_실패2() {
        String inputValue = "j";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 로또 당첨번호가 공백인 경우")
    @Test
    void 보너스로또당첨번호입력받기_실패3() {
        String inputValue = " ";
        assertThatThrownBy(() -> ValueValidator.validateIntegerValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateIntegerValue(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 중복된 값이 중간에 나타나는 경우 ")
    @Test
    void 로또당첨번호입력받기_실패2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 1, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 마지막 인덱스와 그 직전 인덱스가 중복된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_2() {
        List<Integer> inputValue = List.of(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 첫 번째 인덱스와, 마지막 인덱스가 중복된 경우")
    @Test
    void 로또당첨번호입력받기_실패2_3() {
        List<Integer> inputValue = List.of(6, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 당첨번호 예외 중복된 수가 입력된 경우 : 첫 번째 인덱스와, 직후의 인덱스가 중복될 경우")
    @Test
    void 로또당첨번호입력받기_실패2_4() {
        List<Integer> inputValue = List.of(6, 6, 3, 4, 5, 1);
        assertThatThrownBy(() -> ValueValidator.validateInputLottoNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateInputLottoNumber(inputValue);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("사용자가 구매한 값을 0으로 입력했을 때")
    @Test
    void 로또구매금액_실패_1() {
        String lottoPurchaseMoney = "0";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("사용자가 구매한 값이 0으로 나누어 떨어지지 않을 때")
    @Test
    void 로또구매금액_실패_1_2() {
        String lottoPurchaseMoney = "1001";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
                }).withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구매 금액을 Integer 범위를 초과한 입력을 했을 때")
    @Test
    void 로또구매금액_실패_2() {
        String lottoPurchaseMoney = "2147483648";
        assertThatThrownBy(() -> ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 갯수와 발급받은 로또 갯수 비교")
    @Test
    void 구매한_로또_갯수와_발급받은_로또_갯수_비교() {
        int purchaseNumber = 11;
        List<List<Integer>> generateLottoNumber = Lotto.generateLottoNumber(purchaseNumber);
        assertThat(generateLottoNumber.size()).isEqualTo(11);
    }

    @DisplayName("구매한 로또가 6개의 수로 이루어졌는지 체크")
    @Test
    void 구매한_로또가_6개의_수로_이루어졌는지_체크() {
        int purchaseNumber = 11;
        List<List<Integer>> generateLottoNumber = Lotto.generateLottoNumber(purchaseNumber);
        for (List<Integer> lotto : generateLottoNumber) {
            assertThat(lotto.size()).isEqualTo(6);
        }
    }

    @DisplayName("당첨 로또 번호 갯수 검증, 보너스 번호 미포함")
    @Test
    void 당첨_로또_번호_갯수_검증_보너스_번호_미포함() {
        String[] lottoNumbers = "1,2,3,4,5,6".split(",");
        List<Integer> convertedLottoNumbers = new ArrayList<>();
        ValueValidator.validateIntegerValue(lottoNumbers);

        for (String value : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(value));
        }
        ValueValidator.validateInputLottoNumber(convertedLottoNumbers);

        assertThat(convertedLottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("당첨 로또 번호 갯수 검증, 보너스 번호 포함")
    @Test
    void 당첨_로또_번호_갯수_검증_보너스_번호_포함() {
        String[] lottoNumbers = "1,2,3,4,5,6".split(",");
        List<Integer> winningLottoNumbers = new ArrayList<>();
        ValueValidator.validateIntegerValue(lottoNumbers);

        for (String value : lottoNumbers) {
            winningLottoNumbers.add(Integer.parseInt(value));
        }
        ValueValidator.validateInputLottoNumber(winningLottoNumbers);

        String inputBonusNumber = "7";
        ValueValidator.validateInputBonusLottoNumber(inputBonusNumber, winningLottoNumbers);
        winningLottoNumbers.add(Integer.valueOf(inputBonusNumber));

        assertThat(winningLottoNumbers.size()).isEqualTo(7);
    }

    @DisplayName("로또 출력 형식 검증 오름차순 정렬이 수행되어야 한다.")
    @Test
    void 로또_출력_형식_검증_오름차순_정렬이_수행되어야_한다() {

        List<Integer> firstLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondLotto = List.of(7, 8, 9, 10, 11, 12);
        List<Integer> thirdLotto = List.of(13, 14, 15, 16, 17, 18);
        List<Integer> fourth = List.of(19, 20, 21, 22, 23, 24);
        List<Integer> fifth = List.of(25, 26, 27, 28, 29, 30);
        List<Integer> sixth = List.of(31, 32, 33, 34, 35, 36);
        List<Integer> seventh = List.of(37, 38, 39, 40, 41, 42);
        List<Integer> eighth = List.of(43, 44, 45, 1, 2, 3);
        List<List<Integer>> generatedLottoNumber = new ArrayList<>() {{
            add(firstLotto);
            add(secondLotto);
            add(thirdLotto);
            add(fourth);
            add(fifth);
            add(sixth);
            add(seventh);
            add(eighth);
        }};

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (List<Integer> eachLottoPaper : generatedLottoNumber) {
            System.out.println(Arrays.toString(Arrays.stream(eachLottoPaper.toArray()).sorted().toArray()));
        }

        Assertions.assertThat(out.toString()).contains("[1, 2, 3, 4, 5, 6]");
        Assertions.assertThat(out.toString()).contains("[1, 2, 3, 43, 44, 45]");
    }

    @DisplayName("수익률 계산 로직 검증")
    @Test
    void 수익률_계산() {
        int purchaseMoney = 8000;
        int winningMoney = 5000;
        double yield = (double) winningMoney / (double) purchaseMoney * 100;

        assertThat(Math.round(yield * 10) / 10.0).isEqualTo(62.5);
    }

    @DisplayName("수익률이 100일때 출력형식 검증 : 100이 아니라, 100.0 이 출력되어야 한다.")
    @Test
    void 수익률이100일때_출력형식_검증() {

        int purchaseMoney = 5000;
        int winningMoney = 5000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 100.0%입니다.").isEqualTo(out.toString());
    }

    @DisplayName("수익률 소수점 둘째자리에서 반올림")
    @Test
    void 수익률_소수점_둘째자리에서_반올림() {
        int purchaseMoney = 9000;
        int winningMoney = 15000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 166.7%입니다.").isEqualTo(out.toString());
    }

    @DisplayName("수익률 출력 테스트")
    @Test
    void 수익률_출력_테스트() {
        int purchaseMoney = 8000;
        int winningMoney = 5000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 62.5%입니다.").isEqualTo(out.toString());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
