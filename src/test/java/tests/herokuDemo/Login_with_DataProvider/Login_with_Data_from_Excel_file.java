package tests.herokuDemo.Login_with_DataProvider;

public class Login_with_Data_from_Excel_file {
//    @Description("Apply DATA DRIVEN on feature Login")
//    @Test(dataProvider = "loginData", description = "Login by using data set")
//    public void login( String username, String password) {
//        System.out.println(username + "\t"+password);
//        WebDriver driver = DriverFactory.getChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/login");
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage
//                .inputUsername(username)
//                .inputPassword(password)
//                .clickSubmitBtn();
//        driver.quit();
//    }
//    @DataProvider
//    public Object[][] loginData(){
//        File excelFileLocation = new File("src/test/data/TestData.xlsx");
//        String sheet_name = "Sheet1";
//        int startRowIndex =1;
//        int startColIndex = 0;
//
//        ExcelReaderUtils excelReaderUtils = new ExcelReaderUtils(excelFileLocation,sheet_name,startRowIndex,startColIndex);
//        int totalRow=excelReaderUtils.getTotalRow();
//        int totalCol=excelReaderUtils.getTotalCol();
//
//        Object[][] loginData = new Object[totalRow-startRowIndex][totalCol-startColIndex];
//
//        for (int startRow = startRowIndex; startRow<totalRow;startRow++){
//            for(int startCol = startColIndex; startCol<totalCol;startCol++){
//                loginData[startRow - startRowIndex][startCol-startColIndex] = excelReaderUtils.getCellValues(startRow,startCol);
//            }
//        }
//        return loginData;
//    }
}
