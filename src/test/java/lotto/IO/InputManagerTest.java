package lotto.IO;

import lotto.view.InputManager;
import lotto.view.InputUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class InputManagerTest {
    @DisplayName("당첨번호 입력 6개 이상일때 익셉션 테스트")
    @Test
    void inputCheckLenght() throws NoSuchMethodException, IllegalAccessException {
        InputManager manager = new InputManager();
        Method method = manager.getClass().getDeclaredMethod("makeWinNumber", String.class);
        method.setAccessible(true);
        String exceptionMessage;
        try {
            // private method에 접근하기 위해 reflaction을 활용
            method.invoke(manager,"1,2,3,4,5,6,7"); // 6자리를 넘어간 인풋 입력
        } catch (InvocationTargetException e) {
            /* reflaction을 활용하기 위해 invoke 메서드를 사용할시 예외 처리의 결과가 InvocationTargetException으로
            래핑되어서 나타남 나타난 익셉션을 겟 타겟 익셉션을 활용 투스트링으로 데이터 추출후 테스트 케이스 비교를 통해 일리걸 익셉션 여부 체크 */
            exceptionMessage = e.getTargetException().toString();
            assertThat(exceptionMessage).contains("IllegalArgumentException");
        }
    }

    @DisplayName("당첨번호 입력 숫자가 아닐 때 익셉션 테스트")
    @Test
    void inputCheckNumber() throws NoSuchMethodException, IllegalAccessException {
        InputManager manager = new InputManager();
        Method method = manager.getClass().getDeclaredMethod("makeWinNumber", String.class);
        method.setAccessible(true);
        String exceptionMessage;
        try {
            // private method에 접근하기 위해 reflaction을 활용
            method.invoke(manager,"1,2,3,4,5,a"); // 당첨번호에 숫자가 아닌값 입력
        } catch (InvocationTargetException e) {
            /* reflaction을 활용하기 위해 invoke 메서드를 사용할시 예외 처리의 결과가 InvocationTargetException으로
            래핑되어서 나타남 나타난 익셉션을 겟 타겟 익셉션을 활용 투스트링으로 데이터 추출후 테스트 케이스 비교를 통해 일리걸 익셉션 여부 체크 */
            exceptionMessage = e.getTargetException().toString();
            assertThat(exceptionMessage).contains("IllegalArgumentException");
        }
    }

    @DisplayName("당첨번호 중복된 숫자가 입력 되었을 때 익셉션 테스트")
    @Test
    void inputCheckDuplicate() throws NoSuchMethodException, IllegalAccessException {
        InputManager manager = new InputManager();
        Method method = manager.getClass().getDeclaredMethod("makeWinNumber", String.class);
        method.setAccessible(true);
        String exceptionMessage;
        try {
            // private method에 접근하기 위해 reflaction을 활용
            method.invoke(manager,"1,2,3,4,5,5"); // 당첨번호에 숫자가 아닌값 입력
        } catch (InvocationTargetException e) {
            /* reflaction을 활용하기 위해 invoke 메서드를 사용할시 예외 처리의 결과가 InvocationTargetException으로
            래핑되어서 나타남 나타난 익셉션을 겟 타겟 익셉션을 활용 투스트링으로 데이터 추출후 테스트 케이스 비교를 통해 일리걸 익셉션 여부 체크 */
            exceptionMessage = e.getTargetException().toString();
            assertThat(exceptionMessage).contains("IllegalArgumentException");
        }
    }

}
