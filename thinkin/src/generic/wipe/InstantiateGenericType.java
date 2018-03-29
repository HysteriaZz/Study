package generic.wipe;


/**
 * Created by KaiLin.Guo on 2018-03-29.
 * Integer没有默认的构造函数因为它存在其他带参数构造函数，隐藏的默认构造函数就没有，
 * 正是因为这样实例化时因缺少参数而异常，Employee存在默认构造函数因为它不存在显示的构造函数
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ClassAsFactory<Integer> failed");
        }

    }
}

class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}

class Employee {}
