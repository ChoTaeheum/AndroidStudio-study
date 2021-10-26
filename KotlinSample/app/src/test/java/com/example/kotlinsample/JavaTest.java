package com.example.kotlinsample;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {
    @Test
    public void test1() {
        Assert.assertEquals(4, 2 + 2);
    }
}

// @Test 어노테이션은 함수가 '단위 테스트용 함수'라는 것을 알려준다.