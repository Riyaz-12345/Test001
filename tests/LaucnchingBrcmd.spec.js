const { chromium } = require('playwright');
const { test} = require('@playwright/test');

test('test08098', async () => {
  // Define the path to the Chrome executable
  const chromeExecutablePath = ' ; // Update this path if necessary

  // Launch the browser with specific arguments
  const browser = await chromium.launch({
    executablePath: chromeExecutablePath,  // Path to Chrome executable
    args: [
      '--incognito',                    // Open Chrome in incognito mode
      '--window-size=1280,800',         // Set window size
      '--disable-gpu',                  // Disable GPU acceleration
      '--no-sandbox',                   // Disable sandbox (for certain environments)
    ],
    headless: false                      // Set to true if you want to run in headless mode
  });

  // Create a new browser context and page
  const context = await browser.newContext();
  const page = await context.newPage();

  // Navigate to a URL
  await page.goto('https://example.com');

  // Perform actions or take screenshots if needed
  await page.screenshot({ path: 'example.png' });

  // Close the browser
  await browser.close();
});
