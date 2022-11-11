package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    
    @DisplayName("',' 를 구분자로 나눈 순서가 유지된 리스트를 반환한다.")
    @Test
    void splitNumberStringByCommaRegex() {
        String input = "1,2,3,4,5";
        String regex = ",";
        List<Integer> expectResult = List.of(1, 2, 3, 4, 5);
        
        assertThat(UserInput.splitNumberString(input, regex)).isEqualTo(expectResult);
    }
    
    @DisplayName("숫자간 공백이 있어도 숫자로 변환할 수 있어야 한다.")
    @Test
    void splitNumberStringWithSpace() {
        String input = "1, 2, 3, 4  ,5";
        String regex = ",";
        List<Integer> expectResult = List.of(1, 2, 3, 4, 5);
        
        assertThat(UserInput.splitNumberString(input, regex)).isEqualTo(expectResult);
    }
}
