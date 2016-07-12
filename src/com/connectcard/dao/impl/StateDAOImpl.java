
package com.connectcard.dao.impl;

import com.connectcard.domain.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StateDAOImpl extends BaseDAOImpl {
    
    private DataSource cityStateDataSource;
    
    
    
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplateCity() {
        return new SimpleJdbcTemplate(cityStateDataSource);
    }
    
    public List<State> retrieveAllStates(){
        String sql = "SELECT * from state ";
        return (List<State>) getSimpleJdbcTemplateCity().query(sql, new StateRowMapper());
    }
    
    
    
    public class StateRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            State state = new State();
            state.setState(rs.getString("state"));
            state.setStateCode(rs.getString("state_code"));
            return state;
        }
    }
}
