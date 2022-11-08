package ru.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageScooter {
    private WebDriver driver;
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By orderButtonInTopOfPage = By.className("Button_Button__ra12g"); //кнопка заказать вверху страницы
    private By orderButtonInBottomOfPage = By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button"); //кнопка заказать внизу страницы
    private By faqElements = By.xpath("/html/body/div/div/div/div[5]/div[2]");
    // выдадающие поля FAQ
    public By[] listElements = {
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]"),
    };
    public By[] textInList = {
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p"),
            By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"),
    };
    public HomePageScooter(WebDriver driver){ // конструктор класса
        this.driver = driver;
    }
    public void pushCookieButton(){
        driver.findElement(cookieButton).click(); //закрыли предупреждение о куках
    }
    public void pushButtonInTopOfPage() {
        driver.findElement(orderButtonInTopOfPage).click(); // нажимаем заказать вверху страницы
    }
    public void pushButtonInBottomOfPage() {
        scrollPage(orderButtonInBottomOfPage);
        driver.findElement(orderButtonInBottomOfPage).click();
    }
    public void waitForTopButtonLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonInTopOfPage));
    }
    public void waitForBottomButtonLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonInBottomOfPage));
    }
    public void scrollPage(By element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }
    public void waitForFAQTextLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(faqElements));
    }
    public String pathToString(int elementPath){
        return driver.findElement(textInList[elementPath]).getText(); }
    public void clickListElement(int elementNumber) {
        scrollPage(faqElements);
        driver.findElement(listElements[elementNumber]).click(); }
}
