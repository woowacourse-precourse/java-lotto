package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("getMyLottos()")
    @Test
    void getMyLottos() {
    	
    	int purchaseQuantity = 10;
        assertThat(Application.getMyLottos(purchaseQuantity).size() == purchaseQuantity);
    }
    
    @DisplayName("compareNumbers()")
    @Test
    void compareNumbers() {
    	
    	List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    	Integer bonusNumber = 7;
    	
    	List<List<Integer>> myLottos = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7)));
    	List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 1, 1));
    	
        assertThat(Comparison.compareNumbers(winningNumbers, myLottos, bonusNumber).equals(result));
    }
    
    @DisplayName("countCorrectNumbers()")
    @Test
    void countCorrectNumbers() {
    	
    	List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<Integer> myLotto = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    	
        assertThat(Comparison.countCorrectNumbers(winningNumbers, myLotto) == 6);
    }
    
    @DisplayName("updateLottoResult()")
    @Test
    void updateLottoResult() {
    	
    	int index = 7;
    	List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
    	List<Integer> _result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1));
    	
        assertThat(Comparison.updateLottoResult(result, index).equals(_result));
    }
    
    @DisplayName("getLottoResultMessage()")
    @Test
    void getLottoResultMessage() {
    	
    	int index = 7;
    	Integer numberOfTimes = 1;
    	
        assertThat(Result.getLottoResultMessage(index, numberOfTimes).equals("5개 일치, 보너스 볼 일치 (30,000,000원) - " + numberOfTimes + "개"));
    }
    
    @DisplayName("getRateOfReturn()")
    @Test
    void getRateOfReturn() {
    	
    	int payment = 10000;
    	List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 6, 0, 0, 0, 0));
    	
        assertThat(Result.getRateOfReturn(payment, result).equals("200"));
    }
    
    @DisplayName("getTotalPrizeMoney()")
    @Test
    void getTotalPrizeMoney() {
    	
    	int payment = 10000;
    	List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 6, 0, 0, 0, 0));
    	
        assertThat(Result.getTotalPrizeMoney(payment, result) == 20000);
    }
    
    @DisplayName("getPrizeMoney()")
    @Test
    void getPrizeMoney() {
    	
    	int index = 7;
        assertThat(Result.getPrizeMoney(index) == 30000000);
    }
}
