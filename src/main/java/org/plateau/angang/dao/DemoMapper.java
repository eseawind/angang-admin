package org.plateau.angang.dao;

import org.apache.ibatis.annotations.Select;
import org.plateau.angang.models.Demo;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper {
	
	@Select("select * from demo where id = #{value}")
	Demo getDemo(int id);

}
