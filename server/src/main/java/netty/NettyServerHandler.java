package netty;

import entity.AudeRequest;
import entity.ClassInfo;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.LoggerFactory;
import util.StringUtils;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lrkin on 2016/11/24.
 */
public class NettyServerHandler extends ChannelHandlerAdapter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    public NettyServerHandler() {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        AudeRequest request = (AudeRequest) msg;
        logger.info("Receive the aude request: {}", request);

        //默认执行成功
        Boolean operSuccess = true;
        //执行结果字符串
        StringBuilder resultSB = new StringBuilder();

        Set<ClassInfo> classInfoSet = request.getClasses();

        if (classInfoSet != null && classInfoSet.size() > 0) {
            //建立线程池准备执行
            ExecutorService threadPool = Executors.newFixedThreadPool(classInfoSet.size());
            for (final ClassInfo classInfo : classInfoSet) {
                if (classInfo != null && StringUtils.isNotBlank(classInfo.getClassName())) {
                    
                }
            }
        }
    }
}
