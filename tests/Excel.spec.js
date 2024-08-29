
const ExcelJs=require('exceljs');
const { test, expect,request } = require('@playwright/test');
async function excelTest(searchText,replaceText,filePath)
{
const workbook =new ExcelJs.Workbook();
await workbook.xlsx.readFile(filePath).then(function()
    
    {
        let output={row:-1,column:-1};
        const worksheet= workbook.getWorksheet('Sheet1');
        
    })
       async function readExcel(worksheet,searchText) {

        worksheet.eachRow((row,rowNumber) =>
            {
            
                    row.eachCell((cell,colNUmber) =>
                    {
                        //console.log(cell.value);
                        if(cell.value===searchText)
                        {
                            console.log(output.row=rowNumber)
                            console.log(output.column=colNUmber)
                        }
                    })
            }) 
            return output; 
        
       }

    const output=await readExcel(worksheet,searchText,filePath);


    const cell=worksheet.getCell(output.row,output.column)
    cell.value=replaceText;
    await workbook.xlsx.writeFile(filePath);
}

//excelTest("banana","republic","C://Users/riyazp/Downloads/DemoExe.xlsx",'Sheet1');
test('Upload download excel validation',async ({page})=>
    {
      const textSearch = 'Mango';
      const updateValue = '350';
      await page.goto("https://rahulshettyacademy.com/upload-download-test/index.html");
      const downloadPromise = page.waitForEvent('download');
      await page.getByRole('button',{name:'Download'}).click();
      await downloadPromise;
      excelTest(textSearch,updateValue,"C://Users/riyazp/Downloads/download.XLSX");
      await page.locator("#fileinput").click();
      await page.locator("#fileinput").setInputFiles(filePath);
    })
