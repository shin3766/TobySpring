package com.yoosup.springstudy.numTest;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcNumTest {
    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum(getClass().getResource(
                "numbers.txt"
        ).getPath());
        assertThat(sum, is(10));
    }
}
