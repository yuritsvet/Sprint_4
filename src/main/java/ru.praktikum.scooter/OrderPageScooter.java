package ru.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooter {
    private WebDriver driver; // создали драйвер

    // создаем локаторы для кнопок
    private By nameField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private By surnameField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private By addressField = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private By metroField = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    private By phoneField = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    private By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");
    // перешли на второй экран формы бронирования
    private By dateField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private By rentalPeriodField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]");
    private By commentField = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    private By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private By approveButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    private By successPopup = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]/text()");
    public OrderPageScooter(WebDriver driver){ // конструктор класса
        this.driver = driver;
    }

    //Методы
    public void waitForApproveButtonLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(approveButton));
    }
    public void setUserName(String userName) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(userName);
    }
    public void setUserSurname(String userSurname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(userSurname);
    }
    public void setUserAddress(String userAddress) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(userAddress);
    }
    public void setMetro() {
        driver.findElement(metroField).clear();
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(Keys.DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }
    public void setUserPhone(String userPhone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(userPhone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setDeliveryDate(String deliveryData) {
        driver.findElement(dateField).clear();
        driver.findElement(dateField).sendKeys(deliveryData);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }
    public void setRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]")).click();
    }
    public void setComment(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() { driver.findElement(orderButton).click(); }
    public void clickApproveButton() { driver.findElement(approveButton).click(); }

    public void waitForSuccessOrder(String success) {
        new WebDriverWait(driver, 3)
                .until (ExpectedConditions.textToBePresentInElementLocated (successPopup, success));
    }
}
