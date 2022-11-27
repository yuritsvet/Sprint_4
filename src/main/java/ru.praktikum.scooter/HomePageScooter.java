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
    private By orderButtonInBottomOfPage = By.className("Button_Middle__1CSJM"); //кнопка заказать внизу страницы
    private By faqElements = By.className("Home_FAQ__3uVm4");
    // выдадающие поля FAQ
    public By[] listElements = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7"),
    };
    public By[] textInList = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7"),
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
        waitForBottomButtonLoad();
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
