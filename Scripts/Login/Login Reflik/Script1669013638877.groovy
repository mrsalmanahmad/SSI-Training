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

String url = GlobalVariable.ReflikURL
String user_Name = GlobalVariable.Reflik_UserName
String user_Password = GlobalVariable.Reflik_Password

String username = 'Object Repository/Reflik Objects/Page_Sign In  Login  Reflik/input_Enter your Email ID and password_email'
String userpassword = 'Object Repository/Reflik Objects/Page_Sign In  Login  Reflik/input_Enter your Email ID and password_password'
String login_btn = 'Object Repository/Reflik Objects/Page_Sign In  Login  Reflik/input_Forgot password_submit'

//WebUI.openBrowser(url, FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser(url)
WebUI.maximizeWindow()

WebUI.sendKeys(findTestObject(username), user_Name, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject(userpassword), user_Password, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject(login_btn), FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait()

WebUI.navigateToUrl("https://www.reflik.com/recruiter/newsearch")
WebUI.enableSmartWait()

WebUI.navigateToUrl("https://www.reflik.com/recruiter/newsearch")
WebUI.enableSmartWait()