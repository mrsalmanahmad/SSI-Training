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

String url = GlobalVariable.URL
String user_Name = GlobalVariable.UserName
String user_Password = GlobalVariable.Password

String username = 'Object Repository/Page_Hireify BackOffice/input_Username_username'
String userpassword = 'Object Repository/Page_Hireify BackOffice/input_Password_password'
String login_btn = 'Object Repository/Page_Hireify BackOffice/input_Password_LG-btn'

//WebUI.openBrowser(url, FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser("https://backoffice.hireify.co/login")
WebUI.maximizeWindow()

WebUI.sendKeys(findTestObject(username), user_Name, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject(userpassword), user_Password, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject(login_btn), FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait()