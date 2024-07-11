package com.yoosup.springstudy.numTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
