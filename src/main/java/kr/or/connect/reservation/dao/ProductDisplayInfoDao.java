package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ProductDisplayInfo;
import static kr.or.connect.reservation.dao.ReservationSqls.*;
@Repository
public class ProductDisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ProductDisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(ProductDisplayInfo.class);
    public ProductDisplayInfoDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public List<ProductDisplayInfo> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL, params, rowMapper);
    }
    
    public List<ProductDisplayInfo> selectByCategory(Integer start, Integer limit, Integer categoryId){
    	Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		params.put("category_id", categoryId);
    	return jdbc.query(SELECT_BY_CATEGORY, params, rowMapper);
    }
}
