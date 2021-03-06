package com.ziyue.website.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *  all System configuration here all module has default value
 */
@Slf4j
@Configuration
@Setter
@Getter
public class Commons {

    /*
      this is httpServer module
     */

    @Value("${website.server.datafile.path:/tmp}")
    private String SERVER_DATAFILE_PATH;
    @Value("${website.server.rpc.client.enble:false}")
    private boolean SERVER_RPC_CLIENT_ENABLE;

    /*
    this is master module
     */
    @Value("${website.master.zookeeper.root.path:/website/master}")
    private String MASTER_ZOOKEEPER_ROOT_PATH;

    // httpServer to master
    @Value("${website.master.rpc.server.port:9999}")
    private int MASTER_RPC_SERVER_PORT;

    // worker to master
    @Value("${website.master.rpc.worker.port:9991}")
    private int MASTER_PRC_WORKER_PORT;

    @Value("${website.master.thread.pool.size:1000}")
    private int MASTER_THREAD_POOL_SIZE;


    /*
    this is worker module
     */

    @Value("${website.worker.zookeeper.root.path:/website/worker}")
    private String WORKER_ZOOKEEPER_ROOT_PATH;


    @Value("${website.worker.rpc.server.port:9998}")
    private int WORKER_RPC_SERVER_PORT;

    /* this is sso module */

    @Value("${website.sso.zookeeper.root.path:/website/sso}")
    private String SSO_ZOOKEEPER_ROOT_PATH;

    @Value("${website.sso.rpc.port:9997}")
    private String SSO_RPC_PORT;

    /* database */
    // jdbc url
    @Value("${website.common.database.url:jdbc:mysql://140.143.132.21:8806/website}")
    private String DATABASE_URL;

    @Value("${website.common.database.password:root}")
    private String DATABASE_PASSWORD;

    @Value("${website.common.database.username:root}")
    private String DATABASE_USERNAME;

    @Value("${website.common.database.connect.pool.num:10}")
    private String DATABASE_CONNECT_POOL_NUM;

    /* fileServer */

    @Value("${website.fileserver.rpc.port:9996}")
    private int FILE_SERVER_RPC_PORT;

    @Value("${website.fileserver.data.basedir:/tmp}")
    private String FILE_SERVER_DATA_BASE_DIR;

    @Value("${website.fileserver.data.write.size:102400}")
    private long FILE_SERVER_DATA_WRITE_SIZE;

    @Value("${website.fileserver.zookeeper.root.path:/website/fileserver}")
    private String FILE_SERVER_ZOOKEEPER_ROOT_PATH;

    /*
    this is default setting that can not be change
     */
    public static final String OK_MSG = "ok";
    public static final int OK_STATUS = 200;
    public static final int ERROR_STATUS = 405;

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat format = new SimpleDateFormat(Commons.TIME_FORMAT);

    public synchronized static String TIME_STAMP() {
        return format.format(System.currentTimeMillis());
    }

    public static String VERSION() {
        try {
            InputStream in = Commons.class.getClassLoader().getResourceAsStream("version");
            @Cleanup
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            return bufferedReader.readLine();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    public static String HOST_ADDRESS () {
       try {
           return InetAddress.getLocalHost().getHostAddress();
       } catch (UnknownHostException e) {
           log.error(e.getMessage(), e);
           return null;
       }
    }
}

