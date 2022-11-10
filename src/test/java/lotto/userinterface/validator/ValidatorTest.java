package lotto.userinterface.validator;

import lotto.userinterface.condition.Condition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    private static final Validator validator = Validator.getInstance();

    @Test
    void 모든_조건이_참() {
        // given
        List<Condition> conditions = List.of(
                getTrueCondition(),
                getTrueCondition()
        );
        // when
        Integer notPassConditionIndex = validator.getNotPassConditionIndex(conditions, "");

        // then
        assertThat(notPassConditionIndex).isEqualTo(-1);
    }

    @Test
    void 일부_조건이_거짓() {
        // given
        List<Condition> conditions = List.of(
                getTrueCondition(),
                getFalseCondition()
        );
        // when
        Integer notPassConditionIndex = validator.getNotPassConditionIndex(conditions, "");

        // then
        assertThat(notPassConditionIndex).isEqualTo(1);
    }

    private Condition getTrueCondition() {
        return new Condition() {
            @Override
            public Boolean isSatisfied(String input) {
                return true;
            }
        };
    }

    private Condition getFalseCondition() {
        return new Condition() {
            @Override
            public Boolean isSatisfied(String input) {
                return false;
            }
        };
    }
}