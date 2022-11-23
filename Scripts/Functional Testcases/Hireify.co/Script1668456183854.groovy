import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String DataFilePath = "Data Files/Job Keywords/JobsKeywords"
String Job_Status = ""
WebUI.callTestCase(findTestCase("Test Cases/Login/Login"), null, FailureHandling.STOP_ON_FAILURE)

ArrayList<String> mylist = new ArrayList<String>()

WebUI.comment('Search Jobs')
for(def rowNum=1;rowNum<=findTestData(DataFilePath).getRowNumbers();rowNum++) {
	WebUI.callTestCase(findTestCase('Test Cases/Jobs Page/Lookups/Search a job'),
		[('Text'):findTestData(DataFilePath).getValue(1, rowNum)],
		FailureHandling.STOP_ON_FAILURE)
	
	Job_Status = WebUI.callTestCase(findTestCase('Test Cases/Jobs Page/Lookups/Check if Jobs Displayed or Empty'),
		[('Text'):findTestData(DataFilePath).getValue(1, rowNum)],
		FailureHandling.STOP_ON_FAILURE)
	
	if(Job_Status == "Job Found") {
		// Clear Search and on to the next word
//		WebUI.callTestCase(findTestCase('Test Cases/Save to Excel File/Save data to Excel File'),
//			[:],
//			FailureHandling.STOP_ON_FAILURE)
	}
	else if(Job_Status == "Not Found") {
		// Save this keyword in excel file
		//
		mylist.add(findTestData(DataFilePath).getValue(1, rowNum))
	}
	WebUI.enableSmartWait()
	
	System.out.println(mylist);
}

CustomKeywords.'com.hr.hireify.WritetoExcelFile'(mylist, GlobalVariable.KeywordsPath)

//CustomKeywords.'com.hr.hireify.writeExcel'(mylist)
//CustomKeywords.'com.hr.hireify.WritetoExcelFile'(null, 0)