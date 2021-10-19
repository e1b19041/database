package team11.lec04.database.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChamberMapper {

  @Select("SELECT id,user,number from chamber where id = #{id}")
  Chamber selectById(int id);

  @Select("SELECT * from chamber where number = #{number}")
  ArrayList<Chamber> selectAllByNumber(int number);

  @Select("select CHAMBER.USER,CHAMBER.NUMBER,USERINFO.HEIGHT from CHAMBER JOIN USERINFO ON CHAMBER.USER=USERINFO.USER;")
  ArrayList<ChamberUser> selectAllChamberUser();

  @Insert("INSERT INTO chamber (user,number) VALUES (#{user},#{number});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(Chamber chamber);

}
