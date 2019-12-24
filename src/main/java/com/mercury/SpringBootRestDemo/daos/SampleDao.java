package com.mercury.SpringBootRestDemo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.mercury.SpringBootRestDemo.beans.Sample;
import com.mercury.SpringBootRestDemo.utils.JdbcUtil;

@Repository
public class SampleDao {
	public void save(Sample sample){
		String sql = "insert into sample values(?,?)";
		try(Connection connection = JdbcUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);){
			ps.setString(1, sample.getName());
			ps.setInt(2, sample.getAge());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
