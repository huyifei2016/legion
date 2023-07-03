//package factoryAndData;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Factory;
//
//import commonfunction.Common;
//import testdata.PropsUtils;
//import testscript.TestScript1;
//
//public class TestCase1 {
////    @DataProvider(name = "2007")
////    public static Object[][] Data61() {
////        return Common.getFactoryData(new Object[][] {
////                {"US"}
////        },PropsUtils.getTargetStore("COMM2007"));
////
////    }
//
//    @Factory(dataProvider = "2007")
//    public Object[] createTest(String store) {
//
//        Object[] tests = new Object[1];
//
//        tests[0] = new TestScript1(store);
//
//        return tests;
//    }
//
//}
