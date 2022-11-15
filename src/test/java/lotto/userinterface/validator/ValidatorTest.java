package lotto.userinterface.validator;

import lotto.condition.Condition;
import lotto.validator.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        Condition notPassCondition = validator.getNotPassCondition(conditions, "");

        // then
        assertThat(notPassCondition).isNull();
    }

    @Test
    void 일부_조건이_거짓() {
        // given
        List<Condition> conditions = List.of(
                getTrueCondition(),
                getFalseCondition()
        );
        // when
        Condition notPassCondition = validator.getNotPassCondition(conditions, "");

        // then
        assertThat(notPassCondition).isNotNull();
    }

    private Condition getTrueCondition() {
        return new Condition() {
            @Override
            public Boolean isSatisfied(String input) {
                return true;
            }

            @Override
            public String getErrorMessage() {
                return "[ERROR]";
            }
        };
    }

    private Condition getFalseCondition() {
        return new Condition() {
            @Override
            public Boolean isSatisfied(String input) {
                return false;
            }

            @Override
            public String getErrorMessage() {
                return "[ERROR]";
            }
        };
    }
}