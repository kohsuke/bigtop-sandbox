package test;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.junit.FormatterElement;
import org.apache.tools.ant.taskdefs.optional.junit.FormatterElement.TypeAttribute;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTask;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTask.SummaryAttribute;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;

/**
 * @author Kohsuke Kawaguchi
 */
public class Driver {
    public static void main(String[] args) throws Exception {
        Project ant = new Project();
        DefaultLogger logger = new DefaultLogger();
        logger.setOutputPrintStream(System.out);
        logger.setErrorPrintStream(System.err);
        logger.setMessageOutputLevel(Project.MSG_INFO);

        ant.addBuildListener(logger);
        ant.setBasedir(".");

        JUnitTask task = new JUnitTask() {
            @Override
            protected void execute(JUnitTest arg) throws BuildException {
                super.execute(arg);
            }
        };
        task.setProject(ant);
        configureFormatter(task, "xml");
        configureFormatter(task, "brief");

        SummaryAttribute summary = new SummaryAttribute();
        summary.setValue("yes");
        task.setPrintsummary(summary);

        JUnitTest test = new JUnitTest();
        test.setName(JenkinsTest.class.getName());
        task.addTest(test);

        task.setTaskName("junit");
        task.execute();
    }

    private static void configureFormatter(JUnitTask task, String type) {
        FormatterElement fe = new FormatterElement();
        TypeAttribute xml = new TypeAttribute();
        xml.setValue(type);
        fe.setType(xml);
        task.addFormatter(fe);
    }
}
