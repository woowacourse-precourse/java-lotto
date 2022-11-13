package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberGeneratorTest {

    @DisplayName("구매 금액만큼 로또 수량을 발행한다.")
    @Test
    void createLottoEqualToPurchasePrice() {
        final int purchasePrice = 8000;
        final NumberGenerator numberGenerator = new NumberGenerator();
        assertThat(numberGenerator.calculatorLottoQuantity(purchasePrice)).isEqualTo(8);
    }

    @DisplayName("당첨 번호 데이터 타입(String[] -> List<Integer>)로 변환한다.")
    @Test
    void convertedDataTypeStringToListInteger() {
        String[] inputValue = "1,2,3,4,5,6".split(",");
        ;
        List<Integer> test = new ArrayList<>();
        final NumberGenerator numberGenerator = new NumberGenerator();
        assertThat(numberGenerator.convertedLottoNumbers(List.of(inputValue)).getClass().getName())
                .isEqualTo(test.getClass().getName());
    }

    @DisplayName("구매금액이 1000원 단위로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchasePriceNotDividedThousands() {
        final int purchasePrice = 1500;
        assertThatThrownBy(() -> new NumberGenerator()
                .exceptionDividedIntoThousands(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호를 입력하지 않았을 경우 예외가 발생한다.")
    @Test
    void enteredNoValue() {
        assertThatThrownBy(() -> new NumberGenerator()
                .addComputerNumber(new ArrayList<>(Arrays.asList(new String[]{null}))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
