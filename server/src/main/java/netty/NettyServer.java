package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lrkin on 2016/11/24.
 */
public class NettyServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void run(int port) {
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ObjectDecoder(1024 * 1024,
                                    ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                            socketChannel.pipeline().addLast(new ObjectEncoder());
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_BACKLOG, port);
            //绑定端口,接受来的连接
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            logger.info("Started the service on port - {}", port);

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            workerGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            logger.error("Start the service on port -{} exception", port, e);
        }
    }

    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    private NettyServer() {
    }

    public static NettyServer getInstance() {
        return SingletonHolder.nettyServer;
    }

    public static class SingletonHolder {
        private static final NettyServer nettyServer = new NettyServer();
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                NettyServer.getInstance().run(8080);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                NettyServer.getInstance().run(9093);
            }
        }.start();
    }
}
