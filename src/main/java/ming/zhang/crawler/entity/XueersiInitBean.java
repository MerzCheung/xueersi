package ming.zhang.crawler.entity;


import java.util.HashMap;

/**
 * @author merz
 * @Description:
 */
public class XueersiInitBean {

    /**
     * 知识点
     */
    public static final HashMap<String, String> KNOWLEDGES = new HashMap<>();

    /**
     * 素养分类
     */
    public static final HashMap<String, String> LABELS = new HashMap<>();

    /**
     * 时段
     */
    public static final HashMap<String, String> TIMESLOTS = new HashMap<>();

    /**
     * 时间
     */
    public static final HashMap<String, String> TIMES = new HashMap<>();

    /**
     * 难度
     */
    public static final HashMap<String, String> DIFFICULTIES = new HashMap<>();

    /**
     * 版本
     */
    public static final HashMap<String, String> VERSIONS = new HashMap<>();

    /**
     * 学期
     */
    public static final HashMap<String, String> TERMS = new HashMap<>();

    /**
     * 进度
     */
    public static final HashMap<String, String> STUDYPHASES = new HashMap<>();

    static {
        STUDYPHASES.put("Level 0(零基础入门)", "90");
        STUDYPHASES.put("Level 1上", "100");
        STUDYPHASES.put("Level 1下", "101");
        STUDYPHASES.put("Level 2上", "102");
        STUDYPHASES.put("Level 2下", "103");
        STUDYPHASES.put("Level 3上", "104");
        STUDYPHASES.put("Level 3下", "105");
        STUDYPHASES.put("Level 4上", "106");
    }

    static {
        TERMS.put("春", "1");
        TERMS.put("夏", "2");
        TERMS.put("秋", "3");
        TERMS.put("寒", "4");
    }

    static {
        VERSIONS.put("全国版", "84");
        VERSIONS.put("非课改人教版", "106");
        VERSIONS.put("课改人教版", "107");
        VERSIONS.put("广州人教版", "108");
        VERSIONS.put("深圳北师版", "109");
        VERSIONS.put("非课改1452", "113");
        VERSIONS.put("非课改1245", "114");
        VERSIONS.put("全国文科", "123");
        VERSIONS.put("全国理科", "124");
        VERSIONS.put("Scratch创意编程", "128");
        VERSIONS.put("Python人工智能", "129");
        VERSIONS.put("NOIP信息学", "131");
        VERSIONS.put("选修四", "125");
        VERSIONS.put("选修五", "126");
    }

    static {
        DIFFICULTIES.put("求知（2星）", "159");
        DIFFICULTIES.put("敏学（3星）", "160");
        DIFFICULTIES.put("勤思（4星）", "161");
        DIFFICULTIES.put("创新（5星）", "162");
        DIFFICULTIES.put("未来（6星）", "163");
        DIFFICULTIES.put("目标一本班（2星）", "164");
        DIFFICULTIES.put("目标985班（3星）", "165");
        DIFFICULTIES.put("目标清北班（4星）", "166");
        DIFFICULTIES.put("目标自招综评班（5星）", "167");
        DIFFICULTIES.put("目标竞赛班（6星））", "168");
        DIFFICULTIES.put("兴趣（6星）", "170");
        DIFFICULTIES.put("目标A（2星）", "172");
        DIFFICULTIES.put("目标A+（3星）", "173");
        DIFFICULTIES.put("目标S（4星）", "174");
        DIFFICULTIES.put("目标S+（5星）", "175");
        DIFFICULTIES.put("目标SS（6星）", "176");
        DIFFICULTIES.put("目标未来（7星）", "177");
        DIFFICULTIES.put("勤学（2星）", "179");
        DIFFICULTIES.put("菁英（3星）", "180");
        DIFFICULTIES.put("目标（4星）", "181");
        DIFFICULTIES.put("素质素养（5星）", "182");
        DIFFICULTIES.put("提高（2星）", "184");
        DIFFICULTIES.put("勤学（3星）", "185");
    }

    static {
        TIMES.put("周一", "1140850689");
        TIMES.put("周二", "1140850690");
        TIMES.put("周三", "1140850691");
        TIMES.put("周四", "1140850692");
        TIMES.put("周五", "1140850693");
        TIMES.put("周六", "1140850694");
        TIMES.put("周日", "1140850695");
        TIMES.put("零期", "-364");
        TIMES.put("一期", "1073741825");
        TIMES.put("二期", "1073741826");
        TIMES.put("三期", "1073741827");
    }

    static {
        KNOWLEDGES.put("动力学", "1997");
        KNOWLEDGES.put("能量", "1998");
        KNOWLEDGES.put("动量", "1999");
        KNOWLEDGES.put("电磁感应", "2003");
        KNOWLEDGES.put("电场", "2000");
        KNOWLEDGES.put("恒定电流", "2001");
        KNOWLEDGES.put("机械振动与机械波", "2005");
        KNOWLEDGES.put("热学", "2006");
        KNOWLEDGES.put("化学计量与两大反应", "2007");
        KNOWLEDGES.put("元素及其化合物", "2008");
        KNOWLEDGES.put("电解质溶液综合", "2009");
        KNOWLEDGES.put("电化学", "2010");
        KNOWLEDGES.put("反应速率与平衡", "2011");
        KNOWLEDGES.put("有机化学", "2012");
        KNOWLEDGES.put("作文创作素材", "2033");
        KNOWLEDGES.put("诗词鉴赏", "2034");
        KNOWLEDGES.put("文言文阅读", "2035");
        KNOWLEDGES.put("文学与文化常识", "2037");
        KNOWLEDGES.put("集合逻辑", "1989");
        KNOWLEDGES.put("函数与导数", "1990");
        KNOWLEDGES.put("三角与向量", "1991");
        KNOWLEDGES.put("解析几何", "1993");
        KNOWLEDGES.put("立体几何", "1994");
        KNOWLEDGES.put("概率统计", "1995");
        KNOWLEDGES.put("词汇", "2025");
        KNOWLEDGES.put("语法", "2026");
        KNOWLEDGES.put("短文改错", "2031");
        KNOWLEDGES.put("写作", "2032");
        KNOWLEDGES.put("细胞的物质组成和基本结构", "2015");
        KNOWLEDGES.put("细胞代谢", "2016");
        KNOWLEDGES.put("细胞的生命历程", "2017");
        KNOWLEDGES.put("动、植物生命活动的调节", "2021");
        KNOWLEDGES.put("种群、群落和生态系统", "2022");
        KNOWLEDGES.put("现代生物科技专题", "2023");
        KNOWLEDGES.put("生物技术实践", "2024");
        KNOWLEDGES.put("公民政府", "2040");
        KNOWLEDGES.put("民主政治与国际社会", "2041");
        KNOWLEDGES.put("哲学综述", "2044");
        KNOWLEDGES.put("马克思主义哲学", "2045");
        KNOWLEDGES.put("旧民主主义革命", "2054");
        KNOWLEDGES.put("新民主主义革命", "2055");
        KNOWLEDGES.put("新中国的建设", "2056");
        KNOWLEDGES.put("先秦时期", "2057");
        KNOWLEDGES.put("中国古代政治史", "2141");
        KNOWLEDGES.put("地图工具", "2046");
        KNOWLEDGES.put("地球运动", "2047");
        KNOWLEDGES.put("气候专题", "2048");
        KNOWLEDGES.put("地貌专题", "2049");
        KNOWLEDGES.put("期中考试", "2216");
    }

    static {
        LABELS.put("人文", "1");
        LABELS.put("历史", "2");
        LABELS.put("艺术", "4");
        LABELS.put("能力", "5");
        LABELS.put("名著", "6");
        LABELS.put("视野", "7");
        LABELS.put("语文", "8");
        LABELS.put("军事", "9");
        LABELS.put("思维", "10");
    }

    static {
        TIMESLOTS.put("上午", "1");
        TIMESLOTS.put("下午", "2");
        TIMESLOTS.put("晚上", "4");
    }
}
