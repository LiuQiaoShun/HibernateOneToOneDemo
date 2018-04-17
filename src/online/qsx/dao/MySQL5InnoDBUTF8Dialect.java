package online.qsx.dao;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5InnoDBUTF8Dialect extends MySQL5Dialect{
	@Override  
	public String getTableTypeString() {   
		return "ENGINE=InnoDB DEFAULT CHARSET=utf8";  
	} 
}

