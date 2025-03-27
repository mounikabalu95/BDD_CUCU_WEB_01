package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {
    
    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/screenshots"; // Fixed folder

    // Create screenshots folder if not exists
    private static void createScreenshotFolder() {
        File folder = new File(SCREENSHOT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs(); // Create directory if it does not exist
            System.out.println("Screenshot folder created at: " + SCREENSHOT_FOLDER);
        }
    }

    // Method to take screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            createScreenshotFolder(); // Ensure the folder exists before saving screenshot

            // Capture screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create unique filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destFile = new File(SCREENSHOT_FOLDER + "/" + fileName + "_" + timestamp + ".png");

            // Save screenshot to folder
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
