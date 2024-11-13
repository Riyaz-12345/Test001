const {LoginPage}=require('./PageObject/LoginPage');
const {Dashboard}=require('./PageObject/Dashboard');
const dataset=require("./Utils/TestData.json");
const { test, expect } = require('@playwright/test');

test('@logiandOrder', async ({ page }) => {
    //js file- Login js, DashboardPage
    const products = page.locator(".card-body");
    const loginPage=new LoginPage(page);
    await loginPage.goToUrl();
    await loginPage.validLogin(dataset.email,dataset.passWord);
    await page.waitForLoadState('networkidle'); 
    const dashboard=new Dashboard(page);
    await dashboard.searchProductAddCart(dataset.productName);
    await dashboard.navigateToCart();
    await page.locator("div li").first().waitFor();
    const bool = await page.locator("h3:has-text('zara coat 3')").isVisible();
    expect(bool).toBeTruthy();
    await page.locator("text=Checkout").click();
    await page.locator("[placeholder*='Country']").type("ind");
    const dropdown = page.locator(".ta-results");
    await dropdown.waitFor();
    const optionsCount = await dropdown.locator("button").count();
    for (let i = 0; i < optionsCount; ++i) {
    const text = await dropdown.locator("button").nth(i).textContent();
    if (text === " India") {
    await dropdown.locator("button").nth(i).click();
    break;
    }
    }
    await expect(page.locator(".user__name [type='text']").first()).toHaveText(dataset.email);
    await page.locator(".action__submit").click();
    await expect(page.locator(".hero-primary")).toHaveText(" Thankyou for the order. ");
    const orderId = await page.locator(".em-spacer-1 .ng-star-inserted").textContent();
    console.log(orderId);
    await page.locator("button[routerlink*='myorders']").click();
    await page.locator("tbody").waitFor();
    const rows = await page.locator("tbody tr");
    for (let i = 0; i < await rows.count(); ++i) {
    const rowOrderId = await rows.nth(i).locator("th").textContent();
    if (orderId.includes(rowOrderId)) {
    await rows.nth(i).locator("button").first().click();
    break;
    }
}
const orderIdDetails = await page.locator(".col-text").textContent();
expect(orderId.includes(orderIdDetails)).toBeTruthy();
});