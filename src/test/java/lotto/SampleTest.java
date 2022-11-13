package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SampleTest {

    @Test
    void stringToIntTest1(){
        assertThatThrownBy(() -> Sample.stringToInt("12ab12")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntTest2(){
        assertThatThrownBy(() -> Sample.stringToInt("123452853740958342000")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test

    void stringToIntTest3(){
        assertThatThrownBy(() -> Sample.stringToInt("135700")).isInstanceOf(IllegalArgumentException.class);
    }
}