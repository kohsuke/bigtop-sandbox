package test;

import org.apache.bigtop.itest.junit.OrderedParameterized.RunStage;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kohsuke Kawaguchi
 */
public class OrderedRunner extends BlockJUnit4ClassRunner {
    public OrderedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        List<FrameworkMethod> c = super.getChildren();
        Collections.sort(c, new Comparator<FrameworkMethod>() {
            public int compare(FrameworkMethod m1, FrameworkMethod m2) {
                RunStage r1 = m1.getAnnotation(RunStage.class);
                RunStage r2 = m2.getAnnotation(RunStage.class);
                return ((r1 != null) ? r1.level() : 0) -
                        ((r2 != null) ? r2.level() : 0);
            }
        });
        return c;
    }
}
