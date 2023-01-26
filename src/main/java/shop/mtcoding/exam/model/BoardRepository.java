package shop.mtcoding.exam.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {

    public int insert(@Param("title") String title, @Param("userId") int userId);

    public List<Board> findAll();

    public Board findById(int id);

    public List<Board> findByUserId(int userId);

    public int updateById(@Param("id") int id, @Param("name") String name, @Param("price") int price,
            @Param("qty") int qty);

    public int deleteById(int id);
}
