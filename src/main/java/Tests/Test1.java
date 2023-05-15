package Tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Test1 extends TestBase {
    @Test
    public void testLoginPage() throws InterruptedException {
        WebElement getStartButton = driver.findElement(By.cssSelector("a[class='btn btn-primary order-0 order-lg-1']"));
        getStartButton.click();
        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@href='https://ndcdyn.interactivebrokers.com/Universal/Application?pa=T'][normalize-space()='Create an Account']"));
        createAnAccountButton.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ndcdyn.interactivebrokers.com/Universal/Application?pa=T";
        Assert.assertEquals(actualUrl, expectedUrl);
        Faker faker = new Faker();
        Thread.sleep(4000);
        WebElement emailAdress = driver.findElement(By.id("emailAddress"));
        emailAdress.sendKeys(faker.internet().emailAddress());
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(faker.name().username().replaceAll("[^A-Za-z]", ""));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("tester12");
        Thread.sleep(3000);
        WebElement confirmPassword = driver.findElement(By.id("password2"));
        confirmPassword.sendKeys("tester12");
        WebElement country = driver.findElement(By.id("countryResidentialResidence_chosen"));
        country.click();
        WebElement country2 = driver.findElement(By.xpath("//div[@class='chosen-search']//input[@type='text']"));
        country2.sendKeys(faker.country().toString());
        country2.click();
        country.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(faker.name().lastName());
        WebElement dateOfBirth = driver.findElement(By.id("date"));
        Date randomDate = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(randomDate);
        String year = formattedDate.substring(0, 4);
        String month = formattedDate.substring(5, 7);
        String day = formattedDate.substring(8);
        dateOfBirth.sendKeys(year, month, day);

        WebElement security = driver.findElement(By.id("question0"));
        Select select = new Select(security);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
        WebElement answer1 = driver.findElement(By.id("answer0"));
        answer1.sendKeys("Table");

        WebElement security2 = driver.findElement(By.id("question1"));
        Select select1 = new Select(security2);
        List<WebElement> options1 = select1.getOptions();
        Random random1 = new Random();
        int randomIndex1 = random1.nextInt(options.size());
        select1.selectByIndex(randomIndex1);
        WebElement answer2 = driver.findElement(By.id("answer1"));
        answer2.sendKeys("Chair");

        WebElement security3 = driver.findElement(By.id("question2"));
        Select select2 = new Select(security3);
        List<WebElement> options2 = select2.getOptions();
        Random random2 = new Random();
        int randomIndex2 = random2.nextInt(options.size());
        select2.selectByIndex(randomIndex2);
        WebElement answer3 = driver.findElement(By.id("answer2"));
        answer3.sendKeys("Umbrella");
        WebElement agree = driver.findElement(By.id("paAgreement_positive"));
        agree.click();
        WebElement button = driver.findElement(By.id("accountCreationButton"));
        button.click();

    }

    @Test
    public void testEmail() throws InterruptedException {
        WebElement getStartButton = driver.findElement(By.cssSelector("a[class='btn btn-primary order-0 order-lg-1']"));
        getStartButton.click();
        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@href='https://ndcdyn.interactivebrokers.com/Universal/Application?pa=T'][normalize-space()='Create an Account']"));
        createAnAccountButton.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ndcdyn.interactivebrokers.com/Universal/Application?pa=T";
        Assert.assertEquals(actualUrl, expectedUrl);
        Faker faker = new Faker();
        Thread.sleep(2000);
        WebElement emailAdress = driver.findElement(By.id("emailAddress"));
        emailAdress.sendKeys("As");
        WebElement userName = driver.findElement(By.id("username"));
        userName.click();
        WebElement failedAlert = driver.findElement(By.cssSelector("div[class='alert alert-danger'] p"));
        String actualResult = failedAlert.getText();
        String expectedResult = "Invalid";
        Assert.assertEquals(actualResult, expectedResult);


    }

}

