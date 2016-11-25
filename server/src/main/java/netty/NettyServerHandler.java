package netty;

import entity.AudeRequest;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.LoggerFactory;

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

        
    }
}
