const { test, expect,request } = require('@playwright/test');
test('table', async ({ page,context }) => {

    await page.goto("https://devservices.peoriaaz.gov");
    await page.waitForLoadState('networkidle');
    page.pause()
});