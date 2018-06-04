import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class wwsite{

    static WebDriver driver = new ChromeDriver();


    @BeforeSuite
    public static void setupChromeDriver() {

        System.setProperty("src/driver/chromedriver", "G:\\chromedriver.exe");
        driver.get("https://www.weightwatchers.com/us/");

    }
       @Test
       private static void TitleVarify(){

       String myTitle = driver.getTitle();

        System.out.println("Title is " + myTitle);

        String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";

        Assert.assertEquals(myTitle, expectedTitle);

        System.out.println("correct title");


    }

    @Test
    private static void FindMeeting(){

        driver.findElement(By.linkText("Find a Meeting")).click();

        String title2 = driver.getTitle();
        System.out.println(title2);
        Assert.assertTrue(title2.contains("Get Schedules & Times Near You"));
        System.out.println("matches");

       }

       @Test
       private static void searchMeeting() {


           WebElement searchbox = driver.findElement(By.id("meetingSearch"));
           searchbox.click();
           Actions builder = new Actions(driver);
           Action seriesOfActions = builder.moveToElement(searchbox).click().sendKeys(searchbox, "10001 ").build();
           seriesOfActions.perform();
       }

       @Test
       private static void locationSearch() {

           driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div/div/div/div/div[2]/div[1]/div/form/div[1]/span/button")).click();
           driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
           String searchresult = driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span")).getText();
           String distance;
           distance = driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]")).getText();

           System.out.println(searchresult + " " + distance);


           driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div")).click();
           driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

           String matchtitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span")).getText();

           Assert.assertEquals(searchresult, matchtitle);
           System.out.println("title matches");

       }
       @Test
               private static void TodaysHour(){

           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

           String Hours;
           Hours = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[1]/div")).getText();
           System.out.println(Hours);






    }}