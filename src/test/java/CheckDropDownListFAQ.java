import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;

public class CheckDropDownListFAQ {
        // класс проверки выпадающих списков ФАК
        private WebDriver driver;

        @Test
        public void faqTest() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePageScooter objHomePage = new HomePageScooter(driver);
            objHomePage.pushCookieButton();

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]"));
            String text1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p"), text1);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]"));
            String text2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p"), text2);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]"));
            String text3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p"), text3);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]"));
            String text4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p"), text4);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]"));
            String text5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p"), text5);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]"));
            String text6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p"), text6);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]"));
            String text7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p"), text7);

            objHomePage.clickListElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]"));
            String text8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
            isElementPassed(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"), text8);

        }
    public void isElementPassed(By elementPath, String elementText) {
        String text = driver.findElement(elementPath).getText();
        Assert.assertTrue(elementText, text.contains(elementText));
    }


        @After
    public void teardown() { driver.quit(); }

}
