package lotto.input;

public class MockInputReader implements InputReader {
    private String mockData;

    public MockInputReader(String mockData) {
        this.mockData = mockData;
    }

    @Override
    public String readLine() {
        return this.mockData;
    }
}
