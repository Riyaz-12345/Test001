const { test, expect,request } = require('@playwright/test');
const table=[]
test('table', async ({ page }) => {

    await page.goto("https://www.w3schools.com/html/html_tables.asp");
   for(let i=1;i<=7;i++)
    {
        table.push(await page.locator("//table[@id='customers']//tr"+[i]+"//th").nth(i).allTextContents())
    }
    console.log(table)
    
});