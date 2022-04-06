package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DetailLocation;
import static kr.or.connect.reservation.dao.ReservationSqls.*;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DetailLocationDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DetailLocation> rowMapper = BeanPropertyRowMapper.newInstance(DetailLocation.class);
    public DetailLocationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public DetailLocation getLocationInfoById(Integer id) {
    	Map<String, Integer> params = new HashMap<>();
    	params.put("id", id);
    	return jdbc.queryForObject(SELECT_LOCATION_BY_ID, params,rowMapper);
    }
}
