package lotto.controller;

import lotto.service.TestService;

public class TestController {
    private TestService testService;
    public TestController(
        TestService testService
    ) {
        this.testService = testService;
    }

    public void foo() {
        this.testService.fooService();
    }
}
