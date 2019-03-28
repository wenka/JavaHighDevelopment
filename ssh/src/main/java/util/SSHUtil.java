package util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/02/26  上午 09:35
 * Description:
 */
public class SSHUtil {

    private volatile static SSHUtil sshUtil;

    private final static int SSH_PORT = 22;
    private final static int TIME_OUT = 600000;

    private Session session;
    private Channel channel;

    private SSHUtil(final String ipAddress, final String username, final String password) throws Exception {
        JSch jSch = new JSch();
        this.session = jSch.getSession(username, ipAddress, SSH_PORT);
        this.session.setConfig("StrictHostKeyChecking", "no");
        this.session.setTimeout(TIME_OUT);
        this.session.connect();
        this.channel = this.session.openChannel("shell");
        this.channel.connect(10000);
    }

    public static SSHUtil getInstance(final String ipAddress, final String username, final String password) throws Exception {
        if (sshUtil == null) {
            synchronized (SSHUtil.class) {
                if (sshUtil == null) {
                    sshUtil = new SSHUtil(ipAddress, username, password);
                }
            }
        }
        return sshUtil;
    }

    public String runShell(String command) throws Exception {
        String temp = null;

        InputStream instream = null;
        OutputStream outstream = null;

        try {
            instream = this.channel.getInputStream();
            outstream = this.channel.getOutputStream();
            outstream.write(command.getBytes());
            outstream.flush();
            TimeUnit.SECONDS.sleep(2);
            if (instream.available() > 0) {
                byte[] bytes = new byte[instream.available()];
                int read = instream.read(bytes);
                if (read < 0) {
                    throw new Exception("network error.");
                }
                temp = new String(bytes, 0, read, "UTF-8");
            }
        } finally {
            instream.close();
            outstream.close();
        }
        return temp;
    }

    public void close() {
        this.channel.disconnect();
        this.session.disconnect();
    }

    public static void main(String[] args) throws Exception {
        SSHUtil wk = SSHUtil.getInstance("192.168.111.128", "wk", "abc123..");
        wk.runShell("sh ~/shell/shell.sh");
        wk.close();
    }
}
