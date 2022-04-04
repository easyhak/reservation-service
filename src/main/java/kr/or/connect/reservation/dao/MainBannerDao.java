package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.MainBanner;
import static kr.or.connect.reservation.dao.ReservationSqls.*;
@Repository
public class MainBannerDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MainBanner> rowMapper = BeanPropertyRowMapper.newInstance(MainBanner.class);
	public MainBannerDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<MainBanner> selectMainBannerList(){
		return jdbc.query(SELECT_MAINBANNER, rowMapper);
	}
}
