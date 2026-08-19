package login

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class LoginTCMapping {

    @Keyword
    def executeLoginTestCases(String testCaseName, String username, String password) {
        WebUI.callTestCase(
            findTestCase("Test Cases/Login/"+testCaseName),
            [
                'Username': username,
                'Password': password
            ],
            FailureHandling.STOP_ON_FAILURE
        )
    }
}
