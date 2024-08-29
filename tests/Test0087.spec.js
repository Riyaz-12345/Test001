const { test, expect,request } = require('@playwright/test');
test('New_Application', async ({ page }) => {

    await page.goto("https://devservices.peoriaaz.gov");
    await page.waitForLoadState('networkidle'); 
    await page.locator("//body ").click();
    await page.waitForLoadState('networkidle'); 
})