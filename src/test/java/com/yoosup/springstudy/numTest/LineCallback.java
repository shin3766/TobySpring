package com.yoosup.springstudy.numTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface LineCallback {
    Integer doSomethingWithLine(String line, Integer value);
}
