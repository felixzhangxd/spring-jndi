1. web.xml中增加
	<resource-ref>
		<description>jndi DB Connection</description>
		<res-ref-name>jdbc/spring_jndi</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>
	
2. spring配置中增加
	<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
		<property name="jndiName" value="java:comp/env/jdbc/spring_jndi" /><!--部分与web.xml中对应-->
	</bean>
	
3. 数据库驱动copy到${TOMCAT_HOME}/lib/
   如果使用c3p0连接池，也要copy到${TOMCAT_HOME}/lib/

4. dbcp
<Resource name="jdbc/spring_jndi" auth="Container" type="javax.sql.DataSource" 
	initialSize="3" maxActive="10" maxIdle="5" minIdle="3" maxWait="-1"
	removeAbandoned="true" removeAbandonedTimeout="300" logAbandoned="true"
	username="spring_jndi" password="spring_jndi" driverClassName="com.mysql.jdbc.Driver"
	url="jdbc:mysql://127.0.0.1:3306/spring_jndi?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true">
</Resource>

5. c3p0
<Resource name="jdbc/spring_jndi" auth="Container" type="com.mchange.v2.c3p0.ComboPooledDataSource"
	initialPoolSize="3" maxPoolSize="10" minPoolSize="10" acquireIncrement="2"
	maxIdleTime="60" autoCommitOnClose="true" checkoutTimeout="0"
	factory="org.apache.naming.factory.BeanFactory"
	user="spring_jndi" password="spring_jndi" driverClass="com.mysql.jdbc.Driver"
	jdbcUrl="jdbc:mysql://127.0.0.1:3306/spring_jndi?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true">
</Resource>