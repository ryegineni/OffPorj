package SampleProg;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import testrail.TestRail;

public class PageObjectsInit extends Helper {
	protected static AppiumDriver<WebElement> driver = null;

	protected String saptsUserName = readProperty("SAPTSuser");
	protected String saptsPassword = readProperty("SAPTSpwd");
	protected String maptsUsername = readProperty("MAPTSuser");
	protected String maptsPassword = readProperty("MAPTSpwd");
	protected String saptsLocAdminUser = readProperty("SAPTSLocAdminuser");
	protected String saptsLocAdminPassword = readProperty("SAPTSLocAdminpwd");
	protected String maptsSpanUserName = readProperty("MAPTSSpanUser");
	protected String maptsSpanPwd = readProperty("MAPTSSpanPwd");
	protected String saptsInactiveHQUserName = readProperty("SAPTSInactiveHQUser");
	protected String saptsInactiveHQPassword = readProperty("SAPTSInactiveHQPwd");
	protected String saptsInactiveLocAdminUserName = readProperty("SAPTSInactiveLocAdminUser");
	protected String saptsInactiveLocAdminPassword = readProperty("SAPTSInactiveLocAdminPwd");
	protected String saptsInactiveLocUserUserName = readProperty("SAPTSInactiveLocUserUserName");
	protected String saptsInactiveLocUserPassword = readProperty("SAPTSInactiveLocUserPwd");
	protected String saptsInactiveViewOnlyUserName = readProperty("SAPTSInactiveViewOnlyUserName");
	protected String saptsInactiveViewOnlyPassword = readProperty("SAPTSInactiveViewOnlyPwd");
	protected String saptsInactiveCallCenterUserName = readProperty("SAPTSInactiveCallCenterUserUserName");
	protected String saptsInactiveCallCenterUserPassword = readProperty("SAPTSInactiveCallCenterUserPwd");

	protected String hqLoc = appointmentSheet.getCell(0, 1).getContents();
	protected String hqStaff1 = appointmentSheet.getCell(1, 1).getContents();
	protected String hqStaff2 = appointmentSheet.getCell(1, 2).getContents();
	protected String hqRoom1 = appointmentSheet.getCell(2, 1).getContents();
	protected String hqRoom2 = appointmentSheet.getCell(2, 2).getContents();
	protected String hqService1 = appointmentSheet.getCell(3, 1).getContents();
	protected String hqService2 = appointmentSheet.getCell(3, 2).getContents();
	protected String hqAddOnService1 = appointmentSheet.getCell(4, 1).getContents();
	protected String hqAddOnService2 = appointmentSheet.getCell(4, 2).getContents();
	protected String subLocation = appointmentSheet.getCell(6, 1).getContents();
	protected String remoteStaff = appointmentSheet.getCell(7, 1).getContents();
	protected String remoteStaff2 = appointmentSheet.getCell(7, 2).getContents();
	protected String remoteStaff3 = appointmentSheet.getCell(7, 3).getContents();
	protected String remoteRoom = appointmentSheet.getCell(8, 1).getContents();
	protected String remoteRoom2 = appointmentSheet.getCell(8, 2).getContents();
	protected String remoteService = appointmentSheet.getCell(9, 1).getContents();
	protected String remoteService2 = appointmentSheet.getCell(9, 2).getContents();
	protected String remoteService3 = appointmentSheet.getCell(9, 3).getContents();
	protected String remoteAddOnService1 = appointmentSheet.getCell(10, 1).getContents();
	protected String remoteAddOnService2 = appointmentSheet.getCell(10, 2).getContents();
	protected String errorMsgTime = appointmentSheet.getCell(13, 1).getContents();
	protected String errorMsgRoom = appointmentSheet.getCell(13, 2).getContents();
	protected String apptTime = appointmentSheet.getCell(14, 1).getContents();

	private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	private static Calendar cal = Calendar.getInstance();
	private static Date newDate = cal.getTime();
	private static String useDate = dateFormat.format(newDate);

	protected static AuthenticationPage authPage = null;
	protected static AppointmentCreatePage apptCreatePage = null;
	protected static AppointmentGridPage apptGridPage = null;
	protected static CustomerPage customer = null;
	protected static GeneralUIPage generalUI = null;
	protected static ReservePage reserve = null;
	protected static CommonMethods common = null;

	static final String runID = "848";
	String Env = "pro";
	String Step = "";
	String Build = "Test";
	DesiredCapabilities capabilities = null;

	public AppiumDriver<WebElement> getDriver() {
		// if (driver == null) {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		capabilities.setCapability("deviceName", readProperty("deviceName"));
		capabilities.setCapability("udid", readProperty("deviceName"));
		capabilities.setCapability("platformVersion", readProperty("platformVersion"));
		// capabilities.setCapability("App", readProperty("APK"));
		capabilities.setCapability("appPackage", readProperty("appPackage"));
		capabilities.setCapability("appActivity", readProperty("appActivity"));

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			Set<String> context = driver.getContextHandles();
			System.out.println("Available contexts=" + context);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		threadSleep(5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// }
		authPage = new AuthenticationPage(driver);
		apptGridPage = new AppointmentGridPage(driver);
		apptCreatePage = new AppointmentCreatePage(driver);
		customer = new CustomerPage(driver);
		generalUI = new GeneralUIPage(driver);
		reserve = new ReservePage(driver);
		common = new CommonMethods();
		return driver;
	}

	@BeforeClass
	@Parameters({ "Env", "Build" })
	public void initialize(@Optional("pro") String Env, @Optional("Test.Disregard") String Build) {
		this.Env = Env;
		this.Build = Build;
	}

	@BeforeSuite
	public void startAppiumServer() throws InterruptedException {
		startServer();
		Thread.sleep(15000);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		// System.out.println("Starting appium server");
		// startServer();
		getDriver();
	}

	@AfterMethod
	public void updateTestResult(ITestResult result)
			throws IOException, URISyntaxException, NoSuchMethodException, SecurityException {

		// takeScreenShot(driver,result.getMethod().getMethodName());
		System.out.println("Closing app");

		driver.quit();
		/*
		 * Method testMethod = getClass().getMethod(result.getName()); TestData
		 * testData = testMethod.getAnnotation(TestData.class); String
		 * testRailID = testData.testRailId(); if (result.getStatus() ==
		 * ITestResult.FAILURE) { String screenshotPath = takeScreenShot(driver,
		 * result.getName() + "_" + testRailID); TestRail.addTRresult("Fail",
		 * testRailID, "Screenshot Path: " + screenshotPath + "\r\n\r\n" +
		 * "Exception Trace : " + String.valueOf(result.getThrowable()), Build,
		 * runID);
		 * 
		 * } else if (result.getStatus() == ITestResult.SUCCESS) {
		 * System.out.println("Test rail==========" + testRailID + Env + Build +
		 * runID); TestRail.addTRresult("Pass", testRailID, Env, Build, runID);
		 * }
		 */
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
		driver.quit();
		stopServer();
	}

	public void startServer() {
		System.out.println("Server starting");
		CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		cmd.addArgument(
				System.getProperty("user.home") + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		cmd.addArgument("--log-level", false);
		cmd.addArgument("error");
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String takeScreenShot(AppiumDriver<WebElement> driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + useDate + "\\"
					+ screenshotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Capturing screen shot of the page");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
			return e.getMessage();
		}
	}

	public void scrollApp() {
		System.out.println("Scrolling the page");
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = 0;
		int endY = (int) (startY * -1 * 0.5);
		TouchAction action = new TouchAction(driver);
		action.press(startX, startY).moveTo(endX, endY).release().perform();
	}

	public static void scrollTo(AppiumDriver<WebElement> driver, AndroidElement elm) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elm.getId());
		js.executeScript("mobile: scrollTo", scrollObject);
	}

	public static InputStream getJsonFileAsStream(String jsonFile) {
		return ClassLoader.getSystemResourceAsStream("/jsonFiles/" + jsonFile);
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestData {
		String testRailId() default "";
	}

	public List<String> getJSONFiles(String packageName) {
		String path = packageName.replaceAll("\\.", File.separator);
		List<String> files = new ArrayList<String>();
		String[] classPathEntries = System.getProperty("java.class.path").split(System.getProperty("path.separator"));

		String name;
		for (String classpathEntry : classPathEntries) {

			try {
				File base = new File(classpathEntry + File.separatorChar + path);
				for (File file : base.listFiles()) {
					name = file.getName();
					if (name.endsWith(".json")) {
						name = name.substring(0, name.length() - 5);
						files.add(name);
					}
				}
			} catch (Exception ex) {
			}
		}

		return files;

	}

	public static void reportTRFail(Throwable e, String testCase, String testStep, String build) {

		/*
		 * try { TestRail.addTRresult("Fail", testCase, testStep, build, runID);
		 * } catch (MalformedURLException e1) { // TODO Auto-generated catch
		 * block e1.printStackTrace(); }
		 */
		/*
		 * System.out.println(testCase); org.testng.Assert.fail("");
		 */
	}

	public static void reportRallyFail(Throwable e, String testCase, String testStep, String build)
			throws IOException, URISyntaxException {
		e.printStackTrace();
		System.out.println(testCase);
		org.testng.Assert.fail("");
	}

	public static void reportTRPass(String testCase, String env, String build) {
		/*
		 * try { TestRail.addTRresult("Pass", testCase, "", build, runID); }
		 * catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public static boolean getScreenshot(final String name) throws IOException {
		System.out.println("Capturing the snapshot of the page ");
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

}
