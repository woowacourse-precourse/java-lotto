package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SampleTest {
    private final Sample sample;

    public SampleTest(){
        this.sample = new Sample();
    }
    @Test
    void stringToIntTest1(){
        assertThatThrownBy(() -> sample.stringToInt("12ab12")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntTest2(){
        assertThatThrownBy(() -> sample.stringToInt("123452853740958342000")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test

    void stringToIntTest3(){
        assertThatThrownBy(() -> sample.stringToInt("135700")).isInstanceOf(IllegalArgumentException.class);
    }
}