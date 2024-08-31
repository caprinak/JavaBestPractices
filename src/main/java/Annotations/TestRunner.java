package Annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("Annotations.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    Class<? extends Throwable> excType =
                            m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
            if (m.isAnnotationPresent(ExceptionTest2.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Exception>[] excTypes =
                            m.getAnnotation(ExceptionTest2.class).value();
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }}