const {test, expect} = require('@playwright/test')
const {ai} = require('@zerostep/playwright')

test('Web Automation', async ({page}) => {
    await page.goto('https://www.saucedemo.com/v1/')
    await page.getByPlaceholder('Username').fill('standard_user')
    await page.getByPlaceholder('Password').fill('secret_sauce')
    await page.locator('#login-button').click()
    await expect ( page.locator("//div[.='Products']")).toHaveText('Products')
    await page.locator("//button[.='Open Menu']").click()
    await page.locator('#logout_sidebar_link').click()
})

test.only('AI-Web Automation', async ({page}) => {
    const aiArgs = {page, test}
    await page.goto('https://www.saucedemo.com/v1/')
    await ai('Enter Username as "standard_user"', aiArgs)
    await ai('Enter Password as "secret_sauce"', aiArgs)
    await ai('Click on LOGIN', aiArgs) 
    await expect ( page.locator("//div[.='Products']")).toHaveText('Products')
    await ai('Click on "Oprn Menu"', aiArgs)
    await ai('Click on Logout', aiArgs)

    await page.pause()

})