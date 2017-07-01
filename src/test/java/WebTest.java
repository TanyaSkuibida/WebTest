import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by tanya on 28.06.2017.
 */
public class WebTest extends BaseTest{

    @Test
    public void firstWebTest (){
        driver.get("https://google.com.ua");
        MobileElement input = driver.findElement(MobileBy.xpath("//input[@id='lst-ib']"));
        input.sendKeys("dou");
        input.submit();

        //  input.getText();

        MobileElement elementByPartialLinkText = driver
                .findElementByPartialLinkText("DOU: Сообщество программистов");
        Assert.assertTrue(elementByPartialLinkText.isDisplayed());

        driver.findElementByPartialLinkText("Залишити цю мову").click();

        MobileElement clickToDou = driver.findElement(MobileBy.xpath("//a[@href=\"https://dou.ua/\"]"));
        clickToDou.click();

        MobileElement elementAfterClickToDou = driver.findElement(MobileBy.xpath("//div[@class=\"b-articles\"]"));
        Assert.assertTrue(elementAfterClickToDou.isDisplayed());

        MobileElement clickToPopular = driver.findElement(MobileBy.xpath("//*[@class=\"b-articles-switch\"]/li[2]/a"));
        clickToPopular.click();

        MobileElement elementAfterClickToPopular = driver.findElement(MobileBy.xpath("//ul[@id=\"fp-articles_top1m\"]"));
        Assert.assertTrue(elementAfterClickToPopular.isDisplayed());

        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.fillInStackTrace();
        }


    }

}
