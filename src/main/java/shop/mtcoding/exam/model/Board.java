package shop.mtcoding.exam.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.exam.util.DateUtil;

@Setter
@Getter
public class Board {
    private Integer id;
    private String title;
    private String userId;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DateUtil.format(createdAt);
    }
}
