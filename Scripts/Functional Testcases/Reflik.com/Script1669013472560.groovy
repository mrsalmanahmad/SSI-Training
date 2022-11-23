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

String DataFilePath = "Data Files/Job Keywords/Reflik Jobs Keywords"
String Job_Status = ""
WebUI.callTestCase(findTestCase("Test Cases/Login/Login Reflik"), null, FailureHandling.STOP_ON_FAILURE)

ArrayList<String> mylist = new ArrayList<String>()

WebUI.comment('Search Jobs')
for(def rowNum=1;rowNum<=findTestData(DataFilePath).getRowNumbers();rowNum++) {
	WebUI.callTestCase(findTestCase('Test Cases/Jobs Page/Reflik/Lookups/Search a job'),
		[('Text'):findTestData(DataFilePath).getValue(1, rowNum)],
		FailureHandling.STOP_ON_FAILURE)
	
	Job_Status = WebUI.callTestCase(findTestCase('Test Cases/Jobs Page/Reflik/Lookups/Check if Jobs Displayed or Empty'),
		[('Text'):findTestData(DataFilePath).getValue(1, rowNum)],
		FailureHandling.STOP_ON_FAILURE)
	
	if(Job_Status == "Job Found") {
		// Clear Search and on to the next word
//		WebUI.callTestCase(findTestCase('Test Cases/Save to Excel File/Save data to Excel File'),
//			[:],
//			FailureHandling.STOP_ON_FAILURE)
		WebUI.comment("I found the job up to the next keyword now")
	}
	else if(Job_Status == "Not Found") {
		// Save this keyword in excel file
		//
		WebUI.comment("Didn't found any job save this keyword into the excel file")
		mylist.add(findTestData(DataFilePath).getValue(1, rowNum))
	}
	WebUI.enableSmartWait()
	
	System.out.println(mylist);
}

String finalpath =  GlobalVariable.Reflik_KeywordPath +  GlobalVariable.Reflik_filename

CustomKeywords.'com.hr.hireify.WritetoExcelFile'(mylist, finalpath)

//CustomKeywords.'com.hr.hireify.writeExcel'(mylist)
//CustomKeywords.'com.hr.hireify.WritetoExcelFile'(null, 0)