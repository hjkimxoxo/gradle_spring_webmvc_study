package gradle_spring_webmvc_study.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.Member;

@Component
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Member> memberRowMapper = new RowMapper<Member>() {

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			String email = rs.getString("EMAIL");
			String password = rs.getString("PASSWORD");
			String name = rs.getString("NAME");
			LocalDateTime registerDateTime = rs.getTimestamp("REGDATE").toLocalDateTime();
			Member member = new Member(email, password, name, registerDateTime);
			member.setId(rs.getLong("ID"));

			return member;
		}

	};

	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* 결과가 1개 인 경우 */
	public Member selectByEmail(String email) {
		String sql = "SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER WHERE EMAIL = ?";
		return jdbcTemplate.queryForObject(sql, memberRowMapper, email);
	}

	public void insert(Member member) {
		String sql = "INSERT INTO MEMBER(EMAIL, PASSWORD, NAME, REGDATE) VALUES(?, ?, ?, ?)";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] { "id" });

				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

				return pstmt;
			}
		};

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());

	}

	public void update(Member member) {
		jdbcTemplate.update("update member set name=?, password=? where email=?", member.getName(),
				member.getPassword(), member.getEmail());
	}

	public void delete(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("delete from member where email=?");
				pstmt.setString(1, member.getEmail());
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
	}

	/* 결과가 1개 이상인 경우 */
	public List<Member> selectAll() {
		return jdbcTemplate.query("SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER", memberRowMapper);
	}

	/* 결과가 1개 인 경우 */
	public int count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
	}

	public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to) {
		String sql = "SELECT ID, EMAIL, PASSWORD, NAME, REGDATE FROM MEMBER WHERE regdate between ? and ? order by regdate desc";
		return jdbcTemplate.query(sql, memberRowMapper, from, to);
	}

	public Member selectById(Long memId) {
		String sql = "select * from member where id = ?";
		List<Member> results = jdbcTemplate.query(sql, memberRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}

}