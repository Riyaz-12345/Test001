const { test, expect,request } = require('@playwright/test');
test('table', async ({ page,context }) => {

    await page.goto("https://www.amazon.in/");
    await page.locator("//input[@type='text']").fill("mobile");
    await page.locator("//input[@id='nav-search-submit-button']").click();
    await page.locator("//div[@class='a-section aok-relative s-image-fixed-height']").first().click()
    const [newPage] = await Promise.all([
        context.waitForEvent('page'), // Waits for the new page to be created
        await page.locator("//div[@class='a-section aok-relative s-image-fixed-height']").first().click()
      ]);
      await newPage.locator("//input[@title='Add to Shopping Cart']").last().click()
      await newPage.locator("//a[@href='/cart?ref_=ewc_gtc']").click()
       
    
    
});