const {test, expect} = require('@playwright/test')
const {ai} = require('@zerostep/playwright')
require('dotenv').config();

test('Web Automation', async ({page}) => {
    await page.goto('https://www.saucedemo.com/v1/')
    await page.getByPlaceholder('Username').fill('standard_user')
    await page.getByPlaceholder('Password').fill('secret_sauce')
    await page.locator('#login-button').click()
    await expect ( page.locator("//div[.='Products']")).toHaveText('Products')
    await page.locator("//button[.='Open Menu']").click()
    await page.locator('#logout_sidebar_link').click()
})

test('AI-Web Automation', async ({page}) => {
    const aiArgs = {page, test}
    await page.goto('https://www.saucedemo.com/v1/')
    await ai('Enter Username as "standard_user"', aiArgs)
    await ai('Enter Password as "secret_sauce"', aiArgs)
    await ai('Click on LOGIN', aiArgs)
    await ai('Verify that Products page is displayed', aiArgs)
    await ai('Click on "Add to cart" for the first product', aiArgs)
    await ai('Click on Open Menu', aiArgs)
    await ai('Click on Logout', aiArgs)
})


test('Searching the product in Amazon by AI', async ({page}) => {
        const aiArgs = {page, test}
        await page.goto('https://www.amazon.in')
        await ai('Enter search term as "Laptop"', aiArgs)
        await ai('Click on search button', aiArgs)
        await ai('Click on the 5th profile picture', aiArgs)
        await ai('click on first add to cart', aiArgs)
    })

    test('AI-GitHub Login and Search', async ({ page }) => {
    const aiArgs = { page, test };
    const username = process.env.GITHUB_USERNAME;
    const password = process.env.GITHUB_PASSWORD;
    await page.goto('https://github.com/login');
    await ai(`Enter Username as "${username}"`, aiArgs);
    await ai(`Enter Password as "${password}"`, aiArgs);
    await ai('Click on Sign in', aiArgs);
    await ai('Click on Search Icon', aiArgs);
    await ai('Enter search term as "playwright"', aiArgs);
    await ai('press enter', aiArgs);
    await expect(page).toHaveURL("https://github.com/search?q=playwright&type=repositories");
});

test.only('Submitting the form', async ({ page }) => {
    const aiArgs = { page, test };
    await page.goto(' https://demoqa.com/');
    await ai('scroll down', aiArgs)
    await ai('click on form', aiArgs);
    await ai('click on practice form', aiArgs);
    await ai('Enter "first name" as "Rahul"', aiArgs);
    await ai('Enter "last name" as "Rai"', aiArgs);
    await ai('Enter email as "rahul.rai@example.com"', aiArgs)
    await ai('Select the gender as "Male"', aiArgs)
    await ai('Enter mobile number as "1234567890"', aiArgs)
    await ai('Enter date of birth as "01 January 2000"', aiArgs)
    await ai('Enter subject as "Maths"', aiArgs)
    await ai('click on second Maths', aiArgs)
    await ai('scroll down', aiArgs)
    await ai('Select hobbies as "Sports"', aiArgs)
    await page.locator("//label[text()='Reading']").click()
    await page.locator("//label[text()='Music']").click()
    await page.locator("//textarea[@id='currentAddress']").fill("123 Main st")
    await ai('click on submit', aiArgs)
    await ai('verify form submission', aiArgs)
   
});

test('Submitting the form2 as', async ({ page }) => {
    const aiArgs = { page, test };
    await page.goto('https://demoqa.com/');
    await ai(
        'Scroll down and click on form and click on practice form and enter first name as "Rahul" and  last name as "Rai" and email as "rahul.rai@example.com" and select gender as "Male", enter mobile number as "1234567890", enter date of birth as "01 January 2000", enter subject as "Maths", click on second Maths, scroll down, select hobbies as "Sports", enter current address as "123 Main st", click on submit, and verify form submission',
        aiArgs
    );
    
});
