package com.base;
import java.util.Date;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Rajesh
 * @Description to maintain all the value
 * @creationDate 27/06/2022
 *
 */

public class BaseClass {

	public static WebDriver driver;

	public static void browse(String browserType, String url) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(url);
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(url);
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.get(url);
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(url);
			break;

		default:
			System.out.println("enter valid browser and url");
			break;
		}
	}

	public static void webTitle() {
		// String title = driver.getTitle();
		System.out.println(driver.getTitle());
	}

	public static void webUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
	}

	public static WebElement findElementByClass(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static void sendData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public static String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		System.out.println(text);
		return text;
	}

	public static String getAttribute(WebElement element, String value) {
		String text = element.getAttribute(value);
		System.out.println(text);
		return text;
	}

	public static void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void rightClickPage(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public static void sendDataByActions(WebElement element, String data) {
		Actions actions = new Actions(driver);
		actions.sendKeys(data);
	}

	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void typeAlert(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}

	public static void typeByJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value','" + data + "')", element);
	}

	public static String getAttributeByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object value = executor.executeScript("argument[0].getAttribute('value')", element);
		return (String) value;
	}

	public static void clickByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	public static void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	public static void selectByIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.selectByIndex(i);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void deselectByIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.deselectByIndex(i);
	}

	public static List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public static int optionsCount(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		return size;
	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public static WebElement gettFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public static boolean isMultiSelector(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public static void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
	}

	public static void switchToFrameById(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public static void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchToDefaultPage() {
		driver.switchTo().defaultContent();
	}

	public static File takesScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public static void takesScreenshot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}

	public static File takesElementScreenshot(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public static void takesElementScreenshot(WebElement element, String path) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}

	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public static String parentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> allwindowIds() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public static void switchToWindowById(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
	}

	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void closeAllWindow() {
		driver.quit();
	}

	public static void closeCurrentWindow() {
		driver.close();
	}

	public static void staticWait(long sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	public static void implicitlyWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	 public void clear(WebElement element) {
		element.clear();

	}

	//getData
	public static String getData(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		String value = "";
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat();
				value = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();
			}
			break;

		default:
			System.out.println("");
			break;
		}
		return value;
	}

	public static void replaceDataInExcel(String path, String sheetName, int rowNo, int cellNo,String oldData, String newData) throws IOException {
		File file =new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue();
		if (value==oldData) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public static void createCellandInsertValue(String path, String sheetName, int rowNo, int cellNo,String data) throws IOException {
		File file =new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public static void createCellRowAndInsertValue(String path, String sheetName, int rowNo, int cellNo,String data) throws IOException {
		File file =new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public static void createWorkbookAndInsertValue(String path, String sheetName, int rowNo, int cellNo,String data) throws IOException {
		File file =new File(path);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public static String getPropertyFileInputValue(String Key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"//config.properties"));
		Object object = properties.get(Key);
		String value=(String) object;
		return value;	
}
}

