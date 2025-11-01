package dataProviders;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class DataProviders 
{
	@DataProvider(name = "register")
    public Object[][] getLoginData() {
        String path = "src\\test\\resources\\testData\\Registration.xlsx";
        List<Map<String, String>> list = ExcelUtils.getData(path, "register");

        Object[][] data = new Object[list.size()][1]; // one Map per test case
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);  // put each Map into Object[][]
        }
        return data;
    }
	
	
	@DataProvider(name = "transferData")
    public Object[][] getTransferData() 
	{
        return new Object[][] {
            // username, password, accountType, amount
            {"RisaUser0", "Pass@1231", "SAVINGS", "100"}
        };
    }
	
	
    @DataProvider(name = "loanRequestData")
    public Object[][] getLoanRequestData() {
        return new Object[][]{
            // username, password, loanAmount, downPayment, accountIndex
            {"RisaUser0", "Pass@1231", "100", "20", 0}
        };
    }
    
    @DataProvider(name = "updateProfileData")
    public Object[][] getUpdateProfileData() {
        return new Object[][]{
            // username, password, phone
           
            {"LisaUser0", "Pass@123", "8888877711"}
            
        };
    }

	
}
