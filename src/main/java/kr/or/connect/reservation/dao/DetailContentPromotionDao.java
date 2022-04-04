package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DetailContentPromotion;
import static kr.or.connect.reservation.dao.ReservationSqls.*;

@Repository
public class DetailContentPromotionDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DetailContentPromotion> rowMapper = BeanPropertyRowMapper.newInstance(DetailContentPromotion.class);
    public DetailContentPromotionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public DetailContentPromotion selectContentPromotionById(Integer id) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("id", id);
    	return jdbc.queryForObject(SELECT_CONTENT_PROMOTION_BY_ID, params, rowMapper);
    }
}
