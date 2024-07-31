package VSCodeExtension.WinApp;
import org.sikuli.script.*;

public class VSCodeSikuliAutomation {

    public static void main(String[] args) {
        try {
            // Set the path to the images directory
            String imageDir = "C:\\Path\\To\\Your\\Images\\";

            // Create a Screen object for capturing and interacting with the screen
            Screen screen = new Screen();

            // Load image files
            Pattern elementPattern = new Pattern(imageDir + "element.png");
            Pattern buttonPattern = new Pattern(imageDir + "button.png");

            // Open Visual Studio Code
            Runtime.getRuntime().exec("C:\\Path\\To\\Your\\Code.exe");

            // Wait for VS Code to open
            Thread.sleep(10000); // wait for 10 seconds

            // Click on the specific element
            if (screen.exists(elementPattern, 10) != null) {
                screen.click(elementPattern);
                System.out.println("Element clicked successfully.");
            } else {
                System.out.println("Element not found.");
            }

            // Click on another button or UI element
            if (screen.exists(buttonPattern, 10) != null) {
                screen.click(buttonPattern);
                System.out.println("Button clicked successfully.");
            } else {
                System.out.println("Button not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
