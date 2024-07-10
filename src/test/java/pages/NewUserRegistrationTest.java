package pages;

import org.testng.annotations.Test;
import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {
	//abcd
	
	@Test
	public void landingOnhomePageAndDirectingToNewUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
	}
	
	@Test
	public void stepOneClickOnCancelButtonDirectToHomePageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.stepOneClickOnCancelButtonDirectToHomePage();		
	}
		
	@Test
	public void stepTwoClickOnCancelButtonDirectToHomePageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoTitleAndHeaderValidation();
		newUserRegistration.stepTwoClickOnCancelButtonDirectToHomePage();
	}
	
	@Test
	public void stepTwoClickOnBackButtonDirectToPreviousPageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoClickOnBackButtonDirectToPreviousPage();
	}
	
	@Test
	public void clickOnNextButtonInStep2WithoutAnyDataTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.clickOnNextButtonInStep2WithoutAnyData();		
	}
	
	// Happy Path
	@Test
	public void clickOnNextButtonInStep2WithDataTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.untilClickOnNextButtonInStep2WithData();		
		newUserRegistration.step2NextValidation();
		newUserRegistration.stepThreeTitleAndHeaderValidation();
	}
	
	@Test
	public void stepTwoNewUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoTitleAndHeaderValidation();
		newUserRegistration.firstNameValidation();
		newUserRegistration.middleNameValidation();
		newUserRegistration.lastNameValidation();
		newUserRegistration.suffixValidation();
		newUserRegistration.birthMonthValidation();
		newUserRegistration.birthYearValidation();
		newUserRegistration.birthDateValidation();
 		// newUserRegistration.dobValidation();
		newUserRegistration.addressLine1Validation();
		newUserRegistration.addressLine2Validation();
		newUserRegistration.cityValidation();
		newUserRegistration.stateValidation();
		newUserRegistration.zipCodeValidation();
		newUserRegistration.zipCodePlus4Validation();
		newUserRegistration.emailValidation();
		newUserRegistration.emailConfirmValidation();
		newUserRegistration.phoneNumberValidation();
		newUserRegistration.step2NextValidation();
	}
	
	
	
	
	
	


}