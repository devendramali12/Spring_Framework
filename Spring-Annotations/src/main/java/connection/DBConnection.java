package connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

	@Value(value = "${db.pg.driver}")
	String driver;

	@Value(value = "${db.pg.url}")
	String url;

	@Value(value = "${db.pg.user}")
	String username;

	@Value(value = "${db.pg.pwd}")
	String password;

	public void dbCred() {
		System.out.println("Driver : " + driver);
		System.out.println("URL : " + url);
		System.out.println("UserName : " + username);
		System.out.println("Password : " + password);
	}
}
