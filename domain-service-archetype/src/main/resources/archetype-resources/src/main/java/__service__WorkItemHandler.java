#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;



public class ${service}WorkItemHandler implements WorkItemHandler {



	public void abortWorkItem(WorkItem item, WorkItemManager manager) {
		// TODO implement logic in case of cancel/abort scenario - if supported
		
	}

	public void executeWorkItem(WorkItem item, WorkItemManager manager) {
		// TODO implement logic of the work item
		
	}

}
