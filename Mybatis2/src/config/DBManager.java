package config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	private static DBManager instance = new DBManager();
	private SqlSessionFactory factory;
	
	private DBManager() {
	String resource = "db/Mybatis_config.xml";
	InputStream is;
	try {
		is = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(is); 
		factory.getConfiguration().addMapper(SQLMapper.class);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public SqlSession getSqlSession() {
		return factory.openSession(true);//true가 오토커밋이다!
	}

	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}


	
}
