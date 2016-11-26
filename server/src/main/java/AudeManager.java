import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/26.
 */
public class AudeManager {
    private static final Logger logger = LoggerFactory.getLogger(AudeManager.class);

    private Map<String, AudeSchedulerBean> schedulerBeanMap = new HashMap<String, AudeSchedulerBean>();
    //存储key与audeJob的映射关系
    private Map<String, AudeJob> audeJobMap = new HashMap<String, AudeJob>();

}
