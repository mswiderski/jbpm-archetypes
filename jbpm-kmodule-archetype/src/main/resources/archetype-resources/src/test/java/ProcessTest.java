#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;

import bitronix.tm.resource.jdbc.PoolingDataSource;

public class ProcessTest extends JbpmJUnitBaseTestCase {

    public ProcessTest() {
        super(true, true);
    }

    @Test
    public void testProcessExecution() {
        
        createRuntimeManager("ScriptTask.bpmn2");
        RuntimeEngine engine = getRuntimeEngine();
        assertNotNull(engine);
        
        KieSession ksession = engine.getKieSession();
        
        ProcessInstance processInstance = ksession.startProcess("ScriptTask");
        
        assertProcessInstanceCompleted(processInstance.getId(), ksession);
    }
    
    
    /*
     * utility methods that override defaults
     * here you can configure to use different data base than default H2
     */
    protected PoolingDataSource setupPoolingDataSource() {
        PoolingDataSource pds = new PoolingDataSource();
        pds.setUniqueName("jdbc/jbpm-ds");
        pds.setClassName("bitronix.tm.resource.jdbc.lrc.LrcXADataSource");
        pds.setMaxPoolSize(5);
        pds.setAllowLocalTransactions(true);
        pds.getDriverProperties().put("user", "sa");
        pds.getDriverProperties().put("password", "");
        pds.getDriverProperties().put("url", "jdbc:h2:mem:jbpm-db;MVCC=true");
        pds.getDriverProperties().put("driverClassName", "org.h2.Driver");
        pds.init();
        return pds;
    }
}
