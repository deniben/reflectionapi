package forlearn;

public class PrivateClass {
    private int a = 25;

    @Test(a=2, b=5)
    public void test(int a, int b){
        System.out.println("a="+ a + " b="+ b);
    }
}
