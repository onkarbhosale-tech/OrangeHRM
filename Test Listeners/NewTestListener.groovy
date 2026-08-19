import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
    @BeforeTestSuite
    def loadExcelData(TestSuiteContext testSuiteContext) {
        TestData data = TestDataFactory.findTestData('Data Files/LoginData')
		
        Map<String, Map<String, String>> allData = new HashMap<>()

        for (int row = 1; row <= data.getRowNumbers(); row++) {
            String tcName = data.getValue('TestCaseToRun', row)
            Map<String, String> rowMap = new HashMap<>()
            for (int col = 1; col <= data.getColumnNumbers(); col++) {
				
				for (String colName : data.getColumnNames()) {
					rowMap.put(colName, data.getValue(colName, row))
				}
				
                rowMap.put(data.allData, data.getValue(col, row))
            }
            allData.put(tcName, rowMap)
        }

        GlobalVariable.sharedData = allData
        println("Loaded test data: " + GlobalVariable.sharedData)
    }

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
}