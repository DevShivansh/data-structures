package com.udaan.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.udaan.entities.Screen;
import com.udaan.entities.ScreenDB;
import com.udaan.entities.SeatDB;

@Repository
public class ScreenRepository {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	class SeatRowMapper implements RowMapper<SeatDB> {
	    @Override
	    public SeatDB mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	SeatDB details = new SeatDB();
	        details.setId(rs.getInt("ID"));
	        details.setAisle(rs.getString("AISLE"));
	        details.setRow(rs.getString("ROW"));
	        details.setScreenId(rs.getInt("SCREEN_ID"));
	        details.setSeatNo(rs.getInt("SEAT_NO"));
	        details.setStatus(rs.getString("STATUS"));
	        
	    	return details;
	    }
	}
	
	
	public List<SeatDB> findUnreservedSeats(int screenId, String row) {
		return jdbcTemplate.query(
				"select * from seat where SCREEN_ID =" + screenId + " and ROW = '" + row + "' and status = 'false'",
				new SeatRowMapper());
	}
	
	

	
	public int reserveSeat(int screenId, String row, int seatNo) {
		return jdbcTemplate.update("update seat set status = 'true' where screen_id = ? and row = ? and seat_no = ? ",
	            new Object[] {
	            		screenId, row, seatNo
	            });
	}
	
	public int insertScreenRecord(Screen screen) {
        return jdbcTemplate.update("insert into screen (name) " + "values(?)",
            new Object[] {
            		screen.getName()
            });
    }
	
	public ScreenDB findScreenByName(String name) {
        return jdbcTemplate.queryForObject("select * from screen where name=?", new Object[] {
                name
            },
            new BeanPropertyRowMapper < ScreenDB > (ScreenDB.class));
    }
	
	
	
	public int insertSeatRecord(SeatDB seatDB) {
		
		
        return jdbcTemplate.update("insert into seat (seat_no,screen_id,row,status,aisle) " + "values(?,?,?,?,?)",
            new Object[] {
            		seatDB.getSeatNo(), seatDB.getScreenId(),seatDB.getRow(),seatDB.getStatus(),seatDB.getAisle()
            });
    }

}
