package myProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eabax.test.SendMessageJDBC;
import com.sun.xml.internal.ws.resources.SenderMessages;

public class Test14 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		ResultSet record = null;
		conn = SendMessageJDBC.getConnection();
		PreparedStatement statement = null;
		String message = "云大大注册验证码："+189564+"。请您尽快完成注册。如非本人操作，请忽略本短信。";
		String getSequenceSql = "select DYMSG_ID.NEXTVAL FROM dual";
		statement = conn.prepareStatement(getSequenceSql);
		record = statement.executeQuery();
		record.next();
		long sequence = record.getLong("NEXTVAL");
		statement.close();
		record.close();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into DYHIKEMESSAGES (dymsgid,to_mobile,pay_mobile_tel,msg_content,cost,create_date,send_time,send_out_flag,prefix,presend_time,epid)");
		sql.append(" values (?,?,' ',?,0,sysdate,sysdate,0,'0000',sysdate,'cqjsp')");
		statement = conn.prepareStatement(sql.toString());
		statement.setLong(1, sequence);
		statement.setString(2, "18696725229");
		statement.setString(3, message);
		statement.execute();
		conn.close();
		statement.close();
	}
}
