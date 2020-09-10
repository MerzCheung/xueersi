package ming.zhang.crawler.mapper;

import ming.zhang.crawler.entity.CurriculumEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author merz
 * @Description:
 */
@Mapper
public interface XueersiMapper {

    Integer save(CurriculumEntity curriculumEntity);
}
