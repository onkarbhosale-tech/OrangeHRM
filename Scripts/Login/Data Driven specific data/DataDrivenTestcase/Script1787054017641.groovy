import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


TestData data = TestDataFactory.findTestData("Data Files/Login/DataDrivenTest");

String testCaseName = "Login with valid credentials";

int totalRows = data.getRowNumbers()
String tcName, Username, Password;

for(int row=1;row <= totalRows;row++)
{
	tcName = data.getObjectValue("TCName", row);
	
	if(tcName.equalsIgnoreCase(testCaseName))
	{
		Username = data.getObjectValue("Username", row);
		Password= data.getObjectValue("Password", row);
		break;
	}
	
}

WebUI.openBrowser(null)

WebUI.navigateToUrl(GlobalVariable.Url)

WebUI.setText(findTestObject('Page_OrangeHRM/input_Username'), Username)

WebUI.setEncryptedText(findTestObject('Page_OrangeHRM/input_Password'), Password)

WebUI.click(findTestObject('Page_OrangeHRM/button_Login'))

WebUI.assertElementPresent(findTestObject('Page_OrangeHRM/h6_Dashboard'), 0)

WebUI.takeFullPageScreenshotWithScroll()

WebUI.closeBrowser()





