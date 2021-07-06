package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentConfig {

    public static ExtentReports config(){

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Zoopla Task Results");
        extentSparkReporter.config().setDocumentTitle("Zoopla Task");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester","Ashin Vijayan");

        return extentReports;


    }
}
