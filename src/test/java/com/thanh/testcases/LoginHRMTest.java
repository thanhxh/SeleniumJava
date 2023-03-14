package com.thanh.testcases;

import com.thanh.common.BaseTest;
import org.testng.annotations.Test;

public class LoginHRMTest extends BaseTest {
    @Test
    public void testLogin() {
        getLoginHRMPage().login();
    }
}
