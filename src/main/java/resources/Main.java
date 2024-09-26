import java.text.Annotation;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {




        System.out.println("Hello world!");
       /* ComparatorDemo comparatorDemo = new ComparatorDemo();
        comparatorDemo.test();*/
        //new MultipleFieldSort().test();
        new TypeTokenDemo().main();

       /* System.out.println(FullfeaturesEnum.Planet.EARTH.mass());
        new FullfeaturesEnum().main(FullfeaturesEnum.Planet.EARTH.mass());*/
       /* double a = 2e3;
        System.out.println(a);*/

 /*       System.out.println("my wages is " + EnumWithStrategy.PayrollDay.MONDAY.pay(300,8));
        OperationEnum.test();*/
        //Plant.test();
        NestedEnumMap.test();

/*        N ote that the class literal for the extended operation type  (ExtendedOperation.class) is passed from main to test to describe
         the set of extended operations. The class literal serves as a bounded type token*/
        ExtensibleEnum.test(ExtensibleEnum.ExtendedOperation.class,5,2);
        ExtensibleEnum.test2(Arrays.asList(ExtensibleEnum.ExtendedOperation.values()), 5, 2);
    }
}