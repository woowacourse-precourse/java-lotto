package lotto;

import lotto.model.Lotto;
import lotto.view.InputUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IoTest {
    @DisplayName("1000으로 나누어 지지 않는 값을 넣었을때 일리걸 익셉션 발생 테스트")
    @Test
    void inputCheck1000() throws NoSuchMethodException, IllegalAccessException {
        InputUser user = new InputUser();
        Method method = user.getClass().getDeclaredMethod("checkPurchase", String.class);
        method.setAccessible(true);
        String exceptionMessage;
        try {
            // private method에 접근하기 위해 reflaction을 활용
            method.invoke(user,"1021"); //1000으로 나누어 지지 않는 값을 삽입
        } catch (InvocationTargetException e) {
            /* reflaction을 활용하기 위해 invoke 메서드를 사용할시 예외 처리의 결과가 InvocationTargetException으로
            래핑되어서 나타남 나타난 익셉션을 겟 타겟 익셉션을 활용 투스트링으로 데이터 추출후 테스트 케이스 비교를 통해 일리걸 익셉션 여부 체크 */
            exceptionMessage = e.getTargetException().toString();
            assertThat(exceptionMessage).contains("IllegalArgumentException");
        }
    }

    @DisplayName("숫자가 아닌 값을 넣었을때 일리걸 익셉션 발생 테스트")
    @Test
    void inputCheckNum() throws NoSuchMethodException, IllegalAccessException {
        InputUser user = new InputUser();
        Method method = user.getClass().getDeclaredMethod("checkPurchase", String.class);
        method.setAccessible(true);
        String exceptionMessage;
        try {
            // private method에 접근하기 위해 reflaction을 활용
            method.invoke(user,"1000j"); //1000으로 나누어 지지 않는 값을 삽입
        } catch (InvocationTargetException e) {
            /* reflaction을 활용하기 위해 invoke 메서드를 사용할시 예외 처리의 결과가 InvocationTargetException으로
            래핑되어서 나타남 나타난 익셉션을 겟 타겟 익셉션을 활용 투스트링으로 데이터 추출후 테스트 케이스 비교를 통해 일리걸 익셉션 여부 체크 */
            exceptionMessage = e.getTargetException().toString();
            assertThat(exceptionMessage).contains("IllegalArgumentException");
        }
    }
}
