package myProject;

public class TestStrib {
	private static final String select = "SELECT"
										+" gatask.*, taskEvaluateLogInfo.taskEvaluateName,taskEvaluateLogInfo.taskEvaluateValue,taskEvaluateLogInfo.content evaluatecontent,gaTaskCustomer.customerId taskCustomerId,"
										+" taskEvaluateLogInfo.employeeName evaluateName,taskStatusInfo.content currStatuscontent,taskStatusInfo.taskStatusName currTaskStatusName,"
										+" gataskstatus.taskStatusName,gataskimportance.taskImportanceName,gataskimportance.displayColor importancecolor,gaemployee.employeeName creationName,"
										+" gataskimportance.description importancedescr,gatasktype.taskTypeName,gainteracttype.interactName,gataskexaminer.employeeId examinerId,gaoperationlog.message";
	public static void main(String[] args) {
		StringBuilder sql = new StringBuilder();
		sql.append(select);
		sql.append(" from");
		System.out.println(sql.toString());
		
		
	}
}
