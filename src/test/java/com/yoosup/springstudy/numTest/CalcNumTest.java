package com.yoosup.springstudy.numTest;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcNumTest {
    Calculator calculator;
    String numFilePath;

    @Before
    public void setup(){
        this.calculator = new Calculator();
        this.numFilePath = "C:\\Users\\brian\\OneDrive\\Desktop\\spring_practice\\springStudy\\src\\test\\java\\com\\yoosup\\springstudy\\numTest\\numbers.txt";
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(this.numFilePath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.numFilePath), is(24));
    }

    @Test
    @DisplayName("numbers.txt 파일경로 테스트")
    public void activeNumbersFilePath() {
        System.out.println(getClass().getResource(numFilePath).getPath());
    }
}
