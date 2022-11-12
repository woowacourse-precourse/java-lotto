package lotto.modelTest;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Buyer;
import org.assertj.core.error.ShouldBeBlank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {
    @Test
    public void 발행할_로또의_수_구하기_최소_구매_단위(){
        List<Integer> purchaseAmounts = List.of(10000, 12000, 1000, 3000, 4000);
        List<Integer> resultPurchaseAmounts = new ArrayList<>();

        for(int purchaseAmount:purchaseAmounts){
            resultPurchaseAmounts.add(purchaseAmount/1000);
        }
        assertThat(resultPurchaseAmounts).containsExactly(10, 12, 1, 3, 4);
    }
    @Test
    public void 발행할_로또의_수_구하기_최소_구매_단위_이하_포함(){
        List<Integer> purchaseAmounts = List.of(10000, 12000, 1000, 3000, 4000, 4500, 5500);
        List<Integer> resultPurchaseAmounts = new ArrayList<>();

        for(int purchaseAmount:purchaseAmounts){
            resultPurchaseAmounts.add(purchaseAmount/1000);
        }
        assertThat(resultPurchaseAmounts).containsExactly(10, 12, 1, 3, 4, 4, 5);
    }
    @ParameterizedTest
    @ValueSource(ints={10500, 10010, 10001})
    public void 구매_금액이_최소_구매_단위인지_확인하기(int purchaseAMount){
        assertThatThrownBy(()->new Buyer(purchaseAMount)).isInstanceOf(IllegalArgumentException.class);
    }
}
