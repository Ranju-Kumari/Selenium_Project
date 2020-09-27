package com.mercurytoursflights.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author M1049131
 *  Purpose : Method to capture screenshot.
 */

public class Screenshot {

	public Screenshot() {
	}

	public static Date date = new Date();
	public static DateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	File file;

	public String takeScreenshot(WebDriver driver) {

		file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot_" + dateformat.format(date) + ".png";

		try {
			System.out.println("error");
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshot/" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String currentScreenshotPath = System.getProperty("user.dir") + "/screenshot/" + screenshotName;
		System.out.println(currentScreenshotPath);
		return currentScreenshotPath;
	}
}
