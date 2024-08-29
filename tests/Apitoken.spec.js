const { test, expect,request } = require('@playwright/test');
const orderPayload={orders: [{country: "India", productOrderedId: "6581ca979fd99c85e8ee7faf"}]}
const loginPayload= {userEmail:"anshika@gmail.com", userPassword:"Iamking@000"};
    let token;
    let orderId;
    test.beforeAll(  async()=> {
    const api=await request.newContext();
    const loginResponse=await api.post("https://rahulshettyacademy.com/api/ecom/auth/login",
        {
            data:loginPayload
        }
    )
        expect(loginResponse.ok()).toBeTruthy();
        const loginResponseJson=loginResponse.json()
        token=loginResponseJson.token;
        console.log(token);
        const apiOrderResponse=await api.post("https://rahulshettyacademy.com/api/ecom/order/create-order",
            {
                data:orderPayload,
                headers:
                {
                    'Authorization':token,
                    'Content-Type':'application/json'
                }
                  
            }
        )
        expect(apiOrderResponse.ok()).toBeTruthy();
        const orderResponseJson=await apiOrderResponse.json()
        console.log(orderResponseJson)
        orderId=orderResponseJson.orders[0];


    });
    test.only('@logintest2', async ({ page }) => {
        //js file- Login js, DashboardPage
        page.addInitScript(value =>{
             window.localStorage.setItem('token',value);
        }, token);
       // await page.goto("https://rahulshettyacademy.com/client");
       // await page.locator("#userEmail").fill(email);
       // await page.locator("#userPassword").type("Iamking@000");
        //await page.locator("[value='Login']").click();
       // await page.waitForLoadState('networkidle');
        await page.goto("https://rahulshettyacademy.com/client")
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
    