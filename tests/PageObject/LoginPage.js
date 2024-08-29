class LoginPage{
    constructor(page)
    {
        this.page=page;
        this.signInButton=page.locator("[value='Login']");
        this.userName=page.locator("#userEmail");
        this.passWord= page.locator("#userPassword");

    }
    async goToUrl()
    {
        await this.page.goto("https://rahulshettyacademy.com/client");
    }
    async validLogin(userName,passWord)
    {
        await this.userName.type(userName);
        await this.passWord.type(passWord);
        await this.signInButton.click();
     


    }
   
}
module.exports={LoginPage}