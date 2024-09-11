import { test, expect, Page } from '@playwright/test';
import { LoginPage } from './PageObject/LoginPage';
import { Dashboard } from './PageObject/Dashboard';

interface TestData {
  email: string;
  passWord: string;
  productName: string;
}

const dataset: TestData = require('./Utils/TestData.json');

test.only('@logiandOrder', async ({ page }: { page: Page }) => {
  // Initialize page objects
  const loginPage = new LoginPage(page);
  const dashboard = new Dashboard(page);
  
  // Perform login
  await loginPage.goToUrl();
  await loginPage.validLogin(dataset.email, dataset.passWord);
  
  // Wait for the page to be fully loaded
  await page.waitForLoadState('networkidle');
  
  // Search for product and add to cart
  await dashboard.searchProductAddCart(dataset.productName);
  await dashboard.navigateToCart();
  
  // Check for product in cart
  await page.locator("div li").first().waitFor();
  const productVisible = await page.locator("h3:has-text('zara coat 3')").isVisible();
  expect(productVisible).toBeTruthy();
  
  // Proceed to checkout
  await page.locator("text=Checkout").click();
  await page.locator("[placeholder*='Country']").type("ind");
  
  // Select country from dropdown
  const dropdown = page.locator(".ta-results");
  await dropdown.waitFor();
  const optionsCount = await dropdown.locator("button").count();
  for (let i = 0; i < optionsCount; ++i) {
    const text = await dropdown.locator("button").nth(i).textContent();
    if (text?.trim() === "India") {
      await dropdown.locator("button").nth(i).click();
      break;
    }
  }
  
  // Verify user email
  await expect(page.locator(".user__name [type='text']").first()).toHaveText(dataset.email);
  
  // Submit order
  await page.locator(".action__submit").click();
  await expect(page.locator(".hero-primary")).toHaveText("Thankyou for the order.");
  
  // Get and log order ID
  const orderId = await page.locator(".em-spacer-1 .ng-star-inserted").textContent();
  console.log(orderId);
  
  // Go to my orders and verify order details
  await page.locator("button[routerlink*='myorders']").click();
  await page.locator("tbody").waitFor();
  const rows = page.locator("tbody tr");
  
  for (let i = 0; i < await rows.count(); ++i) {
    const rowOrderId = await rows.nth(i).locator("th").textContent();
    if (orderId?.includes(rowOrderId || "")) {
      await rows.nth(i).locator("button").first().click();
      break;
    }
  }
  
  // Verify order details
  const orderIdDetails = await page.locator(".col-text").textContent();
  expect(orderId?.includes(orderIdDetails || "")).toBeTruthy();
});
