package com.quora.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.ExtentReportListener.ExtentReportUtility;
import com.quore.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static String takeScreenShot() throws IOException {
		Calendar cal = Calendar.getInstance();
		long s = cal.getTimeInMillis();
		File screen = null;
		try{
			
				screen = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
			
			FileUtils.copyFile(screen, new File(
					"ReportGenerator/" + ExtentReportUtility.reportFolder + "/Screenshots/image" + s + ".png"));
			Files.deleteIfExists(Paths.get(screen.getAbsolutePath()));
		} catch (Exception e) {
			System.out.println(e);
		}
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		File srcFile = new File(
				"ReportGenerator/" + ExtentReportUtility.reportFolder + "/Screenshots/image" + s + ".png");
		fileInputStreamReader = new FileInputStream(
				new File("ReportGenerator/" + ExtentReportUtility.reportFolder + "/Screenshots/image" + s + ".png"));
		byte[] bytes = new byte[(int) srcFile.length()];
		fileInputStreamReader.read(bytes);
		//encodedBase64 = new String(Base64.encodeBase64(bytes));

		return srcFile.getAbsolutePath();

	}

	

	
}
