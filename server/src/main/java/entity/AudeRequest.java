package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by lrkin on 2016/11/25.
 */
public class AudeRequest implements Serializable {
    //请求时间
    private Date requestTime;
    //要调用的class对象列表
    private Set<ClassInfo> classes;
    //是否需要响应,默认不需要
    private boolean needResponse = false;

    public AudeRequest(Date requestTime, Set<ClassInfo> classes, boolean needResponse) {
        this.requestTime = requestTime;
        this.classes = classes;
        this.needResponse = needResponse;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Set<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(Set<ClassInfo> classes) {
        this.classes = classes;
    }

    public boolean isNeedResponse() {
        return needResponse;
    }

    public void setNeedResponse(boolean needResponse) {
        this.needResponse = needResponse;
    }

    @Override
    public String toString() {
        return "MarbleRequest{" +
                "requestTime=" + (requestTime == null ? "" : requestTime.toString()) +
                ", classes=" + (classes == null ? "" : classes.toString()) +
                ", needResponse=" + needResponse +
                '}';
    }
}
