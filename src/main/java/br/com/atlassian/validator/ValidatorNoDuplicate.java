package br.com.atlassian.validator;

import java.util.List;
import java.util.Map;

import org.ofbiz.core.entity.GenericEntityException;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.project.Project;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.InvalidInputException;
import com.opensymphony.workflow.Validator;
import com.opensymphony.workflow.WorkflowException;

public class ValidatorNoDuplicate implements Validator {

	public void validate(Map transientVars, Map arg1, PropertySet ps)
			throws InvalidInputException, WorkflowException {
		List<Long>  issueIds = null ;
		IssueManager issueManager = null ;
		Issue issueExpected = (Issue) transientVars.get("issue");
		Project project = issueExpected.getProjectObject();
		try {
			//issueManager = ComponentManager.getInstance().getIssueManager();
			// TODO verificar
			issueManager = null;
			issueIds =	 (List<Long>) issueManager.getIssueIdsForProject(project.getId());
		} catch (GenericEntityException e) {
			e.printStackTrace();
		}
		
		for (Long issueId : issueIds) {
			Issue projectIssue = issueManager.getIssueObject(issueId);
			if(projectIssue.getSummary().equals(issueExpected.getSummary())){
				throw new InvalidInputException("This issue already exist for this project!");
			}
		}

	}

}
