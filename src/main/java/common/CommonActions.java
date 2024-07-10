package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;
import constants.Attribute;
import reports.Loggers;

public class CommonActions {
	public WebDriver driver;
	
	public static void elementDisplayed(WebElement element) {
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<---------> is Displayed, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	public static void elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enabled, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	public static void elementSelected(WebElement element) {
		try {
			boolean flag = element.isSelected();
			Loggers.logTheTest(element + "<---------> is Selected, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	// I will think to change it
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			Loggers.logTheTest("Actual Title is : " + actualTitle + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}
	
	public static void verifyCurrentUrl(WebDriver driver, String expectedURL) {
		String currentURL = driver.getCurrentUrl();
		Loggers.logTheTest("Current URL : " + currentURL + ", Expected URL : " + expectedURL);
		Assert.assertEquals(currentURL, expectedURL, "Current URL is not correct");
	}
		
	public static void verifyTextOfTheWebElement(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.logTheTest(element + " ---> Actual text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected, "Text In the WebElement doesn't match");
	}
	
	// common method for click ()
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			// e.printStackTrace();
			System.out.println("Exception is: " + e);
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			// getMessage() Returns the detail message string of this throwable.
		}
	}
	
	// common method for sleep()
	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);
			Loggers.logTheTest("Sleeping ... zZz " + sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Loggers.logTheTest("Sleep interrupted");
		}
	}
	
	// common method for sendKeys()
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
		}
	}

	public static void clickUsingJavascriptExecutor(WebDriver driver, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Loggers.logTheTest("Javascript Executor CLICKING ... on element ---> " + element);
	}	
	
	public static void scrollIntoViewUsingJavascriptExecutor(WebDriver driver, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		Loggers.logTheTest("Javascript Executor SCROLLING into view the element ---> " + element);
	}	
	
	// we will use it for sending value by JavascriptExecutor
	public static void usingJavascriptExecutor(WebDriver driver, String script, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript(script, element);
		Loggers.logTheTest("Javascript Executor executing ..." + script + " on element ---> " + element);
	}	
	
	public static void validationOfHeader(WebElement element, String expectedHeader) {
		String actualHeader = element.getText();
		Assert.assertEquals(actualHeader, expectedHeader, "Header doesn't match");
		Loggers.logTheTest(element + " ---> Actual Header : " + actualHeader + ". Expected Header : " + expectedHeader);
	}

	public static void validationOfSubHeader(WebElement element, String expectedSubHeader) {
		String actualSubHeader = element.getText();
		Assert.assertEquals(actualSubHeader, expectedSubHeader, "Sub Header doesn't match");
		Loggers.logTheTest(element + " ---> Actual Sub Header : " + actualSubHeader + ". Expected SubHeader : "
				+ expectedSubHeader);
	}
	
	public static void validationOfOtherHeader(WebElement element, String expectedOtherHeader) {
		String actualOtherHeader = element.getText();
		Assert.assertEquals(actualOtherHeader, expectedOtherHeader, "Other Header doesn't match");
		Loggers.logTheTest(element + " ---> Actual Other Header : " + actualOtherHeader + ". Expected Other Header : "
				+ expectedOtherHeader);
	}
	
	
	// Attribute is coming from package constants, we will check the outcome later
	public static String getAttributeValue(WebElement element, Attribute attribute) {
		String atr = attribute.getTheAttribute();
		 return element.getAttribute(atr);
	}

	public static void verifyAttribute01(WebElement element, Attribute attribute, String expectedValue) {
		String actualValue = getAttributeValue(element, attribute); // This method from above
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(element + " ---> We can Enter : " + actualValue
				+ " Character in the field which was similar with the Expected as: " + expectedValue);
		Assert.assertEquals(actualValue, expectedValue);
	}

	public static void verifyLengthOfTheFieldContent(WebElement element, String expected) {
		verifyAttribute01(element, Attribute.MAX_LENGTH, expected);
	}
	
	public static void inputTextThenClickTab(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.TAB);
			Loggers.logTheTest(
					input + " <-----> has been put into <-----> " + element + " and then clicked by Tab Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	// Loggers is changed only
	public static void verifyAttribute02(WebElement element, Attribute attribute, String expectedErrorMsg) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(
				element + " ---> Actual Error Message is : " + actual + ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(actual, expectedErrorMsg);
	}
	
	public static void verifyErrorMsgUnderTheField(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, Attribute.INNER_TEXT, expectedErrorMsg); // "innerHTML"
	}
	
	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			Loggers.logTheTest("The Text from the " + element + " ---> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	public static void selectElelementFromDropdownOnebyOne(WebElement element, List<WebElement> elements) {
		try {
			Select select = new Select(element);
			for (int i = 1; i < elements.size(); i++) {
				Loggers.logTheTest(elements.get(i).getText() + " is present in the dropdown");
				select.selectByIndex(i);
				pause(1);
			}
			Loggers.logTheTest("Total Element: " + (elements.size() - 1) + " is present in the dropdown");
		} catch (NullPointerException | NoSuchElementException e) { // elements er exception add korte hobe
			e.printStackTrace();
			Loggers.logTheTest(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public static void selectDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Loggers.logTheTest(value + " has been selected from the dropdown of ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public static void verifyAttribute03(WebElement element, Attribute attribute, String expectedErrorMsg) {
		String actual = getAttributeValue(element, attribute) + " is a required field.";
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(
				element + " ---> Actual Error Message is : " + actual + ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(actual, expectedErrorMsg);
	}
	
	public static void verifyErrorMsgTopOfThePage(WebElement element, String expectedErrorMsg) {
		verifyAttribute03(element, Attribute.INNER_TEXT, expectedErrorMsg); // "innerHTML"
	}
	
	public static void clickElementThenTab(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
			Loggers.logTheTest(element + "<---------> has been clicked, then click Tab Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	
	
	
	
	
	

	
	
	

	

	


	

	

	

	
	

	

	

	

	public static void inputTextThenClickEnter(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.ENTER);
			Loggers.logTheTest(
					input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void inputTextThenClickReturn(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.RETURN);
			Loggers.logTheTest(
					input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}



	public boolean isPresent(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		if (elements.size() != 0) {
			Loggers.logTheTest(elements + " --- > This element is present and has match of : " + elements.size());
			return true;
		} else {
			Loggers.logTheTest(elements + " --- > This element is NOT present and no match found : " + elements.size());
			return false;
		}
	}

	
	
	
	// very very important interview question
	public void failText() {
		Loggers.logTheTest(getClass().getMethods()[0].getName() + " ---> has failed");
		Assert.fail();
	}

	// very very important interview question
	public static String getSreenShot(String testName, WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "/test-output/screenShots";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String formattedDate = dateFormat.format(date);

		File targetFile = new File(path + "/error_" + testName + "_" + formattedDate + ".png");
		try {
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, targetFile);
			Loggers.logTheTest("Screenshot has been successfully capture at: \n" + targetFile.getAbsolutePath());
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
			Loggers.logTheTest("Screenshot cannot be captured");
		}
		return targetFile.getAbsolutePath();
	}

	public static void switchToChildWindow(WebDriver driver, WebElement element) {
		try {
			clickElement(element);
			Set<String> allWindowHandles = driver.getWindowHandles();
			Loggers.logTheTest("Total Windows Opened: " + allWindowHandles.size());
			String parent = (String) allWindowHandles.toArray()[0];
			String child = (String) allWindowHandles.toArray()[1];
			driver.switchTo().window(child);
			Loggers.logTheTest(" The Window moved to --> " + child);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	public static void verifyErrorMsg(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, Attribute.INNER_TEXT, expectedErrorMsg); //"innerHTML"
	}
	
}