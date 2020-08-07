import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CheckTests {

    public static void main(String[] args) {

        System.out.println("Hello World !!!");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        System.out.printf("dsa");

        WebElement searchField = driver.findElement(By.xpath("//input[@title='Пошук']"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='rc']"));
        System.out.println("Search results count: "+searchResults.size());

        int searchResultsCount = searchResults.size();

        if (searchResultsCount == 9) {
            System.out.println("Search results count is correct: "+searchResultsCount);
        }
        else {
            System.out.println("Search results count is incorrect: "+searchResultsCount);
        }

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
            if (searchResultText.toLowerCase().contains("selenium")) {
                System.out.println("SearchTerm found.");
            }
            else {
                System.out.println("SearchTerm not found.");
            }
        }
        driver.close();
    }
}
