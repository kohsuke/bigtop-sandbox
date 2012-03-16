package test;

import org.apache.bigtop.itest.junit.OrderedParameterized.RunStage;
import org.apache.bigtop.itest.pmanager.PackageInstance;
import org.apache.bigtop.itest.pmanager.PackageManager;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * @author Kohsuke Kawaguchi
 */
@RunWith(OrderedRunner.class)
public class JenkinsTest {
    @RunStage(level=-3)
    @Test
    public void testInstallPackage() throws Exception {
        PackageManager pm = PackageManager.getPackageManager();
        List<PackageInstance> v = pm.search("gcc");
        for (PackageInstance pi : v) {
            System.out.println(pi.getName());
        }
        System.out.println(v);
        PackageInstance pkg = PackageInstance.getPackageInstance(pm, "jenkins");

        assert pkg.install()!=0;
    }

    @Test
    public void testFoo() throws Exception {
        System.err.println("Foo");
        throw new Error();
    }

//    public static void main(String[] args) {
//        JUnitCore junit = new JUnitCore();
//        junit.addListener(new TextListener(System.out));
//        junit.run(new Computer(), JenkinsTest.class);
//    }
}
