const {test, expect} = require('@playwright/test')

test('Web Automation', async ({page}) => {
    await page.goto('https://www.saucedemo.com/v1/')
    await page.getByPlaceholder('Username').fill('standard_user')
    await page.getByPlaceholder('Password').fill('secret_sauce')
    await page.locator('#login-button').click()
    await expect ( page.locator("//div[.='Products']")).toHaveText('Products')
    await page.locator("//button[.='Open Menu']").click()
    await page.locator('#logout_sidebar_link').click()
})
