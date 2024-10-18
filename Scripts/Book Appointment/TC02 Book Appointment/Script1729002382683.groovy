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

CucumberKW.comment('Given user is in Book appointment page')

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Home page/a_Make Appointment'))

CustomKeywords.'appointment.UserLoginHelper.UserLoginApplication'()

CucumberKW.comment('When user inputs valid data')

WebUI.verifyElementVisible(findTestObject('Page_Make Appointment/button_Make Appointment'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Make Appointment/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Seoul CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/Page_Make Appointment/label_Apply for hospital readmission'))

WebUI.click(findTestObject('Page_Make Appointment/label_Healthcare Program Option', [('program') : 'Medicaid']))

WebUI.click(findTestObject('Page_Make Appointment/input_Visit Date (Required)_visit_date'))

WebUI.click(findTestObject('Page_Make Appointment/td_30'))

WebUI.setText(findTestObject('Object Repository/Page_Make Appointment/textarea_Comment_comment'), 'My comment')

WebUI.click(findTestObject('Page_Make Appointment/button_Make Appointment'))

CucumberKW.comment('Then user can see Appointment Confirmation page')

WebUI.verifyElementVisible(findTestObject('Page_Appointment Confirmation/header_Appointment Confirmation'))

WebUI.verifyElementText(findTestObject('Page_Appointment Confirmation/text_Appointment Information', [('appointment_info') : 'facility']), 
    'Seoul CURA Healthcare Center')

WebUI.verifyElementText(findTestObject('Page_Appointment Confirmation/text_Appointment Information', [('appointment_info') : 'hospital_readmission']), 
    'Yes')

WebUI.verifyElementText(findTestObject('Page_Appointment Confirmation/text_Appointment Information', [('appointment_info') : 'program']), 
    'Medicaid')

WebUI.verifyElementText(findTestObject('Page_Appointment Confirmation/text_Appointment Information', [('appointment_info') : 'visit_date']), 
    '30/10/2024')

WebUI.verifyElementText(findTestObject('Page_Appointment Confirmation/text_Appointment Information', [('appointment_info') : 'comment']), 
    'My comment')

WebUI.closeBrowser()

