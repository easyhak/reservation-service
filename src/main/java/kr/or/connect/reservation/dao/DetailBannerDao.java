package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DetailBanner;
import static kr.or.connect.reservation.dao.ReservationSqls.*;

@Repository
public class DetailBannerDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DetailBanner> rowMapper = BeanPropertyRowMapper.newInstance(DetailBanner.class);
    public DetailBannerDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public List<DetailBanner> selectImageById(int id){
    	Map<String, Integer> params = new HashMap<>();
    	params.put("id", id);
    	return jdbc.query(SELECT_DETAIL_IMAGE_BY_ID, params, rowMapper);
    }
}
