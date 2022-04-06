package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationComment;
import static kr.or.connect.reservation.dao.ReservationSqls.*;
@Repository
public class ReservationCommentDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationComment.class);
    public ReservationCommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public List<ReservationComment> selectCommentList(Integer id){
    	Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_COMMENT_BY_ID, params,rowMapper);
    }
    public double getAvgScore(Integer id) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("id", id);
    	return jdbc.queryForObject(SELECT_AVG_RATING_BY_ID, params, double.class);
    }
    public int getTotalCommentCount(Integer id) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("id", id);
    	return jdbc.queryForObject(SELECT_TOTAL_COMMENT_COUNT_BY_ID, params, Integer.class);
    }
}
