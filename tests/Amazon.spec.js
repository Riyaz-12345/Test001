const { test, expect,request } = require('@playwright/test');
test('table', async ({ page }) => {

    await page.goto("https://www.amazon.in/");
    await page.locator("//input[@type='text']").fill("mobile");
    await page.locator("//input[@id='nav-search-submit-button']").click();
    await page.locator("//div[@class='a-section aok-relative s-image-fixed-height']").first().click()
    const [newPage] = await Promise.all([
        context.waitForEvent('page'), // Waits for the new page to be created
        await page.locator("//div[@class='a-section aok-relative s-image-fixed-height']").first().click()
      ]);
    
    
});