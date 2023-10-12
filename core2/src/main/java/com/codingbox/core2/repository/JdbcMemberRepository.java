package com.codingbox.core2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.codingbox.core2.dto.Member;

//@Repository
public class JdbcMemberRepository implements MemberRepository{

	private final DataSource dataSource;
	
	public JdbcMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public Member save(Member member) {
		String sql = "INSERT INTO MEMBER values(member_seq.nextval,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String generatedColumns[] = {"ID"};
			pstm = conn.prepareStatement(sql,generatedColumns);
			pstm.setString(1, member.getName());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();
			if(rs.next()) {
				member.setId(rs.getInt(1));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<Member> findAll() {
		String sql = "SELECT * FROM MEMBER";	
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			rs  = pstm.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return members;
	}

}
