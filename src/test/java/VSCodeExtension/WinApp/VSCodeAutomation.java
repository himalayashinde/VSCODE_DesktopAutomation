package VSCodeExtension.WinApp;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class VSCodeAutomation {
    private static WindowsDriver<WindowsElement> driver;

    public static void main(String[] args) {
        try {
        	
        	// Clean up previous session data (cookies equivalent)
            deleteVSCodeUserData();
            
            // Set up DesiredCapabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Users\\ADMIN\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "Himalaya-Laptop");

            // Initialize Windows Driver
            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Example: Open a file in VS Code
            // Assuming VS Code is open, send Ctrl+O to open the file dialog
            driver.findElementByName("Python").click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElementByName("Global").click();

            // Assuming the Open dialog is now in focus, enter the path to a file and open it
            // This may vary depending on your system setup
           // driver.findElementByName("File name:").sendKeys("C:\\Path\\To\\Your\\File.txt");
           // driver.findElementByName("Open").click();

            // Add more interactions as needed...
            
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    
    private static void deleteVSCodeUserData() {
        // Adjust this path based on your system and VS Code installation
        String userDataPath = System.getProperty("user.home") + "\\AppData\\Roaming\\Code\\User";
        deleteDirectory(new File(userDataPath));
    }

    private static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }


}



