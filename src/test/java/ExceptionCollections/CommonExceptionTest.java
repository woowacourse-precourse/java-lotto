package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CommonExceptionTest {
    @DisplayName("문자열이 포함되어 있는지 확인한다.")
    @Test
    void 문자열_포함_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.hasCharacters("1a")
        );
    }
}
