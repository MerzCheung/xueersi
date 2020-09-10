package ming.zhang.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author merz
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumEntity {
    private long id;
    private String province;
    private String switchGrade;
    private String switchSubject;
    private String switchType;
    private String terms;
    private String point;
    private String version;
    private String labels;
    private String studyPhases;
    private String difficulties;
    private String times;
    private String timeSlots;
    private String concreteTime;
    private String teacher;
    private String duration;
    private String rating;
    private String views;
}
