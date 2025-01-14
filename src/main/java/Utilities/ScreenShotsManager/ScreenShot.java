package Utilities.ScreenShotsManager;

import Utilities.BrowserSetUp.Driver;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends Driver {

    private static final LogManager logger = LogManager.getInstance();

    public ScreenShot(WebDriver driver) {
        super(driver);
    }

    public static void takeScreenShot(String photoPath) {
        // Define the directory path where screenshots will be saved
        String screenshotDirPath = "ScreenShots";
        File screenshotDir = new File(screenshotDirPath);

        try {
            // Ensure the screenshots directory exists
            if (!screenshotDir.exists()) {
                logger.info("Screenshot directory not found at: " + screenshotDirPath);
                if (screenshotDir.mkdirs()) {
                    String successMessage = "Screenshot directory created successfully at: " + screenshotDirPath;
                    logger.info(successMessage);
                    Allure.step(successMessage);
                } else {
                    String errorMessage = "Failed to create screenshot directory at: " + screenshotDirPath;
                    logger.error(errorMessage);
                    Allure.step(errorMessage);
                    throw new RuntimeException(errorMessage);
                }
            }

            // Generate a timestamp for unique screenshot names
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = photoPath + "_" + timestamp + ".jpg";
            String filePath = screenshotDirPath + "/" + screenshotName;

            // Capture the screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(filePath));

            String successMessage = "Screenshot saved at: " + filePath;
            logger.info(successMessage);
            Allure.step(successMessage);

            // Attach the screenshot to Allure report
            try (FileInputStream fileInputStream = new FileInputStream(screenshotFile)) {
                Allure.addAttachment("Screenshot", "image/jpg", fileInputStream.toString());
                logger.info("Screenshot attached to Allure report.");
                Allure.step("Screenshot attached to Allure report.");
            } catch (IOException e) {
                String errorMessage = "Error attaching screenshot to Allure report: " + e.getMessage();
                logger.error(errorMessage + e);
                Allure.step(errorMessage);
                throw new RuntimeException(errorMessage + e);
            }

        } catch (IOException e) {
            String errorMessage = "Error capturing screenshot or saving file: " + e.getMessage();
            logger.error(errorMessage + e);
            Allure.step(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
