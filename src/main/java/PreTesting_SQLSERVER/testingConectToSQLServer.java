package PreTesting_SQLSERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class testingConectToSQLServer {
	
	@Test
	public static void selectQuery() throws SQLException, ClassNotFoundException {

		//	References:
		//		https://learn-automation.com/database-testing-using-selenium-webdriver/
		//		https://www.mysqltutorial.org/mysql-jdbc-tutorial/connecting-to-mysql-using-jdbc-driver/

		//	Other references:
		//		https://video.search.yahoo.com/search/video?fr=mcafee&p=installing+oracle+23+on+windows+11&type=E210US105G0#id=2&vid=c840293d3dddc8cd938c055be97107a0&action=click
		//		
		
		//		https://www.sqlservertutorial.net/getting-started/load-sample-database/
		//		https://github.com/kwenzel1/EssentialSQLSamples
		
		//		https://www.youtube.com/watch?v=Sw3eqsKvfCM
		//		https://www.zyxware.com/articles/5495/how-can-we-import-and-export-csv-file-in-selenium-java
		//		https://www.softwaretestingmaterial.com/mssql-database-testing-using-selenium/#:
		//		https://www.youtube.com/watch?v=fqMAt9igdzw
		//		https://www.baeldung.com/java-connect-mysql
		
		//		https://www.bing.com/search?pglt=41&q=jdbc+connection+url+for+sql+server&cvid=30bbfd1534e341cfaeb1ba0a8cfc6d5c&gs_lcrp=EgZjaHJvbWUqBggDEAAYQDIGCAAQRRg5MgYIARAAGEAyBggCEAAYQDIGCAMQABhAMgYIBBAAGEAyBggFEAAYQDIGCAYQABhAMgYIBxAAGEAyBggIEAAYQNIBCTE4MTQxajBqMagCCLACAQ&FORM=ANNTA1&PC=U531
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/connection-url-sample?view=sql-server-ver16
		//		https://www.bing.com/search?pglt=41&q=port+number+for+sqlserver+jdbc+connection&cvid=3d937c49e84a44618d1b25f9992957ad&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQABhAMgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEDSAQkyMTAxN2owajGoAgiwAgE&FORM=ANNTA1&PC=U531&ntref=1
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/system-requirements-for-the-jdbc-driver?view=sql-server-ver16
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/setting-the-connection-properties?view=sql-server-ver16
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/building-the-connection-url?view=sql-server-ver16
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/working-with-a-connection?view=sql-server-ver16
		//		https://learn.microsoft.com/en-us/sql/connect/jdbc/using-the-jdbc-driver?view=sql-server-ver16
		//		https://learn.microsoft.com/en-us/sql/sql-server/sql-server-get-help?view=sql-server-ver16
		//		
		//		https://www.bing.com/search?pglt=41&q=forname+class+for+sqlserver+jdbc&cvid=0e1f2f034eda40b197ddab7624595704&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQABhAMgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEDSAQkxNzAzMGowajGoAgiwAgE&FORM=ANNTA1&PC=U531
		//		https://learn.microsoft.com/en-us/sql/samples/adventureworks-install-configure?view=sql-server-ver16&tabs=ssms#download-backup-files
		//		https://learn.microsoft.com/en-us/sql/samples/adventureworks-install-configure?view=sql-server-ver16&tabs=ssms
		//		https://www.geeksforgeeks.org/how-to-download-and-install-adventureworks-database-in-sql/#
		//		https://video.search.yahoo.com/search/video?fr=mcafee&p=connection+string+for+sqlserver+by+mukesh+otwani&type=E210US105G0#id=34&vid=0bf70efc9e018959f60ff04db578ebf6&action=view

		//		Oracle 21c - Installation Guide
		//		https://video.search.yahoo.com/search/video?fr=mcafee&p=oracle+21c+enterprise+edition+download&type=E210US105G0#id=1&vid=acd6d29e83691a9cc7fcb8b17c6b153d&action=click
		//		https://www.atlassian.com/data/databases/how-to-fix-ora-12505-tns-listener-does-not-currently-know-of-sid-given-in-connect-descriptor

		/* 
		The syntax of database URL for SQL Server is as follows:
		jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		
		Where:
			serverName:
			host name or IP address of the machine on which SQL server is running.
			
			instanceName:
			name of the instance to connect to on serverName. The default instance is used if this parameter is not specified.
			
			portNumber:
			port number of SQL server, default is 1433. If this parameter is missing, the default port is used.
			
			property=value:
			specify one or more additional connection properties.
			 		
			To see the properties specific to SQL server, visit Setting the Connection Properties.
			
			NOTE:SQL Server has two authentication modes:
			
				Windows authentication:
					using current Windows user account to log on SQL Server.
			 		This mode is for the case both the client and the SQL server are running on the same machine.
			 		We specify this mode by adding the property integratedSecurity=true to the URL.
			 	SQL Server authentication:
			 		using a SQL Server account to authenticate. 
			 		We have to specify username and password explicitly for this mode.
			 			
			 Following are some examples:
			 	Connect to default instance of SQL server running on the same machine as the JDBC client, using Windows authentication:
			 		jdbc:sqlserver://localhost;integratedSecurity=true;
			 	Connect to an instance named sqlexpress on the host dbServer, using SQL Server authentication:
			 		jdbc:sqlserver://dbHost\sqlexpress;user=sa;password=secret
			 	Connect to a named database testdb on localhost using Windows authentication:
			 		jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;
	 	*/
		
		/**
		 Microsoft Windows [Version 10.0.22631.4112]	
			(c) Microsoft Corporation. All rights reserved.
			C:\Users\satya>netstat -a -n
			Active Connections
			  Proto  Local Address          Foreign Address        State
			  TCP    0.0.0.0:135            0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:445            0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:5040           0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:5357           0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:7680           0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:33060          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49664          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49665          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49666          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49667          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49669          0.0.0.0:0              LISTENING
			  TCP    0.0.0.0:49680          0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:1434         0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:5700         0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:8884         0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:15292        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:15393        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:16494        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:19292        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:28385        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:28390        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:49363        127.0.0.1:49364        ESTABLISHED
			  TCP    127.0.0.1:49364        127.0.0.1:49363        ESTABLISHED
			  TCP    127.0.0.1:49671        127.0.0.1:49672        ESTABLISHED
			  TCP    127.0.0.1:49672        127.0.0.1:49671        ESTABLISHED
			  TCP    127.0.0.1:49673        127.0.0.1:49674        ESTABLISHED
			  TCP    127.0.0.1:49674        127.0.0.1:49673        ESTABLISHED
			  TCP    127.0.0.1:59763        0.0.0.0:0              LISTENING
			  TCP    127.0.0.1:65439        127.0.0.1:65440        ESTABLISHED
			  TCP    127.0.0.1:65440        127.0.0.1:65439        ESTABLISHED
			  TCP    192.168.5.24:139       0.0.0.0:0              LISTENING
			  TCP    192.168.5.24:49351     44.213.226.101:443     ESTABLISHED
			  TCP    192.168.5.24:49355     44.213.226.101:443     ESTABLISHED
			  TCP    192.168.5.24:49424     40.83.247.108:443      ESTABLISHED
			  TCP    192.168.5.24:51632     44.213.226.101:443     ESTABLISHED
			  TCP    192.168.5.24:54840     52.112.38.146:443      ESTABLISHED
			  TCP    192.168.5.24:55059     20.25.241.18:443       ESTABLISHED
			  TCP    192.168.5.24:56402     172.202.248.79:443     ESTABLISHED
			  TCP    192.168.5.24:56428     57.152.69.41:443       ESTABLISHED
			  TCP    192.168.5.24:56446     162.159.61.4:443       ESTABLISHED
			  TCP    192.168.5.24:56453     52.113.194.16:443      ESTABLISHED
			  TCP    192.168.5.24:56488     20.127.250.238:443     ESTABLISHED
			  TCP    192.168.5.24:56489     172.202.248.68:443     ESTABLISHED
			  TCP    192.168.5.24:56505     20.44.8.230:8883       ESTABLISHED
			  TCP    192.168.5.24:56510     13.107.42.14:443       ESTABLISHED
			  TCP    192.168.5.24:56524     142.250.123.188:443    ESTABLISHED
			  TCP    192.168.5.24:56542     34.107.243.93:443      ESTABLISHED
			  TCP    192.168.5.24:56658     34.203.175.187:443     ESTABLISHED
			  TCP    192.168.5.24:56664     104.16.116.50:443      TIME_WAIT
			  TCP    192.168.5.24:56709     52.123.185.130:443     TIME_WAIT
			  TCP    192.168.5.24:56718     44.216.230.228:443     ESTABLISHED
			  TCP    192.168.5.24:56728     52.204.110.133:443     ESTABLISHED
			  TCP    192.168.5.24:56729     52.84.52.102:443       TIME_WAIT
			  TCP    192.168.5.24:56730     4.152.199.46:443       TIME_WAIT
			  TCP    192.168.5.24:56734     52.204.110.133:443     ESTABLISHED
			  TCP    192.168.5.24:56737     20.189.173.25:443      TIME_WAIT
			  TCP    192.168.5.24:56741     52.204.110.133:443     ESTABLISHED
			  TCP    192.168.5.24:56742     18.160.213.59:443      TIME_WAIT
			  TCP    192.168.5.24:56744     34.208.85.143:443      TIME_WAIT
			  TCP    192.168.5.24:56747     18.160.225.116:443     TIME_WAIT
			  TCP    192.168.5.24:56748     66.218.84.137:443      TIME_WAIT
			  TCP    192.168.5.24:56750     69.147.65.252:443      TIME_WAIT
			  TCP    192.168.5.24:56751     69.147.65.251:443      TIME_WAIT
			  TCP    192.168.5.24:56752     69.147.65.251:443      TIME_WAIT
			  TCP    192.168.5.24:56759     44.229.228.120:443     TIME_WAIT
			  TCP    192.168.5.24:56760     52.188.247.147:443     TIME_WAIT
			  TCP    192.168.5.24:56762     142.250.190.78:443     ESTABLISHED
			  TCP    192.168.5.24:56764     150.171.28.10:443      TIME_WAIT
			  TCP    192.168.5.24:56765     54.86.147.85:443       TIME_WAIT
			  TCP    192.168.5.24:56766     66.218.84.137:443      TIME_WAIT
			  TCP    192.168.5.24:56770     192.0.76.3:443         TIME_WAIT
			  TCP    192.168.5.24:56771     142.250.191.104:443    TIME_WAIT
			  TCP    192.168.5.24:56773     169.150.236.104:443    TIME_WAIT
			  TCP    192.168.5.24:56774     192.0.73.2:443         TIME_WAIT
			  TCP    192.168.5.24:56775     52.85.247.58:443       TIME_WAIT
			  TCP    192.168.5.24:56777     169.150.236.104:443    TIME_WAIT
			  TCP    192.168.5.24:56778     142.250.191.104:443    TIME_WAIT
			  TCP    192.168.5.24:56779     3.166.116.176:443      ESTABLISHED
			  TCP    192.168.5.24:56782     23.215.15.221:443      ESTABLISHED
			  TCP    192.168.5.24:56784     142.250.190.106:443    TIME_WAIT
			  TCP    192.168.5.24:56785     142.250.190.110:443    TIME_WAIT
			  TCP    192.168.5.24:56787     3.168.52.122:443       TIME_WAIT
			  TCP    192.168.5.24:56789     34.102.146.192:443     TIME_WAIT
			  TCP    192.168.5.24:56790     108.156.91.19:443      TIME_WAIT
			  TCP    192.168.5.24:56791     15.197.193.217:443     TIME_WAIT
			  TCP    192.168.5.24:56792     138.199.41.120:443     TIME_WAIT
			  TCP    192.168.5.24:56793     3.225.218.10:443       TIME_WAIT
			  TCP    192.168.5.24:56795     34.193.193.41:443      TIME_WAIT
			  TCP    192.168.5.24:56797     44.206.34.39:443       TIME_WAIT
			  TCP    192.168.5.24:56798     3.162.163.29:443       TIME_WAIT
			  TCP    192.168.5.24:56800     142.250.191.225:443    TIME_WAIT
			  TCP    192.168.5.24:56801     13.226.22.38:443       TIME_WAIT
			  TCP    192.168.5.24:56802     52.84.18.122:443       TIME_WAIT
			  TCP    192.168.5.24:56803     142.250.191.225:443    TIME_WAIT
			  TCP    192.168.5.24:56804     74.119.117.17:443      ESTABLISHED
			  TCP    192.168.5.24:56806     3.90.128.212:443       CLOSE_WAIT
			  TCP    192.168.5.24:56807     52.223.22.214:443      ESTABLISHED
			  TCP    192.168.5.24:56808     23.54.41.14:443        ESTABLISHED
			  TCP    192.168.5.24:56809     172.64.149.180:443     ESTABLISHED
			  TCP    192.168.5.24:56810     44.216.230.228:443     ESTABLISHED
			  TCP    192.168.5.24:56811     184.84.169.187:443     ESTABLISHED
			  TCP    192.168.5.24:56812     216.200.232.253:443    ESTABLISHED
			  TCP    192.168.5.24:56813     35.211.202.130:443     ESTABLISHED
			  TCP    192.168.5.24:56814     151.101.194.49:443     ESTABLISHED
			  TCP    192.168.5.24:56815     185.184.10.30:443      ESTABLISHED
			  TCP    192.168.5.24:56816     68.67.160.114:443      TIME_WAIT
			  TCP    192.168.5.24:56817     192.184.67.143:443     TIME_WAIT
			  TCP    192.168.5.24:56818     69.147.65.252:443      ESTABLISHED
			  TCP    192.168.5.24:56819     104.18.36.155:443      ESTABLISHED
			  TCP    192.168.5.24:56822     192.0.76.3:443         TIME_WAIT
			  TCP    192.168.5.24:56823     52.46.151.131:443      ESTABLISHED
			  TCP    192.168.5.24:56824     192.132.33.67:443      TIME_WAIT
			  TCP    192.168.5.24:56825     142.250.190.2:443      ESTABLISHED
			  TCP    192.168.5.24:56828     18.154.185.31:443      ESTABLISHED
			  TCP    192.168.5.24:56829     75.2.13.80:443         ESTABLISHED
			  TCP    192.168.5.24:56830     104.16.115.50:443      ESTABLISHED
			  TCP    192.168.5.24:56831     172.217.0.163:443      ESTABLISHED
			  TCP    192.168.5.24:56833     54.85.8.229:443        ESTABLISHED
			  TCP    192.168.5.24:56834     172.217.5.3:443        ESTABLISHED
			  TCP    192.168.5.24:56836     108.177.122.94:443     ESTABLISHED
			  TCP    192.168.5.24:56837     20.42.73.31:443        ESTABLISHED
			  TCP    192.168.5.24:56838     3.232.171.155:443      CLOSE_WAIT
			  TCP    192.168.5.24:56839     44.206.50.181:443      CLOSE_WAIT
			  TCP    192.168.5.24:56840     20.42.73.31:443        ESTABLISHED
			  TCP    192.168.5.24:56841     52.112.84.206:443      ESTABLISHED
			  TCP    192.168.5.24:62693     198.41.30.198:443      CLOSE_WAIT
			  TCP    [::]:135               [::]:0                 LISTENING
			  TCP    [::]:445               [::]:0                 LISTENING
			  TCP    [::]:3306              [::]:0                 LISTENING
			  TCP    [::]:5357              [::]:0                 LISTENING
			  TCP    [::]:7680              [::]:0                 LISTENING
			  TCP    [::]:33060             [::]:0                 LISTENING
			  TCP    [::]:49664             [::]:0                 LISTENING
			  TCP    [::]:49665             [::]:0                 LISTENING
			  TCP    [::]:49666             [::]:0                 LISTENING
			  TCP    [::]:49667             [::]:0                 LISTENING
			  TCP    [::]:49669             [::]:0                 LISTENING
			  TCP    [::]:49680             [::]:0                 LISTENING
			  TCP    [::1]:1434             [::]:0                 LISTENING
			  TCP    [::1]:5700             [::]:0                 LISTENING
			  TCP    [::1]:49670            [::]:0                 LISTENING
			  UDP    0.0.0.0:123            *:*
			  UDP    0.0.0.0:500            *:*
			  UDP    0.0.0.0:3702           *:*
			  UDP    0.0.0.0:3702           *:*
			  UDP    0.0.0.0:4500           *:*
			  UDP    0.0.0.0:5050           *:*
			  UDP    0.0.0.0:5353           *:*
			  UDP    0.0.0.0:5353           *:*
			  UDP    0.0.0.0:5353           *:*
			  UDP    0.0.0.0:5353           *:*
			  UDP    0.0.0.0:5353           *:*
			  UDP    0.0.0.0:5355           *:*
			  UDP    0.0.0.0:50629          142.250.191.131:443
			  UDP    0.0.0.0:51022          162.159.61.3:443
			  UDP    0.0.0.0:51306          8.8.4.4:443
			  UDP    0.0.0.0:51959          162.159.61.3:443
			  UDP    0.0.0.0:52113          8.8.4.4:443
			  UDP    0.0.0.0:53717          *:*
			  UDP    0.0.0.0:56194          162.159.61.3:443
			  UDP    0.0.0.0:57042          8.8.4.4:443
			  UDP    0.0.0.0:57073          8.8.4.4:443
			  UDP    0.0.0.0:57465          *:*
			  UDP    0.0.0.0:61070          172.64.41.3:443
			  UDP    0.0.0.0:62160          *:*
			  UDP    0.0.0.0:62396          *:*
			  UDP    0.0.0.0:62603          142.250.190.10:443
			  UDP    0.0.0.0:63723          142.250.191.206:443
			  UDP    127.0.0.1:1900         *:*
			  UDP    127.0.0.1:49665        127.0.0.1:49665
			  UDP    127.0.0.1:60150        *:*
			  UDP    192.168.5.24:137       *:*
			  UDP    192.168.5.24:138       *:*
			  UDP    192.168.5.24:1900      *:*
			  UDP    192.168.5.24:60149     *:*
			  UDP    [::]:123               *:*
			  UDP    [::]:500               *:*
			  UDP    [::]:3702              *:*
			  UDP    [::]:3702              *:*
			  UDP    [::]:4500              *:*
			  UDP    [::]:5353              *:*
			  UDP    [::]:5353              *:*
			  UDP    [::]:5353              *:*
			  UDP    [::]:5355              *:*
			  UDP    [::]:53717             *:*
			  UDP    [::]:57465             *:*
			  UDP    [::]:62161             *:*
			  UDP    [::1]:1900             *:*
			  UDP    [::1]:60148            *:*
			  UDP    [fe80::7b72:67bc:3dab:7475%22]:1900  *:*
			  UDP    [fe80::7b72:67bc:3dab:7475%22]:60147  *:*

			C:\Users\satya>
		 */
		
		//Load MS SQL JDBC Driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//String connectionUrl  = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true;integratedSecurity=true";
		String connectionUrl    = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true";
		String username         = "sai";
		String password         = "dbtstsel4";
		
		//Load MS SQL JDBC Driver
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Creating connection to the database
		Connection con = DriverManager.getConnection(connectionUrl,username,password);
		
		//Creating statement object
		Statement st       = con.createStatement();
		String selectquery = "SELECT * FROM OrangeHRM_SB";
		
		//Executing the SQL Query and store the results in ResultSet
		ResultSet rs = st.executeQuery(selectquery);
		
		//While loop to iterate through all data and print results
		while (rs.next()) {
			System.out.println("Userid from SQLSERVER    = " + rs.getString("userid"));
			System.out.println("Password  from SQLSERVER = " + rs.getString("password"));
		}
		
		//Closing DB Connection
		con.close();
	}
}