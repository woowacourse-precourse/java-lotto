package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Validator validator = Context.getValidator();

    @Test
    void 숫자1과45사이검증() {
        assertThat(validator.isBetween1And45(1)).isTrue();
        assertThat(validator.isBetween1And45(5)).isTrue();
        assertThat(validator.isBetween1And45(44)).isTrue();
        assertThat(validator.isBetween1And45(45)).isTrue();
        assertThat(validator.isBetween1And45(0)).isFalse();
        assertThat(validator.isBetween1And45(46)).isFalse();
    }

    @Test
    void 숫자리스트에중복된숫자있는지검증() {
        List<Integer> duplicatedList = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> notDuplicatedList = List.of(1, 2, 3, 4, 5, 6);
        assertThat(validator.isContainDuplicateNumber(duplicatedList)).isTrue();
        assertThat(validator.isContainDuplicateNumber(notDuplicatedList)).isFalse();
    }

    @Test
    void 입력된문자열이모두숫자로만이루어졌는지검증() {
        assertThat(validator.isAllDigit("123435901")).isTrue();
        assertThat(validator.isAllDigit("1234 35901")).isFalse();
        assertThat(validator.isAllDigit("1234,35901")).isFalse();
    }

    @Test
    void 당첨번호문자열의컴마는5개여야한다() {
        assertThat(validator.isProperNumbersLineFormat("1,2,3,4,5,6", ",")).isTrue();
        assertThat(validator.isProperNumbersLineFormat("1,2,3,4,5,6,7", ",")).isFalse();
    }

    @Test
    void 당첨번호문자열에는공백이없어야한다() {
        assertThat(validator.isProperNumbersLineFormat("1,2,3,4, 5,6", ",")).isFalse();
    }

    @Test
    void 당첨번호문자열은숫자거나컴마여야한다() {
        assertThat(validator.isProperNumbersLineFormat("1,2,3,4,5,6", ",")).isTrue();
        assertThat(validator.isProperNumbersLineFormat("1,2,L,4,5,6", ",")).isFalse();
        assertThat(validator.isProperNumbersLineFormat("1,2,3j,4,5,6", ",")).isFalse();
        assertThat(validator.isProperNumbersLineFormat("1,2.3,4,5,6", ",")).isFalse();
    }
}