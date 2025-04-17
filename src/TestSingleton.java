


public class TestSingleton {
    private static TestSingleton instance = new TestSingleton();
    private TestSingleton() {}
    public static TestSingleton getInstance() {
        return instance;
    }
}
